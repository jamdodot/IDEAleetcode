package com.wut.learn.base.threadpool;

import java.util.Date;

public class MyRunnable implements Runnable{

    private String command;

    public MyRunnable(String s){
        this.command=s;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"Start Time= "+ new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+"End Time= "+ new Date());


    }


}
