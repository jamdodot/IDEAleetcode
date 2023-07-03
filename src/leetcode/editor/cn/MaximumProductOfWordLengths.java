package leetcode.editor.cn;

//给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为
//每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
//输出: 16 
//解释: 这两个单词为 "abcw", "xtfn"。 
//
// 示例 2: 
//
// 
//输入: ["a","ab","abc","d","cd","bcd","abcd"]
//输出: 4 
//解释: 这两个单词为 "ab", "cd"。 
//
// 示例 3: 
//
// 
//输入: ["a","aa","aaa","aaaa"]
//输出: 0 
//解释: 不存在这样的两个单词。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= words.length <= 1000 
// 1 <= words[i].length <= 1000 
// words[i] 仅包含小写字母 
// 
// Related Topics 位运算 数组 字符串 👍 246 👎 0

import java.util.Arrays;
import java.util.Collection;

public class MaximumProductOfWordLengths{
    public static void main(String[] args) {
        Solution solution = new MaximumProductOfWordLengths().new Solution();
        String[] input={"abcw","baz"};
        solution.maxProduct(input);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(String[] words) {
        int n=words.length,idx=0;
        int [] mark=new int[n];
        for(String s:words){
            int t=0;
            for(int i=0;i<s.length();i++){
                int temp=s.charAt(i)-'a';
                t|=(1<<temp);
            }
            mark[idx++]=t;

        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if((mark[i]&mark[j])==0){
                    ans=Math.max(ans,words[i].length()*words[j].length());
                }
            }
        }
    return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}