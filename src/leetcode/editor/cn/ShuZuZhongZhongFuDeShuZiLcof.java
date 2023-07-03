package leetcode.editor.cn;

//找出数组中重复的数字。 
//
// 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
//请找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
//
// Related Topics 数组 哈希表 排序 👍 1097 👎 0

import java.util.HashMap;

public class ShuZuZhongZhongFuDeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongZhongFuDeShuZiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findRepeatNumber(int[] nums) {
//        HashMap<Integer,Integer> count =new HashMap<>();
//        for (int i:nums){
//            count.put(i,count.getOrDefault(i,0)+1);
//            if (count.get(i)>1){
//                return i;
//            }
//
//        }
//        return -1;
        sort(nums,0,nums.length-1);
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return -1;



    }
    public void sort(int[] nums,int head,int tail){
        if  (head>tail||nums==null||nums.length<=1){
            return;
        }
        int pivot = nums[(head+tail)/2];
        int i = head;
        int j= tail;
        while (i<j){
            while (nums[i]<pivot){
                i++;
            }
            while (nums[j]>pivot){
                j--;
            }
            if(i<j){
                int temp = nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j--;
            }
            if(i==j){
                i++;
            }
            sort(nums,head,j);
            sort(nums,i,tail);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}