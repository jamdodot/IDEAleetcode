package leetcode.editor.cn;

//从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
//可以看成任意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 
//输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
//
// Related Topics 数组 排序 👍 323 👎 0

import java.util.Arrays;

public class BuKePaiZhongDeShunZiLcof{
    public static void main(String[] args) {
        Solution solution = new BuKePaiZhongDeShunZiLcof().new Solution();
        int[] input={0,0,2,2,5};
        System.out.println(solution.isStraight(input));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int num_0=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0){
                num_0++;
            }else{
                break;
            }
        }
        for(int i=num_0+1;i<nums.length;i++){
            if(num_0>0){
                if(nums[i]==nums[i-1]+1){
                    continue;
                }else if(nums[i]>nums[i-1]+1){
                    int temp=nums[i]-nums[i-1]-1;
                    num_0-=temp;
                    if(num_0<0){
                        return false;
                    }
                }else if(nums[i]==nums[i-1]){
                    return false;
                }

            }else if(num_0<=0) {
                if (nums[i] > nums[i - 1] + 1 || nums[i] == nums[i - 1]) {
                    return false;
                }
            }
        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}