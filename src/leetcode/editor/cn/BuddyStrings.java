package leetcode.editor.cn;

//给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。 
//
// 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。 
//
// 
// 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ab", goal = "ba"
//输出：true
//解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。 
//
// 示例 2： 
//
// 
//输入：s = "ab", goal = "ab"
//输出：false
//解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。 
//
// 示例 3： 
//
// 
//输入：s = "aa", goal = "aa"
//输出：true
//解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
// 
//
// 示例 4： 
//
// 
//输入：s = "aaaaaaabc", goal = "aaaaaaacb"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, goal.length <= 2 * 10⁴ 
// s 和 goal 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 👍 191 👎 0

import java.util.HashMap;
import java.util.Map;

public class BuddyStrings{
    public static void main(String[] args) {
        Solution solution = new BuddyStrings().new Solution();
        System.out.println(solution.buddyStrings("ab","ba"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean buddyStrings(String s, String goal) {
//        if(s.equals(goal)&&s.charAt(0)!=s.charAt(1)){
//            return false;
//        }
//        return true;
        if(s.length()!=goal.length()||s.length()<2||goal.length()<2)return false;

        int countS[]=new int [26];
        int countG[]=new int [26];
        int sum=0;
        for(int i=0;i<s.length();i++){
            int a=s.charAt(i)-'a';
            int b=goal.charAt(i)-'a';
            if (a!=b)sum++;
            countS[a]++;
            countG[b]++;
        }
        boolean ok=false;
        for(int i=0;i<26;i++){
            if(countS[i]!=countG[i])return false;
            if(countS[i]>1) ok=true;

        }

        return sum==2||(sum==0&&ok);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}