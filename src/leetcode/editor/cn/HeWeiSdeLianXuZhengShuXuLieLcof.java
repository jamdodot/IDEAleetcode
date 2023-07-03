package leetcode.editor.cn;

//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
//
// Related Topics 数学 双指针 枚举 👍 536 👎 0

import java.util.ArrayList;
import java.util.List;

public class HeWeiSdeLianXuZhengShuXuLieLcof{
    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        System.out.println(solution.findContinuousSequence(9));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> list=new ArrayList<>();
        int mid=target/2+1;
        int i=mid;
        while(i>1){
            int j=i;
            int target_=target;
            List<Integer> list_inside=new ArrayList<>();
            while(j>=1&&target_>0){
                target_-=j;
                list_inside.add(j);
                j--;
            }
            if(target_==0){
                list.add(list_inside);
            }
            i--;
        }
        int[][] res=new int[list.size()][];
        int idx0=0;
        list.sort((a,b)->a.get(0)-b.get(0));
        for(List<Integer> list_:list){
            int [] res_=new int[list_.size()];
            list_.sort((a,b)->a-b);
            int idx=0;
            for(Integer num:list_){
                res_[idx]=num;
                idx++;
            }
            res[idx0]=res_;
            idx0++;
        }
        return res;



    }
}
//leetcode submit region end(Prohibit modification and deletion)

}