package leetcode.editor.cn;

//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 示例 1： 
//
// 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 
// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 👍 449 👎 0

import com.sun.xml.internal.bind.v2.model.core.ID;
import jdk.internal.org.objectweb.asm.tree.LineNumberNode;

import java.util.Arrays;
import java.util.Comparator;

public class PartitionToKEqualSumSubsets{
    public static void main(String[] args) {
        Solution solution = new PartitionToKEqualSumSubsets().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) return false;
        Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int sum = 0;
        for (int v : nums) sum += v;
        if(sum%k!=0) return false;

        boolean[] used=new boolean[nums.length];
        int target =sum/k;

        return backtrack(k,0,nums,0,used,target);

    }
    public boolean backtrack(int k,int bucket,int[] nums,int start,boolean[] used,int target){
        if(k==0){
            return true;
        }
        if(bucket==target){
//            新的桶所以为0
            return backtrack(k-1,0,nums,0,used,target);
        }
        for(int i=start;i<nums.length;i++){
            if(used[i]){
                continue;
            }
           if(bucket+nums[i]>target){
               continue;
           }
//           成功装入
           used[i]=true;
           bucket+=nums[i];
           if(backtrack(k,bucket,nums,i+1,used,target)){
               return true;
           }
           used[i]=false;
           bucket-=nums[i];
        }
        return  false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}