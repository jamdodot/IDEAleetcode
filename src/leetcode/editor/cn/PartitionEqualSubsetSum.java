package leetcode.editor.cn;

//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 1844 👎 0

import java.util.Arrays;
import java.util.Comparator;

public class PartitionEqualSubsetSum{
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
               sum+=num;
        }
        Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        if(sum%2==1) return false;
        return fun(nums,sum/2);
    }

    public boolean fun(int[] nums, int sum){
        int [] dp=new int[sum+1];
        for(int i=0; i<nums.length;i++){
            for(int j=sum;j>=nums[i];j--){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        if(dp[sum]==sum)return true;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}