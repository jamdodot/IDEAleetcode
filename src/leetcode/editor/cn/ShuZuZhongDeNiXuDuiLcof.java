package leetcode.editor.cn;

//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 983 👎 0

public class ShuZuZhongDeNiXuDuiLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
        int [] input=new int[]{7,5,6,4};
        System.out.println(solution.reversePairs(input));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int count=0;
    public int reversePairs(int[] nums) {
//        if(nums.length==0||nums.length==1) return 0;
//        mergeSort(nums,0,nums.length-1);
//        return count;
//
//    }
//    public void mergeSort(int [] nums,int left ,int right){
//        if(left>=right)return ;
//        int mid=left+(right-left)/2;
//        mergeSort(nums,left,mid);
//        mergeSort(nums,mid+1,right);
//        merge(nums,left,mid,right);
//    }
//    public void merge(int [] nums,int left ,int mid,int right){
//        int [] temp=new int[right-left+1];
//        int i=left;
//        int j=mid+1;
//        int t=0;
//        while(i<=mid&&j<=right){
//            if(nums[i]<=nums[j]){
//                temp[t++]=nums[i++];
//            }
//            else{
//                count+=mid+1-i;
//                temp[t++]=nums[j++];
//            }
//        }
//        while(i<=mid){
//            temp[t++]=nums[i++];
//        }
//        while(j<=right){
//            temp[t++]=nums[j++];
//        }
//        for(int k=0;k<temp.length;k++){
//            nums[left+k]=temp[k];
//        }
    return 0;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}