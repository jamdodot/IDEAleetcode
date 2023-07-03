package leetcode.editor.cn;

//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 1732 👎 0

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int slow = 0, fast = 0;
        int sum = 0;
        int MIN = Integer.MAX_VALUE;
        while (fast <= nums.length) {
            if (sum >= target) {
                MIN = Math.min(fast - slow, MIN);
                sum -= nums[slow];
                slow++;
            } else {
                if(fast==nums.length){
                    break;
                }
                sum += nums[fast];
                fast++;
            }
        }
        return MIN;
    }
//leetcode submit region end(Prohibit modification and deletion)
    }
}