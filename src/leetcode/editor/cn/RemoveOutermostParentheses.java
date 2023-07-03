package leetcode.editor.cn;

//有效括号字符串为空 ""、"(" + A + ")" 或 A + B ，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。 
//
// 
// 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。 
// 
//
// 如果有效字符串 s 非空，且不存在将其拆分为 s = A + B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
// 
//
// 给出一个非空有效字符串 s，考虑将其进行原语化分解，使得：s = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。 
//
// 对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "(()())(())"
//输出："()()()"
//解释：
//输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
//删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。 
//
// 示例 2： 
//
// 
//输入：s = "(()())(())(()(()))"
//输出："()()()()(())"
//解释：
//输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
//删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
// 
//
// 示例 3： 
//
// 
//输入：s = "()()"
//输出：""
//解释：
//输入字符串为 "()()"，原语化分解得到 "()" + "()"，
//删除每个部分中的最外层括号后得到 "" + "" = ""。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 为 '(' 或 ')' 
// s 是一个有效括号字符串 
// 
// Related Topics 栈 字符串 👍 218 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveOutermostParentheses{
    public static void main(String[] args) {
        Solution solution = new RemoveOutermostParentheses().new Solution();
        System.out.println(solution.removeOuterParentheses("()()"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack=new Stack<>();
        List<StringBuilder> list=new ArrayList<>();
        int left=0,right=0;
        int index=0;
        StringBuilder temp= new StringBuilder();
        for(char c:s.toCharArray()){

            if(c=='(') left++;
            else right++;
            temp.append(c);
            if(left==right&&left>0){
                list.add(temp);
                index++;
                temp=new StringBuilder();
                left=0;
                right=0;
            }
        }
        StringBuilder ans=new StringBuilder("");
        for(int i=0;i<list.size();i++){
        StringBuilder temp2=new StringBuilder();
            ans.append(list.get(i).deleteCharAt(0).deleteCharAt(list.get(i).length()-1).toString());
        }
        return ans.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}