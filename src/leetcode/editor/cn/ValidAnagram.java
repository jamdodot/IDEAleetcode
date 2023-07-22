package leetcode.editor.cn;

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
//
// Related Topics 哈希表 字符串 排序 👍 800 👎 0

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram{
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> recordS=new HashMap<>();
        Map<Character,Integer> recordT=new HashMap<>();
        for(char c: s.toCharArray()){
            recordS.put(c,recordS.getOrDefault(c,0)+1);
        }
        for(char c: t.toCharArray()){
            recordT.put(c,recordT.getOrDefault(c,0)+1);
        }
        if(recordS.size()!=recordT.size()) return false;
        for(Map.Entry<Character,Integer> entry:recordS.entrySet()){
            if(!entry.getValue().equals(recordT.get(entry.getKey()))){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}