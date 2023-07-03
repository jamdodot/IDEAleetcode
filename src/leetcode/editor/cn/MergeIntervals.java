package leetcode.editor.cn;

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
// Related Topics 数组 排序 👍 1434 👎 0

import com.sun.javafx.image.IntPixelGetter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals{
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        int [][] input={{1,3},{2,6},{8,10},{15,18}};
        solution.merge(input);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        int left=intervals[0][0];
        int right=intervals[0][1];


        for(int i=1;i<intervals.length;i++){
            int[] temp=intervals[i];
            if(left<=temp[0]&&right>=temp[1]){

            }
            if(temp[0]<=right&&temp[1]>=right){
                right=temp[1];
            }
            if(temp[0]>right){
                int [] l1=new int [2];
                l1[0]=left;
                l1[1]=right;
                res.add(l1);
                left=temp[0];
                right=temp[1];
            }

        }
        int [] l1=new int [2];
        l1[0]=left;
        l1[1]=right;
        res.add(l1);
        int[][] resArr = new int[res.size()][];
        for (int i = 0; i < res.size(); i++)
            resArr[i] = res.get(i);
        return resArr;



    }
}
//leetcode submit region end(Prohibit modification and deletion)

}