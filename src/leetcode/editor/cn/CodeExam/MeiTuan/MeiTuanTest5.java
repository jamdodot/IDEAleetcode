package leetcode.editor.cn.CodeExam.MeiTuan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/04/15/11:16
 * @Description:
 */
public class MeiTuanTest5 {
    public static void main(String[] args) {
        /**
         *你有一个n个自然数（即大于等于0的整数）的集合（可包含重复元素），你可以进行如下任意次操作：
         *
         * 选择集合中的一个数字x，将其替换为y，要求y＞x
         *
         * 设这个集合最小未出现的自然数为K，你的目标是进行上述操作若干次，使得K最大。你只需要输出这个最大的K即可。
         *
         */
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int n_=num;
        int [] input=new int[num];
        while(n_>0){
            input[num-n_]=sc.nextInt();
            n_--;
        }
        Arrays.sort(input);
        for(int i=1;i<num;i++){
            if(input[i]!=input[i-1]+1&&input[i]<=input[i-1]){
                input[i]=input[i-1]+1;
            }
        }
        int res=0;
        for(int i=1;i<num;i++){
            if(input[i]!=input[i-1]+1){
                res=input[i-1]+1;
                break;
            }
        }
        System.out.println(res);
    }
}
