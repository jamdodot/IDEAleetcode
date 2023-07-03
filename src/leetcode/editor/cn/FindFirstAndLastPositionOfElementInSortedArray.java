package leetcode.editor.cn;

//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2328 👎 0

import java.util.ArrayList;
import java.util.List;

public class FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] input=new int[]{2,2};
        System.out.println(solution.searchRange(input,3));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int[] resArr=new int[]{-1,-1};
        if(nums.length==0) return resArr;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;
            } else if (nums[mid] < target) {
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        if(left<nums.length&&nums[left]==target){
            resArr[0]=left;
            while(left<nums.length-1&&nums[left]==target&&nums[left+1]==target){
                left++;
            }
            resArr[1]=left;
        }
        return resArr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}