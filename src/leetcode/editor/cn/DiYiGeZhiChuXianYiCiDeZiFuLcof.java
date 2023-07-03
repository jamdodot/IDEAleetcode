package leetcode.editor.cn;

//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例 1: 
//
// 
//输入：s = "abaccdeff"
//输出：'b'
// 
//
// 示例 2: 
//
// 
//输入：s = "" 
//输出：' '
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
//
// Related Topics 队列 哈希表 字符串 计数 👍 322 👎 0

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DiYiGeZhiChuXianYiCiDeZiFuLcof{
    public static void main(String[] args) {
        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
        solution.firstUniqChar("leetcode");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        char c=' ';
        if(s.length()==0) return c;
        Map<Character,Integer> res=new HashMap<>();
        for(int i=0;i<s.length();i++){
            res.put(s.charAt(i),res.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i=0;i<s.length();i++){
            if(res.get(s.charAt(i))==1){
                c=s.charAt(i);
                break;
            }

        }
        return c;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}