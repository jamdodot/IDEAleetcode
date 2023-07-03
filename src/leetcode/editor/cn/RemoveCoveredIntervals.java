package leetcode.editor.cn;

//给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。 
//
// 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。 
//
// 在完成所有删除操作后，请你返回列表中剩余区间的数目。 
//
// 
//
// 示例： 
//
// 
//输入：intervals = [[1,4],[3,6],[2,8]]
//输出：2
//解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 1000 
// 0 <= intervals[i][0] < intervals[i][1] <= 10^5 
// 对于所有的 i != j：intervals[i] != intervals[j] 
// 
// Related Topics 数组 排序 👍 65 👎 0

import java.beans.IntrospectionException;
import java.util.Arrays;
import java.util.Comparator;

public class RemoveCoveredIntervals{
    public static void main(String[] args) {
        Solution solution = new RemoveCoveredIntervals().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0];
//            }
//        });
//        int left=intervals[0][0];
//        int right=intervals[0][1];
//
//        int res=0;
//        for(int i=1;i<intervals.length;i++){
//            int[]intv=intervals[i];
//            if(left<=intv[0]&&right>=intv[1]){
//                res++;
//            }
//            if(right>=intv[0]&&right<=intv[1]){
//                right=intv[1];
//            }
//            if(right<intv[0]){
//                left=intv[0];
//                right=intv[1];
//
//            }
//        }
//        return intervals.length-res;

    Arrays.sort(intervals, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0];
        }
    });
    int left=intervals[0][0];
    int right=intervals[0][1];

    int res=0;
    for(int i=0;i<intervals.length;i++){
        int[] temp=intervals[i];
        if(left<=temp[0]&&right>=temp[1]){
        res++;
        }
        if(right>=temp[0]&&right<=temp[1]){
            right=temp[1];
        }
        if(right<temp[0]){
            left=temp[0];
            right=temp[1];
        }
    }
    return intervals.length-res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}