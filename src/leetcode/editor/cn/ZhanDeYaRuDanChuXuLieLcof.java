package leetcode.editor.cn;

//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈
//的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。 
//
// 
//
// 示例 1： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//输出：true
//解释：我们可以按以下顺序执行：
//push(1), push(2), push(3), push(4), pop() -> 4,
//push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
// 
//
// 示例 2： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//输出：false
//解释：1 不能在 2 之前弹出。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= pushed.length == popped.length <= 1000 
// 0 <= pushed[i], popped[i] < 1000 
// pushed 是 popped 的排列。 
// 
//
// 注意：本题与主站 946 题相同：https://leetcode-cn.com/problems/validate-stack-sequences/ 
//
// Related Topics 栈 数组 模拟 👍 426 👎 0

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ZhanDeYaRuDanChuXuLieLcof{
    public static void main(String[] args) {
        Solution solution = new ZhanDeYaRuDanChuXuLieLcof().new Solution();
        int[] pushed=new int[]{0,1};
        int[] popped=new int[]{0,1};
        System.out.println(solution.validateStackSequences( pushed,popped));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
//        if(pushed.length==0&&popped.length==0) return true;
//        if(pushed.length==1&&popped.length==1) return true;
//        if(pushed.length==0||popped.length==0) return false;
//        int i=1,j=0;
//        Stack<Integer> stack = new Stack<>();
//        stack.push(pushed[0]);
//        while(j<popped.length){
//            if((stack.isEmpty()||stack.peek()!=popped[j])&&i<pushed.length){
//                stack.push(pushed[i]);
//                i++;
//            }
//            else if(stack.peek()==popped[j]){
//                j++;
//                stack.pop();
//            }else{
//                return false;
//            }
//        }
//        return true;

        Deque<Integer> deque=new ArrayDeque<>();
        int j=0;
        for(int elem : pushed){
            deque.push(elem);
            while(j<popped.length&&!deque.isEmpty()&&deque.peek()==popped[j]){
                deque.pop();
                j++;
            }
        }

        return j==popped.length;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}