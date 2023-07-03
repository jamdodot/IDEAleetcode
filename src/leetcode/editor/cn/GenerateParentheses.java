package leetcode.editor.cn;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2395 👎 0

public class GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        solution.generateParenthesis(3);
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        StringBuilder track=new StringBuilder();
        backtrack(n,n,res,track);
        res.stream().forEach((o)->System.out.println(o));
        return res;
    }
    public void backtrack(int left,int right,List<String> res,StringBuilder track){
        if(left>right) return;
        if(left<0||right<0)return;
        if(left==0&&right==0){
            res.add(track.toString());
            return;
        }
            track.append("(");
        backtrack(left-1,right,res,track);
        track.deleteCharAt(track.length()-1);
        track.append(")");
        backtrack(left,right-1,res,track);
        track.deleteCharAt(track.length()-1);


    }

}
//leetcode submit region end(Prohibit modification and deletion)

}