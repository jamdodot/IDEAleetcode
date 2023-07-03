package leetcode.editor.cn;

//给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个长度至少为 3 的子序列，其中每个子序列都由连续整数组成。 
//
// 如果可以完成上述分割，则返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入: [1,2,3,3,4,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3
//3, 4, 5
// 
//
// 示例 2： 
//
// 
//输入: [1,2,3,3,4,4,5,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3, 4, 5
//3, 4, 5
// 
//
// 示例 3： 
//
// 
//输入: [1,2,3,4,4,5]
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10000 
// 
// Related Topics 贪心 数组 哈希表 堆（优先队列） 👍 372 👎 0

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class SplitArrayIntoConsecutiveSubsequences{
    public static void main(String[] args) {
        Solution solution = new SplitArrayIntoConsecutiveSubsequences().new Solution();
        int [] input={1,2,3,3,4,4,5,5};
        if(solution.isPossible(input)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer,Integer> numCount=new HashMap<>();
        Map<Integer,Integer> need=new HashMap<>();
        for(int i:nums){
            numCount.put(i,numCount.getOrDefault(i,0)+1);
        }
        for(int i:nums){
            if(numCount.get(i)==0){
                continue;
            }
//            先考虑加入已有序列
            if(numCount.containsKey(i)&&numCount.get(i)>0&&need.containsKey(i)&&need.get(i)>0){
                numCount.put(i,numCount.get(i)-1);
                need.put(i,need.get(i)-1);
                need.put(i+1,need.getOrDefault(i+1,0)+1);
            } else if (numCount.containsKey(i)&&numCount.containsKey(i+1)&&numCount.containsKey(i+2)&&numCount.get(i)>0&&numCount.get(i+1)>0&&numCount.get(i+2)>0){
                numCount.put(i,numCount.get(i)-1);
                numCount.put(i+1,numCount.get(i+1)-1);
                numCount.put(i+2,numCount.get(i+2)-1);
                need.put(i+3,need.getOrDefault(i+3,0)+1);
            }else{
                return false;
            }
        }
        return true;



    }
}
//leetcode submit region end(Prohibit modification and deletion)

}