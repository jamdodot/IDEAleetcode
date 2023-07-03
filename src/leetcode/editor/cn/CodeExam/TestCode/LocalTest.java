package leetcode.editor.cn.CodeExam.TestCode;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * 字符串成为回文串的最小操作数
 * @Author: sunshine
 * @Date: 2023/06/07/17:18
 * @Description:
 */
public class LocalTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        System.out.println(minIn(str, 0, str.length() - 1));
    }


    public static int minIn(String s, int left, int right) {
        int n = s.length();
        if (n <= 1) {
            return 0;
        }
        int res = 0;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                if (minIn(s, left + 1, right) < minIn(s, left, right - 1)) {
                    left++;
                } else {
                    right--;
                }
                res++;
            }
        }
        return res;
        }

}
