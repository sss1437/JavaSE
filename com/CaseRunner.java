package com;

import com.annotations.Benchmark;
import com.annotations.Measurement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @Description:
 * @Author: zdd
 * @Date: 2019/7/31
 */
class CaseRunner{
    private static final int DEFAULT_ITERATIONS = 10;
    private static final int DEFAULT_GROUP = 5;
    private final List<Case> caseList;
    public CaseRunner (List<Case> caseList){
        this.caseList = caseList;
    }
    public void run() throws InvocationTargetException, IllegalAccessException {
        for (Case bCase:caseList){
            int iterations = DEFAULT_ITERATIONS;
            int group = DEFAULT_GROUP;

            //先获取类级别的配置
            Measurement classMeasurement = bCase.getClass().getAnnotation(Measurement.class);
            if (classMeasurement != null){
                iterations = classMeasurement.iterations();
                group = classMeasurement.group();
            }
            //找到对象中哪些方法是需要测试的方法
            Method[] methods = bCase.getClass().getMethods();
            for (Method method:methods){
                Benchmark benchmark = method.getAnnotation(Benchmark.class);
                if (benchmark == null){
                    continue;
                }

                Measurement methodMeasurement = method.getAnnotation(Measurement.class);
                if (methodMeasurement != null){
                    iterations = methodMeasurement.iterations();
                    group = methodMeasurement.group();
                }
                runCase(bCase,method,iterations,group);
            }
        }

    }
    private void runCase(Case bCase,Method method,int iterations,int group) throws InvocationTargetException, IllegalAccessException {
        System.out.println(method.getName());
        for (int i = 0;i < group ; i++){
            System.out.printf("第%d次实验",i);
            long t1 = System.nanoTime();
            for (int j = 0;j < iterations; j++){
                method.invoke(bCase);
            }
            long t2 = System.nanoTime();
            System.out.printf("耗时%d纳秒%n",t2-t1);
        }
    }
}
