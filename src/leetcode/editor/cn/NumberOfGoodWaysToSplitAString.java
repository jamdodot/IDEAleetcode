package leetcode.editor.cn;

//给你一个字符串 s ，一个分割被称为 「好分割」 当它满足：将 s 分割成 2 个字符串 p 和 q ，它们连接起来等于 s 且 p 和 q 中不同字符的数
//目相同。 
//
// 请你返回 s 中好分割的数目。 
//
// 
//
// 示例 1： 
//
// 输入：s = "aacaba"
//输出：2
//解释：总共有 5 种分割字符串 "aacaba" 的方法，其中 2 种是好分割。
//("a", "acaba") 左边字符串和右边字符串分别包含 1 个和 3 个不同的字符。
//("aa", "caba") 左边字符串和右边字符串分别包含 1 个和 3 个不同的字符。
//("aac", "aba") 左边字符串和右边字符串分别包含 2 个和 2 个不同的字符。这是一个好分割。
//("aaca", "ba") 左边字符串和右边字符串分别包含 2 个和 2 个不同的字符。这是一个好分割。
//("aacab", "a") 左边字符串和右边字符串分别包含 3 个和 1 个不同的字符。
// 
//
// 示例 2： 
//
// 输入：s = "abcd"
//输出：1
//解释：好分割为将字符串分割成 ("ab", "cd") 。
// 
//
// 示例 3： 
//
// 输入：s = "aaaaa"
//输出：4
//解释：所有分割都是好分割。 
//
// 示例 4： 
//
// 输入：s = "acbadbaada"
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// s 只包含小写英文字母。 
// 1 <= s.length <= 10^5 
// 
//
// Related Topics 位运算 字符串 动态规划 👍 45 👎 0

import java.util.HashMap;

public class NumberOfGoodWaysToSplitAString {
    public static void main(String[] args) {
        Solution solution = new NumberOfGoodWaysToSplitAString().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSplits(String s) {
            HashMap<Character, Integer> left = new HashMap<>();
            HashMap<Character, Integer> right = new HashMap<>();
            int res = 0;
            for (char c : s.toCharArray()) {
                right.put(c, right.getOrDefault(c, 0) + 1);
            }
            for (char c : s.toCharArray()) {
                left.put(c, left.getOrDefault(c, 0) + 1);
                right.put(c, right.get(c) - 1);
                if (right.get(c) == 0) right.remove(c);
                if (left.size() == right.size()) res++;
            }
            return res;
        }
//leetcode submit region end(Prohibit modification and deletion)

    }
    class Solution2 {
        public int numSplits(String s) {
            int [] cnt=new int[26];
            int[] now=new int[26];
            int res=0;
            int p=0,q=0;
            for(char c:s.toCharArray()) cnt[c-'a']++;
            for(int i=0;i<26;i++) if ( cnt[i]!=0)q++;
            for(char c:s.toCharArray()){
                cnt[c-'a']--;
                if(cnt[c-'a']==0)q--;
                // 判断now也就是左侧的新字符数量：
                // 每次字符进来之前如果原来数组是0，
                // 那就算是新字符，节省了计算数组字符种类的时间
                if(now[c-'a']==0)p++;
                now[c-'a']++;
                if(p==q) res++;
            }
            return res;


        }

    }
}