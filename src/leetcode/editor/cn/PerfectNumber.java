package leetcode.editor.cn;

//对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。 
//
// 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 28
//输出：true
//解释：28 = 1 + 2 + 4 + 7 + 14
//1, 2, 4, 7, 和 14 是 28 的所有正因子。 
//
// 示例 2： 
//
// 
//输入：num = 6
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：num = 496
//输出：true
// 
//
// 示例 4： 
//
// 
//输入：num = 8128
//输出：true
// 
//
// 示例 5： 
//
// 
//输入：num = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 10⁸ 
// 
// Related Topics 数学 👍 145 👎 0

public class PerfectNumber{
    public static void main(String[] args) {
        Solution solution = new PerfectNumber().new Solution();
        System.out.println(solution.checkPerfectNumber(2));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num==1)return false;
        int n=(int)Math.ceil(Math.sqrt(num));
        int sum=0;
        for(int i=n;i<num;i++){
            if(num%i==0){
                sum+=i;
                sum+=num/i;
            }
        }
        sum+=1;
        if(sum==num) return true;
        return  false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}