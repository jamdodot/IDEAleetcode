package com.wut.learn.base.threads;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/08/26/10:18
 * @Description:
 */
public class crossPrint {
    /**
     * 两个线程交替打印
     *
     */
    private static final Object lock=new Object();
    private int num;

    public static void main(String[]args){
    crossPrint crossPrint = new crossPrint();
    new Thread(new Runnable() {
        @Override
        public void run() {
            crossPrint.printABC(0);
        }
    }, "A").start();
    //创建一个实现了Runnable接口的匿名内部类，重写run方法，
    // 在run方法中调用crossPrint的printABC方法
    new Thread(()->{
        crossPrint.printABC(1);},
            "B").start();
    new Thread(()->{
        crossPrint.printABC(2);},
            "C").start();
    }
    private void printABC(int targetNum){
        for(int i=0;i<10;i++){
            synchronized (lock){
                while(num%3!=targetNum) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                num++;
                System.out.println(Thread.currentThread().getName());
                lock.notifyAll();
            }
        }
    }
}
