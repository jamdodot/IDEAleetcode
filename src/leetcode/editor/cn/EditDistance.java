package leetcode.editor.cn;

//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作：
//
//
// 插入一个字符
// 删除一个字符
// 替换一个字符
//
//
//
//
// 示例 1：
//
//
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
//
//
// 示例 2：
//
//
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
//
//
//
//
// 提示：
//
//
// 0 <= word1.length, word2.length <= 500
// word1 和 word2 由小写英文字母组成
//
// Related Topics 字符串 动态规划 👍 1840 👎 0

public class EditDistance {
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
        String s1="horse";
        String s2="ros";
        int res= solution.minDistance(s1,s2);
        System.out.println(res);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int[][] memo = new int[word1.length() ][word2.length() ];
            for (int[] temp : memo) {
                temp = new int[]{0};
            }
            return dp(word1.length() - 1, word2.length() - 1, word1, word2, memo);
        }


        int dp(int i, int j, String word1, String word2, int[][] memo) {


            if (i == -1) {
                return j + 1;
            }
            if (j == -1) {
                return i + 1;
            }
            if(memo[i][j]!=0)
                return memo[i][j];
            if (word1.charAt(i) == word2.charAt(j)) {
                memo[i][j] = dp(i - 1, j - 1, word1, word2, memo);

            } else {
                memo[i][j] = min3(
                        dp(i - 1, j - 1, word1, word2, memo) + 1,
                        dp(i - 1, j, word1, word2, memo) + 1,
                        dp(i, j - 1, word1, word2, memo) + 1
                );
            }
            return memo[i][j];

        }

        int min3(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }
//leetcode submit region end(Prohibit modification and deletion)

    }
}