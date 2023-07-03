package leetcode.editor.cn.base.proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/05/14/20:37
 * @Description:
 */
public class Proxy implements Sourceable{
     private  Source source;
     public Proxy(){
         super();
         this.source=new Source();
     }
     @Override
    public void method(){
         System.out.println("before proxy");
         source.method();
         System.out.println("after proxy");
     }
     public static void main(String []args){
         Proxy proxy = new Proxy();
         proxy.method();
     }
}
