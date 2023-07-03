package leetcode.editor.cn;

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 543 👎 0

public class ZuiXiaoDeKgeShuLcof{
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length==0||k==0)return new int[]{};
        if(arr.length==1) return arr;
        sort(arr,0,arr.length-1);
        int [] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=arr[i];
        }
        return res;
    }
    public void sort(int[] arr,int left,int right){
        if(left >=right) return;
        int i=left,j=right;
        int pivot=arr[left+(right-left)/2];
        while(i<j){
            while(pivot>arr[i]){
                i++;
            }
            while(pivot<arr[j]){
                j--;
            }
            if(i<j){
                int t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
                i++;
                j--;
            }else if(i==j){
                i++;
            }
            sort(arr,left,j);
            sort(arr,i,right);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}