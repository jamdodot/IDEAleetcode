package leetcode.editor.cn;

//给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，如果这些点构成一个 回旋镖 则返回 true 。
// 
//
// 回旋镖 定义为一组三个点，这些点 各不相同 且 不在一条直线上 。 
//
// 
//
// 示例 1： 
//
// 
//输入：points = [[1,1],[2,3],[3,2]]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：false 
//
// 
//
// 提示： 
// 
//
// 
// points.length == 3 
// points[i].length == 2 
// 0 <= xi, yi <= 100 
// 
// Related Topics 几何 数组 数学 👍 45 👎 0

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidBoomerang{
    public static void main(String[] args) {
        Solution solution = new ValidBoomerang().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isBoomerang(int[][] points) {
        int [] l1={points[1][0]-points[0][0],points[1][1]-points[0][1]}; //x2-x1  y2-y1
        int [] l2={points[2][0]-points[0][0],points[2][1]-points[0][1]};//x3-x1  y3-y1
        return l1[0]*l2[1]!=l1[1]*l2[0];//除法转换为乘法
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}