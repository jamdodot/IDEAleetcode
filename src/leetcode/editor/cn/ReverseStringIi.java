package leetcode.editor.cn;

//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 双指针 字符串 👍 485 👎 0

public class ReverseStringIi{
    public static void main(String[] args) {
        Solution solution = new ReverseStringIi().new Solution();
        System.out.println(solution.reverseStr("krmyfshbspcgtesxnnljhfursyissjnsocgdhgfxubewllxzqhpasguvlrxtkgatzfybprfmmfithphckksnvjkcvnsqgsgosfxc",20));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
            if(k==1||s.length()==1) return s;
            char[] res=s.toCharArray();
            if(s.length()<=2*k){
                reverse(res,0,Math.min(k-1,s.length()-1));
                return new String(res);
            }
            int i=0;
            for( i=0;i<=s.length()-2*k;i+=2*k){
                reverse(res,i,i+k-1);
            }
            if(res.length-i<k){
                reverse(res,i,res.length-1);
            }
            if(res.length-i>=k){
                reverse(res,i,i+k-1);
            }
            return new String(res);
    }
    public void reverse(char[] chars,int left,int right){
        while(right>left){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}