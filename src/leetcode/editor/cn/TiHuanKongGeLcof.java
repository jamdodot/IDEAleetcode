package leetcode.editor.cn;

//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
//
// Related Topics 字符串 👍 434 👎 0

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class TiHuanKongGeLcof{
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        //return s.replaceAll(" ","%20");
        int length = s.length();
        int [] chars= new int[length*3];
        int size=0;
        for(int i=0;i<length;i++){
            char c= s.charAt(i);
            if(c==' '){
                chars[size++]='%';
                chars[size++]='2';
                chars[size++]='0';

            }
            else{
                chars[size++]=c;
            }

        }
        String res = new String(chars,0,size);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}