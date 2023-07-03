package leetcode.editor.cn.CodeExam;
import java.util.*;
/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/04/09/10:50
 * @Description:
 */
public class InputAndOutput  {
    public static void main(String[] args){
       Scanner sc=new Scanner(System.in);
//        while(sc.hasNextLine()){
//            double n=sc.nextDouble();
//            int m=sc.nextInt();
//            double res=0l;
//            res+=n;
//            for(int i=1;i<m;i++){
//                n=Math.sqrt(n);
//                res+=n;
//            }
//            System.out.println(String.format("%.2f",res));
//        }

        //输入一个字符串
//        String s=sc.next();
//        System.out.println(s);
//        sc.close();

        //输入多个字符串
//        while(sc.hasNext()){
//            String s=sc.next();
//            System.out.println(s);
//        }

        //输入一行
        // String s= sc.nextLine();


        //输入矩阵
//        int num=sc.nextInt();
//        int n_=num;
//        while(n_>0) {
//            int [][] input=new int[3][num];
//            for(int i=0;i<3;i++){
//                for(int j=0;j<num;j++){
//                    input[i][j]=sc.nextInt();
//                }
//            }
        /**
         * 输入一棵树 T，你需要删除一条边，这棵树会被分成A 和 B 两棵树。你需要让两部分的节点数的差的绝对值
         * | |A|-|B| |尽可能小。输出最小的| |A|-|B| |和最优方案的数量。
         */

        /**
         * 第一行一个整数 n表示节点的数量，节点从1 到 n编号。
         *
         * 接下来n-1行每行两个正整数 s t，表示s的父亲是t。
         *
         * 输入保证是一棵树。
         */
        int num=sc.nextInt();


    }

}
