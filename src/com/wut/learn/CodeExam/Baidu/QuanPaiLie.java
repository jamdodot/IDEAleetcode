package com.wut.learn.CodeExam.Baidu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/08/26/11:24
 * @Description:
 */
public class QuanPaiLie {
    /**
     * 数组全排列
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[] book = new int[arr.length];
        int[] result = new int[arr.length];
        //dfs(0, arr, book, result);
        List<String> input = new ArrayList<>();
        input.add("1");
        input.add("2");
        input.add("3");
        ArrayList<String> permutation0 = getPermutation0(input);

        System.out.println(result.length);
    }

    public static void dfs(int step, int[] arr, int[] book, int[] result) {
        if(step==arr.length){
            for(int j=0;j<arr.length;j++){
                System.out.print(result[j]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(book[i]==0){
                result[step]=arr[i];
                book[i]=1;
                dfs(step+1,arr,book,result);
                book[i]=0;
            }
        }
    }

    public static  ArrayList<String> getPermutation0(List<String> input) {
        int n=input.size();
        ArrayList<String> res = new ArrayList<>();
        res.add(input.get(0) + "");//初始化,包含第一个字符

        for (int i = 1; i < n; i++) {//第二个字符插入到前面生成集合的每个元素里面
            ArrayList<String> res_new = new ArrayList<>();
            String c = input.get(i);//新字符
            for (String str : res) {//访问上一趟集合中的每个字符串
                //  插入到每个位置,形成一个新串
                String newStr = c + str;//加在前面
                res_new.add(newStr);
                newStr = str + c;//加在后面
                res_new.add(newStr);
                //加在中间
                for (int j = 1; j < str.length(); j++) {
                    newStr = str.substring(0, j) + c + str.substring(j);
                    res_new.add(newStr);
                }
            }
            res = res_new;//更新
        }
        return res;
    }

}
