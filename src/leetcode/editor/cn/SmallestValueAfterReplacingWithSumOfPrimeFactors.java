package leetcode.editor.cn;

//给你一个正整数 n 。 
//
// 请你将 n 的值替换为 n 的 质因数 之和，重复这一过程。 
//
// 
// 注意，如果 n 能够被某个质因数多次整除，则在求和时，应当包含这个质因数同样次数。 
// 
//
// 返回 n 可以取到的最小值。 
//
// 
//
// 示例 1： 
//
// 输入：n = 15
//输出：5
//解释：最开始，n = 15 。
//15 = 3 * 5 ，所以 n 替换为 3 + 5 = 8 。
//8 = 2 * 2 * 2 ，所以 n 替换为 2 + 2 + 2 = 6 。
//6 = 2 * 3 ，所以 n 替换为 2 + 3 = 5 。
//5 是 n 可以取到的最小值。
// 
//
// 示例 2： 
//
// 输入：n = 3
//输出：3
//解释：最开始，n = 3 。
//3 是 n 可以取到的最小值。 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 10⁵ 
// 
//
// Related Topics 数学 数论 👍 11 👎 0

public class SmallestValueAfterReplacingWithSumOfPrimeFactors{
    public static void main(String[] args) {
        Solution solution = new SmallestValueAfterReplacingWithSumOfPrimeFactors().new Solution();
        System.out.println(solution.smallestValue(10));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestValue(int n) {
        int ans = 0, tmp = n;
        for (int i = 2; tmp > 1; i++) {
            //tmp 被除一次后结果保留
            while (tmp % i == 0) {
                tmp /= i;
                ans += i;
            }
        }
        return ans == n ? n : smallestValue(ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}