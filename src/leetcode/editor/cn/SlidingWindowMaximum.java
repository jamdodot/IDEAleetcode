package leetcode.editor.cn;

//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2391 👎 0

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum{
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue myQueue = new MyQueue();
        if(nums.length==1) return nums;
        int len=nums.length-k+1;
        int[] res=new int[len];
        for(int i=0;i<k;i++){
            myQueue.add(nums[i]);
        }
        int num=0;
        res[num++]=myQueue.peek();
        for(int i=k;i<nums.length;i++){
            myQueue.poll(nums[i-k]);
            myQueue.add(nums[i]);
            res[num++]=myQueue.peek();
        }
        return res;
    }


}
    class MyQueue{
        Deque<Integer> deque=new LinkedList<>();

        public void  poll(int val){
            if(!deque.isEmpty()&&val==deque.peek()){
                deque.poll();
            }
        }
        public void  add(int val){
            while(!deque.isEmpty()&&val>deque.getLast()) {
                deque.removeLast();
                }
                deque.add(val);
        }
        public int peek(){
            return deque.peek().intValue();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}