package leetcode.editor.cn;

//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 
//输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组 不为空 的情况下，1 ≤ k ≤ nums.length。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
//
// Related Topics 队列 滑动窗口 单调队列 堆（优先队列） 👍 564 👎 0

import com.sun.javafx.image.IntPixelGetter;
import com.sun.javafx.scene.control.skin.ListCellSkin;

import java.util.*;

public class HuaDongChuangKouDeZuiDaZhiLcof{
    public static void main(String[] args) {
        Solution solution = new HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
        int [] input=new int[]{1,3,-1,-3,5,3,6,7};
        solution.maxSlidingWindow(input,3);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        SingleQueue window=new SingleQueue();
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i<k-1){
                window.push(nums[i]);
            }else{
                window.push(nums[i]);
                res.add(window.max());
                window.pop(nums[i-k+1]);
            }
        }
        int [] arr= new int [res.size()];
        for(int i=0;i<res.size();i++){
            arr[i]=res.get(i);
        }
        return arr;

    }
    class SingleQueue{
        LinkedList<Integer> queue=new LinkedList<>();
        public void push(int n){
            while(!queue.isEmpty()&&queue.getLast()<n){
                queue.pollLast();
            }
            queue.addLast(n);
        }
        public int max(){
            return queue.getFirst();
        }
        public void pop(int n){
            if(n==queue.getFirst()){
                queue.pollFirst();
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}