package com.wut.learn.base.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/10/15:43
 * @Description:
 */
class MyThread extends Thread {
    public void run(){
        // 线程执行的任务
    }
}
class MyRunnable implements Runnable {
    public void run(){
        // 线程执行的任务
    }
}
class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        // 执行一些耗时的任务
        Thread.sleep(1000);
        // 返回结果值
        return 42;
    }
}

public class CreateThread {
    public static void main(String[] args) {
        //继承Thread类
        MyThread myThread = new MyThread();
        myThread.start(); // 启动线程

        /**
         * 实现Runable接口
         */
        Thread thread = new Thread(new MyRunnable());
        thread.start(); // 启动线程

        /**
         *  匿名内部类 本质是实现Runable接口
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 线程执行的任务
            }
        }).start(); // 启动线程

        /**
         * callable创建线程
         */
        // 创建一个固定大小的线程池，这里设置为2个线程
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 创建一个Callable任务
        Callable<Integer> myCallable = new MyCallable();

        // 提交任务并获得Future对象，用于获取任务的返回值
        Future<Integer> future = executorService.submit(myCallable);

        try {
            // 获取任务的返回值
            Integer result = future.get();
            System.out.println("任务的结果是：" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
}
