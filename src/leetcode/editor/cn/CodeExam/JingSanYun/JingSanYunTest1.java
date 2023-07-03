package leetcode.editor.cn.CodeExam.JingSanYun;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/06/02/19:23
 * @Description:
 */
public class JingSanYunTest1 {
    public static void main(String[] args) {
        /**
         * 小明的电脑这几天出了一点问题：在输入英文的时候，有一些单词会莫名其妙地在后面重复一次或多次。 例如：输入“Who are you”，有时候会变成“Who are are you”。 你能否编写一个程序帮助小明去掉那些相邻的、重复出现的单词中的第二个单词？ 注意：
         *
         * (1) 为了对问题进行简化，在输入数据中均不包含标点符号；
         *
         * (2) 单词之间统一用一个英文的空格隔开；
         *
         * (3) 单词不区分大小写，即"Who"和"who"当做同一个单词看待；
         *
         * (4) 不需要考虑输入数据中本身存在两个单词重复的情况，即只要出现单词重复都需要去掉第二个；
         *
         * (5) 特别的，对于多个连续出现的重复单词，只需要保留第一个。
         */
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] input=s.trim().split(" ");
        StringBuilder sb = new StringBuilder(input.length);
        for(int i=0;i<input.length;i++){
            if(i==0){
                sb.append(input[i]);
            }else{
                //转换为小写再对比
                if(!input[i].toLowerCase().equals(input[i-1].toLowerCase())){
                    sb.append(" ");
                    sb.append(input[i]);
                }
            }
        }
        System.out.println(sb.toString());

        sc.close();
    }
}
