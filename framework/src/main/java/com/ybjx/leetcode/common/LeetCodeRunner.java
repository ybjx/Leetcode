package com.ybjx.leetcode.common;

import com.google.common.base.Strings;
import com.ybjx.leetcode.annotation.JudgeMethod;
import com.ybjx.leetcode.annotation.LeetCode;
import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.config.loader.TypeConstant;
import com.ybjx.leetcode.testcase.TestCase;
import com.ybjx.leetcode.testcase.TestSuit;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自定义leetcode junit执行器
 * @author ybjx
 * @date 2019/3/19 22:21
 */
public class LeetCodeRunner extends Runner implements Filterable {

    /**
     * 待测试的类
     */
    private Class targetClass;

    /**
     * 测试类的实例
     */
    private Object target;

    /**
     * 测试组
     */
    private TestSuit testSuit = new TestSuit();

    /**
     * 测试用例描述信息
     */
    private Map<Method, Description> descriptionCache = new HashMap<Method, Description>();

    /**
     * 测试用例方法缓存
     */
    private Map<Description, Method> methodCache = new HashMap<Description, Method>();

    /**
     * 测试用例关系
     */
    private Map<Description, TestCase> descToCase = new HashMap<Description, TestCase>();

    /**
     * 需要运行的测试用例列表
     */
    private List<Description> needRunDescriptionList = null;

    /**
     * 自定义判断方法
     */
    private Method judgeMethod = null;

    /**
     * 测试方法
     */
    private List<Method> methods = new ArrayList<Method>();

    /**
     * 自定义junit runner
     * @param clazz 测试类
     */
    public LeetCodeRunner(Class clazz) throws Exception {
        this.targetClass = clazz;
        target = this.targetClass.newInstance();
        testSuit.load(getDataUrl(clazz));

        Method[] methods = this.targetClass.getMethods();
        for(Method method: methods){
            if(method.getAnnotation(JudgeMethod.class) != null){
                if(this.judgeMethod != null){
                    throw new LeetCodeException("自定义判断方法只能有一个！");
                }
                this.judgeMethod = method;
                continue;
            }
            if(method.getAnnotation(LeetCodeSolution.class) == null){
                continue;
            }
            this.methods.add(method);
        }
    }

    /**
     * 获取runner的用例描述
     * @return 用例描述
     */
    @Override
    public Description getDescription() {
        Description spec = Description.createSuiteDescription(this.targetClass.getName(), this.targetClass.getAnnotations());
        if(needRunDescriptionList == null){
            needRunDescriptionList = new ArrayList<Description>();
            for(Method method: this.methods){
                needRunDescriptionList.add(getMethodDescription(method));
            }
        }
        for(Description description: needRunDescriptionList){
            spec.addChild(description);
        }
        return spec;
    }

    /**
     * 执行测试用例
     * @param runNotifier 运行通知
     */
    @Override
    public void run(RunNotifier runNotifier) {
        for(Description d: needRunDescriptionList){
            runNotifier.fireTestStarted(d);
            Method method = methodCache.get(d);
            for(Description desc: d.getChildren()){
                doTestCase(runNotifier, desc, method);
            }
            runNotifier.fireTestFinished(d);
        }
    }

    /**
     * 执行指定方法时会进行guol
     * @param filter 过滤取
     * @throws NoTestsRemainException
     */
    public void filter(Filter filter) throws NoTestsRemainException {
        needRunDescriptionList = new ArrayList<Description>();
        for(Method method: methods){
            Description desc = Description.createTestDescription(this.targetClass, method.getName());
            if(filter.shouldRun(desc)){
                needRunDescriptionList.add(getMethodDescription(method));
            }
        }
    }

    /**
     * 执行测试用例
     * @param runNotifier 测试通知
     * @param desc 测试用例描述信息
     * @param method 测试方法
     */
    private void doTestCase(RunNotifier runNotifier, Description desc, Method method){
        runNotifier.fireTestStarted(desc);
        TestCase testCase = descToCase.get(desc);
        if(testCase == null){
            runNotifier.fireTestFailure(new Failure(desc, new LeetCodeException("测试用例没有找到！")));
            return;
        }

        try{
            Object obj = null;
            long count = 0;
            for(int i = 0; i < testCase.getTimes(); i++){
                testSuit.reloadTestCase(testCase);
                long time = System.nanoTime();
                obj = method.invoke(target, testCase.getParams().toArray());
                count += (System.nanoTime() - time);
                if(!testSuit.getObjectType().getResult().equalsIgnoreCase(TypeConstant.VOID)){
                    boolean resultOk = false;
                    for(Object r: testCase.getResult()){
                        if(checkEqual(r, obj)){
                            resultOk = true;
                            break;
                        }
                    }
                    if(!resultOk){
                        printResult(testCase, obj, count);
                        runNotifier.fireTestFailure(new Failure(desc, new LeetCodeException("返回值错误！")));
                        return;
                    }
                }
                if(judgeMethod != null){
                    try{
                        List<Object> l = new ArrayList<Object>();
                        if(!testSuit.getObjectType().getResult().equalsIgnoreCase(TypeConstant.VOID)){
                            l.add(obj);
                        }
                        l.addAll(testCase.getParams());
                        l.addAll(testCase.getResultParam());
                        judgeMethod.invoke(target, l.toArray());
                    }
                    catch (Exception e){
                        printResult(testCase, obj, count);
                        runNotifier.fireTestFailure(new Failure(desc, new LeetCodeException("自定义判断不通过！")));
                        return;
                    }
                }
            }
            printResult(testCase, obj, count);
        }
        catch (Exception e){
            runNotifier.fireTestFailure(new Failure(desc, new LeetCodeException("执行方法出错！", e)));
            return;
        }
        runNotifier.fireTestFinished(desc);
    }

    /**
     * 获取测试类全部的用例文件地址
     * @param clazz 测试类
     * @return 用例文件列表
     */
    private List<String> getDataUrl(Class clazz){
        List<String> list = new ArrayList<String>();

        LeetCode leetCode = (LeetCode)clazz.getAnnotation(LeetCode.class);
        if(leetCode == null){
            String [] pkgList = clazz.getPackage().getName().split("\\.");
            list.add("/" + pkgList[pkgList.length - 1] + "/" + clazz.getSimpleName() + ".json");
            return list;
        }
        if(leetCode.useDefaultData()){
            String [] pkgList = clazz.getPackage().getName().split("\\.");
            list.add("/" + pkgList[pkgList.length - 1] + "/" + clazz.getSimpleName() + ".json");
        }
        for(String str: leetCode.dataUrl()){
            if(!Strings.isNullOrEmpty(str)) {
                list.add(str);
            }
        }
        return list;
    }

    /**
     * 获取测试方法对应的description
     * @param method 测试方法
     * @return runner的description
     */
    private Description getMethodDescription(Method method){
        Description desc = descriptionCache.get(method);
        if(desc == null){
            LeetCodeSolution solution = method.getAnnotation(LeetCodeSolution.class);
            String name = solution.name();
            if(Strings.isNullOrEmpty(name)){
                name = method.getName();
            }
            desc = Description.createSuiteDescription(name);
            descriptionCache.put(method, desc);
            methodCache.put(desc, method);
            List<TestCase> list = testSuit.getTestCases();
            for(int i = 0; i < list.size(); i++){
                name = list.get(i).getName();
                if(Strings.isNullOrEmpty(name)){
                    name = "测试用例"+ (i + 1);
                }
                Description d = Description.createTestDescription("", name);
                desc.addChild(d);
                descToCase.put(d, list.get(i));
            }
        }
        return desc;
    }

    /**
     * 判断两个对象是否相等，会深入比对
     * @param obj1 对象1
     * @param obj2 对象2
     * @return true--相等，false--不相等
     */
    private boolean checkEqual(Object obj1, Object obj2){
        if(obj1 == null && obj2 == null){
            return true;
        }
        if(obj1 == null || obj2 == null){
            return false;
        }
        if(obj1.getClass().isArray()){
            if(!obj2.getClass().isArray()){
                return false;
            }
            int len = Array.getLength(obj1);
            if(len != Array.getLength(obj2)){
                return false;
            }
            for(int i = 0; i < len; i++){
                if(!checkEqual(Array.get(obj1, i), Array.get(obj2, i))){
                    return false;
                }
            }
            return true;
        }
        else if(obj1.getClass().equals(Float.class)){
            Float f1 = (Float)obj1;
            Float f2 = (Float)obj2;
            return (f1 -f2 < 0.0000001) || (f2 - f1 < 0.0000001);
        }
        else if(obj1.getClass().equals(Double.class)){
            Double d1 = (Double)obj1;
            Double d2 = (Double)obj2;
            return (d1 -d2 < 0.0000001) && (d2 - d1 < 0.0000001);
        }
        else{
            return obj1.equals(obj2);
        }
    }

    /**
     * 打印执行输出内容
     * @param testCase 测试用例
     * @param result 执行结果
     * @param time 执行时间
     */
    private void printResult(TestCase testCase, Object result, long time){
        System.out.println("入参：");
        System.out.println(Constant.LEFT_SQUARE_BRACKET);
        for(Object obj: testCase.getParamsFixed()){
            printObject(obj, 1);
        }
        System.out.println(Constant.RIGHT_SQUARE_BRACKET);
        System.out.println("预期结果：");
        for(Object obj: testCase.getResult()){
            printObject(obj, 0);
        }
        for(Object obj: testCase.getResultParam()){
            printObject(obj, 0);
        }
        System.out.println("预期执行次数：" + testCase.getTimes());
        System.out.println("耗时：" + (time / 1000000.0) + "ms");
        if(judgeMethod != null){
            System.out.println("执行结果：");
            System.out.println(Constant.LEFT_SQUARE_BRACKET);
            for(Object obj: testCase.getParams()){
                printObject(obj, 1);
            }
            System.out.println(Constant.RIGHT_SQUARE_BRACKET);
        }
        System.out.println("返回值：");
        if(!testSuit.getObjectType().getResult().equalsIgnoreCase(TypeConstant.VOID) && result != null){
            printObject(result, 0);
        }
        else if(testSuit.getObjectType().getResult().equalsIgnoreCase(TypeConstant.VOID)){
            System.out.println(TypeConstant.VOID);
        }
        else{
            System.out.println("null");
        }
    }

    /**
     * 格式化打印obj对象的内容
     * @param obj 被打印的数据
     * @param index 缩进计数
     */
    private void printObject(Object obj, int index){
        if(obj.getClass().isArray()){
            int len = Array.getLength(obj);
            boolean end = len == 0 || !Array.get(obj, 0).getClass().isArray();
            for(int i = 0; i < index; i++){
                System.out.print("  ");
            }
            if(!end){
                System.out.println(Constant.LEFT_SQUARE_BRACKET);
            }
            else{
                System.out.print(Constant.LEFT_SQUARE_BRACKET);
            }
            for(int i = 0; i < len; i++){
                Object o = Array.get(obj, i);
                if(o.getClass().isArray()){
                    printObject(o, index + 1);
                }
                else{
                    System.out.print(o.toString());
                }
                if(i != len - 1){
                    System.out.print(Constant.COMMA);
                }
                if(o.getClass().isArray()){
                    System.out.println();
                }
            }
            if(end){
                System.out.print(Constant.RIGHT_SQUARE_BRACKET);
            }
            else{
                for(int i = 0; i < index; i++){
                    System.out.print("  ");
                }
                System.out.println(Constant.RIGHT_SQUARE_BRACKET);
            }
        }
        else{
            for(int i = 0; i < index; i++){
                System.out.print("  ");
            }
            System.out.print(Constant.LEFT_SQUARE_BRACKET);
            System.out.print(obj.toString());
            System.out.println(Constant.RIGHT_SQUARE_BRACKET);
        }
    }
}
