package leetcode.editor.cn;

//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
//
// Related Topics 位运算 数组 👍 438 👎 0

import java.util.HashMap;
import java.util.Map;

public class ShuZuZhongShuZiChuXianDeCiShuIiLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        Map<Integer,Integer> res  =new HashMap<>();
        for(int num:nums){
            res.put(num,res.getOrDefault(num,0)+1);
        }
        for(int num:nums){
            if(res.get(num)==1){
                return num;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}