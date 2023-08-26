package com.wut.learn.base.threads;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/08/26/10:20
 * @Description:
 */
public class crossPrint2 {

    private Object monitor = new Object();
    private volatile int count;

    crossPrint2(int initCount) {
        this.count = initCount;
    }

    private void printOddEven() {
        synchronized (monitor) {
            while (count < 10) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    monitor.notifyAll();
                    monitor.wait();
                } catch (InterruptedException error) {
                    throw new RuntimeException(error);
                }
            }

        }
        // 防止count=10后，while()循环不再执行，有子线程被阻塞未被唤醒，导致主线程不能退出
        monitor.notifyAll();
    }

    public static void main(String[]args) throws InterruptedException {
        crossPrint2 crossPrint2 = new crossPrint2(0);
        new Thread(()->{
            crossPrint2.printOddEven();},
                "odd").start();
        Thread.sleep(10);
        new Thread(()->{
            crossPrint2.printOddEven();},
                "even").start();

    }


}

