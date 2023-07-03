package leetcode.editor.cn.base;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/05/03/16:15
 * @Description:
 */
public class Singleton {
    private static Singleton instance ;
    private  Singleton(){
        System.out.println("Singleton is create");
        slowdown();
    }
    public static synchronized Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                instance = new Singleton();
            }
        }
        return instance;
    }
    public void slowdown() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
            for(int i=0;i<10;i++){
                Thread t=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Singleton s=Singleton.getInstance();
                        System.out.println(s.toString());
                    }
                });
                t.start();
            }
        }

    }

