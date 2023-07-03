package leetcode.editor.cn;

//你的任务是计算 aᵇ 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。 
//
// 
//
// 示例 1： 
//
// 
//输入：a = 2, b = [3]
//输出：8
// 
//
// 示例 2： 
//
// 
//输入：a = 2, b = [1,0]
//输出：1024
// 
//
// 示例 3： 
//
// 
//输入：a = 1, b = [4,3,3,8,5,2]
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：a = 2147483647, b = [2,0,0]
//输出：1198
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a <= 2³¹ - 1 
// 1 <= b.length <= 2000 
// 0 <= b[i] <= 9 
// b 不含前导 0 
// 
// Related Topics 数学 分治 👍 236 👎 0

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class SuperPow{
    public static void main(String[] args) {
        Solution solution = new SuperPow().new Solution();
        int[] input={2,0,0};
        System.out.println(solution.superPow(2147483647,input));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int base=1337;
    public int superPow(int a, int[] b) {
        if(b.length==0) return 1;
        int last=b[b.length-1];
        b=pop_back(b);
        int part1 = mypow(a, last);
        int part2 = mypow(superPow(a, b), 10);
        // 每次乘法都要求模
        return (part1 * part2) % base;
    }
    int mypow(int a,int k){
        a%=base;
        int res = 1;
        for (int i = 0; i < k; i++) {
            // 这里有乘法，是潜在的溢出点
            res *= a;
            // 对乘法结果求模
            res %= base;
        }
        return res;
    }
    int[] pop_back(int[] b){
        int []a= Arrays.copyOf(b,b.length-1);
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}