package leetcode.editor.cn;

//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 6695 👎 0

public class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp=new boolean[s.length()][s.length()];
        int max=Integer.MIN_VALUE;
        int[] res=new int[2];
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<=s.length()-1;j++){
                if(s.charAt(i)==s.charAt(j)){
                  if(j - i <= 1){
                      dp[i][j] = true;
                  } else {
                      dp[i][j] = dp[i+1][j-1];
                  }
                }
                if(dp[i][j]&&j-i+1>max){
                    max = j-i+1;
                    res[0]=i;
                    res[1]=j;
                }
            }
        }
        return s.substring(res[0], res[1]+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}