package com.wut.learn.base.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CalculatorProxy2 implements InvocationHandler {

    private Object target;

    public CalculatorProxy2(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Before invoking " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("After invoking " + method.getName());
        return result;
    }


    public static void main(String[] args) {
        // 创建目标对象
        Calculator target = new CalculatorImpl();
        Calculator proxy = (Calculator) Proxy.newProxyInstance(Calculator.class.getClassLoader(),
                new Class<?>[]{Calculator.class},
                new CalculatorProxy2(target));
        int add = proxy.add(5, 3);
        System.out.println("Result: " + add);

    }


}

