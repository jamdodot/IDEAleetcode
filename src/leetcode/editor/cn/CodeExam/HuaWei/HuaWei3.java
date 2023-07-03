package leetcode.editor.cn.CodeExam.HuaWei;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/04/12/16:15
 * @Description:
 */
public class HuaWei3 {
    /**
     * 给定一个字符串，给出字符串重新排序的所有不同的排列数  回溯法
     * @param args
     */
        static int res=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String input = s.trim();
        char [] chars=input.toCharArray();
        Arrays.sort(chars);
        LinkedList<Character> track=new LinkedList<>();
        boolean [] used=new boolean[chars.length];
        backtrace(chars,used,track);
        System.out.println(res);


    }
     static void backtrace(char [] chars,boolean [] used,LinkedList<Character> track){
            if(track.size()==chars.length){
                res++;
                return;
            }
            for(int i=0;i<chars.length;i++){
                if(used[i]){
                    continue;
                }
                if(i>0&&chars[i]==chars[i-1]&&!used[i-1]){
                    continue;
                }
                track.add(chars[i]);
                used[i]=true;
                backtrace(chars,used,track);
                used[i]=false;
                track.removeLast();
            }
    }

}
