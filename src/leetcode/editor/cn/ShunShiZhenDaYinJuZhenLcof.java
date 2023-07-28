package leetcode.editor.cn;

//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
//
// Related Topics 数组 矩阵 模拟 👍 509 👎 0

import java.util.*;

public class ShunShiZhenDaYinJuZhenLcof{
    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
//        int m = matrix.length;
//        if(m==0) return  new int[]{};
//        int n = matrix[0].length;
//        int upper_bund = 0, lower_bound = m - 1;
//        int left_bound = 0, right_bound = n - 1;
//        List<Integer> res = new ArrayList<Integer>();
//
//        while (res.size() < n * m) {
//            if (upper_bund <= lower_bound) {
//                for (int i = left_bound; i <= right_bound; i++) {
//                    res.add((matrix[upper_bund][i]));
//                }
//                upper_bund++;
//            }
//            if (left_bound <= right_bound) {
//                for (int i = upper_bund; i <= lower_bound; i++) {
//                    res.add(matrix[i][right_bound]);
//                }
//                right_bound--;
//            }
//            if (upper_bund <= lower_bound) {
//                for (int i = right_bound; i >= left_bound; i--) {
//                    res.add((matrix[lower_bound][i]));
//                }
//                lower_bound--;
//            }
//            if (left_bound <= right_bound) {
//                for (int i = lower_bound; i >= upper_bund; i--) {
//                    res.add(matrix[i][left_bound]);
//                }
//                left_bound++;
//            }
//
//        }
//        int[] res2 = new int[n * m];
//        for (int i = 0; i < n * m; i++) {
//            res2[i] = res.get(i);
//        }
//        return res2;
        int m=matrix.length;;
        if(m==0) return new int[]{};
        int n=matrix[0].length;
        int upperBond=0,lowerBond=m-1;
        int leftBond=0,rightBond=n-1;

        List<Integer> res=new ArrayList<>();
        while(res.size()<n*m){
            if(upperBond<=lowerBond){
                for(int i=leftBond;i<=rightBond;i++){
                    res.add(matrix[upperBond][i]);
                }
                upperBond++;
            }
            if(leftBond<=rightBond){
                for(int i=upperBond;i<=lowerBond;i++){
                    res.add(matrix[i][rightBond]);
                }
                rightBond--;
            }
            if(upperBond<=lowerBond){
                for(int i=rightBond;i>=leftBond;i--){
                    res.add(matrix[lowerBond][i]);
                }
                lowerBond--;
            }
            if(leftBond<=rightBond){
                for(int i=lowerBond;i>=upperBond;i--){
                    res.add(matrix[i][leftBond]);
                }
                leftBond++;
            }

        }
        return res.stream().mapToInt(Integer::intValue).toArray();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}