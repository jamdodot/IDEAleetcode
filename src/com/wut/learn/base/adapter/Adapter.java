package com.wut.learn.base.adapter;



/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/05/14/21:28
 * @Description:
 */
public class Adapter extends Source implements Targetable{
    @Override
    public void method2(){
        System.out.println("target method");
    }

}
