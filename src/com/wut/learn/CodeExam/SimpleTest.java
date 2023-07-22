package com.wut.learn.CodeExam;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/05/22/20:46
 * @Description:
 */
public class SimpleTest {
    public  static void main(String[] args){
//        List<Integer> list= Arrays.asList(1,2,3,4);
//        int sum=0;
//        for(Iterator<Integer> i1=list.iterator();i1.hasNext();){
//            for(Iterator<Integer> i2=list.iterator();i2.hasNext();){
//                sum+=i1.next()+i2.next();
//            }
//        }
//        System.out.println(sum);
        Printer p=new FastPrinter();
        p.value=2;
        p.print();
    }
    static class Printer{
        protected int value=0;
        public void print(){
            System.out.println(value);
        }
    }
     static class  FastPrinter extends Printer{
        public int value=1;
        @Override
        public void print(){
            System.out.println(value);
        }
    }


}
