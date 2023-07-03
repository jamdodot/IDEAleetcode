package leetcode.editor.cn;

//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
//
// Related Topics 位运算 数组 👍 801 👎 0

public class ShuZuZhongShuZiChuXianDeCiShuLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumbers(int[] nums) {
        int x=0;
        for(int num:nums){
            x^=num;
        }
        int flag=x&(-x);
        int res=0;
        for(int num:nums){
            if((num&flag)!=0){
                res^=num;
            }
        }
        return new int[]{res,x^res};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}