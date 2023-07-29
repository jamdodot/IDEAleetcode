package leetcode.editor.cn;

//给定一个包含大写字母和小写字母的字符串
// s ，返回 通过这些字母构造成的 最长的回文串 。 
//
// 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入:s = "abccccdd"
//输出:7
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
//
// 示例 2: 
//
// 
//输入:s = "a"
//输出:1
// 
//
// 示例 3： 
//
// 
//输入:s = "aaaaaccc"
//输出:7 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 2000 
// s 只由小写 和/或 大写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 字符串 👍 542 👎 0

public class LongestPalindrome{
    public static void main(String[] args) {
        Solution solution = new LongestPalindrome().new Solution();
        System.out.println(solution.longestPalindrome("abccccdd"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
        int[] upperCase=new int[26];
        int[] lowerCase=new int[26];
        if(s.length()<=1) return s.length();
        int single=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)-'A'>26){
                lowerCase[s.charAt(i)-'a']++;
            }else{
                upperCase[s.charAt(i)-'A']++;
            }

        }
        for(int i=0;i<upperCase.length;i++){
            if(upperCase[i]==0) continue;
            if(upperCase[i]%2==0) {
                res+=upperCase[i];
            }else{
                res+=upperCase[i]-1;
                single++;
            }
        }
        for(int j=0;j<lowerCase.length;j++){
            if(lowerCase[j]==0) continue;
            if(lowerCase[j]%2==0) {
                res+=lowerCase[j];
            }else{
                res+=lowerCase[j]-1;
                single++;
            }
        }
        if(single>0) res+=1;
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}