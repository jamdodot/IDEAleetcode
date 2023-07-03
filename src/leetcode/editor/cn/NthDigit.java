package leetcode.editor.cn;

//给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：n = 11
//输出：0
//解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 第 n 位上的数字是按计数单位（digit）从前往后数的第 n 个数，参见 示例 2 。 
// 
// Related Topics 数学 二分查找 👍 254 👎 0

public class NthDigit{
    public static void main(String[] args) {
        Solution solution = new NthDigit().new Solution();
        System.out.println(solution.findNthDigit(10));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNthDigit(int n) {
        int len=1;
        while(len*9*Math.pow(10,len-1)<n){
            n-=len*9*Math.pow(10,len-1);
            len++;
        }
        long s=(long)Math.pow(10,len-1);
        s+=n/len-1;
        n-=len*(n/len);
        return n==0?(int)(s%10):(int)((s+1)/Math.pow(10,len-n)%10);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}