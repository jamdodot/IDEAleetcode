package leetcode.editor.cn;

//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
//
// Related Topics 数组 哈希表 分治 计数 排序 👍 360 👎 0

import java.util.HashMap;

public class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof().new Solution();
        int[] input=new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println(solution.majorityElement(input));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length==1||nums.length==2) return nums[0];
//        HashMap<Integer,Integer> res=new HashMap<>();
//        int half=nums.length/2;
//        for(int i=0;i<nums.length;i++){
//            res.put(nums[i],res.getOrDefault(nums[i],0)+1);
//            if(res.get(nums[i])>half){
//                return nums[i];
//            }
//        }
//        return -1;
        quickSort(nums,0,nums.length-1);
        return nums[nums.length/2];
    }
    public void  quickSort(int[] nums,int left,int right){
        if(left>=right)return;
        int pivot=nums[left+(right-left)/2];
        int i=left,j=right;
        while(i<j){
            while(nums[i]<pivot){
                i++;
            }
            while(nums[j]>pivot){
                j--;
            }
            if(i<j){
                int tmp= nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
                i++;
                j--;
            }else if(i==j){
                i++;
            }
        }
        quickSort(nums,left,j);
        quickSort(nums,i,right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}