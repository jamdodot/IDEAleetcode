package com.wut.learn.base.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CalculatorProxy implements InvocationHandler {
    private Object target;

    public CalculatorProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在方法调用前执行一些操作（例如日志记录）
        System.out.println("Before invoking " + method.getName());

        // 调用目标对象的方法
        Object result = method.invoke(target, args);

        // 在方法调用后执行一些操作
        System.out.println("After invoking " + method.getName());

        return result;
    }

    public static void main(String[] args) {
        // 创建目标对象
        Calculator target = new CalculatorImpl();

        // 创建代理对象
        Calculator proxy = (Calculator) Proxy.newProxyInstance(
                Calculator.class.getClassLoader(),
                new Class<?>[] { Calculator.class },
                new CalculatorProxy(target)
        );

        // 使用代理对象调用方法
        int result = proxy.add(5, 3);
        System.out.println("Result: " + result);
    }
}

