package leetcode.editor.cn;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4027 👎 0

import java.util.Stack;

public class ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        if(s.length()<2||s.charAt(0)==')'||s.charAt(0)==']'||s.charAt(0)=='}') return false;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;
                if(c==')'){
                    Character pop = stack.pop();
                    if(Character.valueOf(pop)!='('){
                        return false;
                    }
                }
                if(c==']'){
                    Character pop = stack.pop();
                    if(Character.valueOf(pop)!='['){
                        return false;
                    }
                }
                if(c=='}'){
                    Character pop = stack.pop();
                    if(Character.valueOf(pop)!='{'){
                        return false;
                    }
                }
            }
        }
        if(stack.size()>0) return false;


        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}