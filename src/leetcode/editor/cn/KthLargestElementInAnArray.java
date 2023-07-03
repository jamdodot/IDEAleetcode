package leetcode.editor.cn;

//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1535 👎 0

public class KthLargestElementInAnArray{
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        int [] input={3,2,1,5,6,4};
        System.out.println(solution.findKthLargest(input,2));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
       int lo=0,hi=nums.length-1;
       k=nums.length-k;
        while(lo<=hi){
            int p=partiton(nums,lo,hi);
            if(p<k){
//                二分的思想
                lo=p+1;
            }else if(p>k){
                hi=p-1;
            }else{
                return nums[p];
            }

        }
        return -1;
    }

    int partiton(int[] nums,int lo,int hi){
        if(lo==hi)return lo;
        int pivot=nums[lo];
        int i=lo,j=hi+1;
        while(true){
            while(nums[++i]<pivot){
                if(i==hi) break;
            }
            while(nums[--j]>pivot){
                if(j==lo) break;
            }
            if(i>=j) break;
            swap(nums,i,j);
        }
//        能够确定主元pivot的位置 便返回他的
        swap(nums,j,lo);
        return j;
    }
    void  swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}