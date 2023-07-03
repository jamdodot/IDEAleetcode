package leetcode.editor.cn;

//在一个 n * m 的二维数组中，每一行都按照从左到右 非递减 的顺序排序，每一列都按照从上到下 非递减 的顺序排序。请完成一个高效的函数，输入这样的一个二
//维数组和一个整数，判断数组中是否含有该整数。 
//
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// 
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
//
// 
//
// 限制： 
//
// 0 <= n <= 1000 
//
// 0 <= m <= 1000 
//
// 
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
//
// Related Topics 数组 二分查找 分治 矩阵 👍 897 👎 0

public class ErWeiShuZuZhongDeChaZhaoLcof {
    public static void main(String[] args) {
        Solution solution = new ErWeiShuZuZhongDeChaZhaoLcof().new Solution();
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        solution.findNumberIn2DArray(matrix, 5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
//        for(int i=0;i<matrix.length;i++){
//            for(int j=0;j<matrix[i].length;j++){
//                if(matrix[i][j]==target){
//                    return true;
//                }
//            }
//        }
//        return false;

            //二分查找
//            for (int i = 0; i < matrix.length; i++) {
//                int left = 0;
//                int right = matrix[i].length - 1;
//                while (left <= right) {
//                    int mid = left + (right - left) / 2;
//                    if (matrix[i][mid] == target) {
//                        return true;
//                    } else if (matrix[i][mid] > target) {
//                        right = mid - 1;
//                    } else {
//                        left = mid + 1;
//                    }
//                }
//            }
//            return false;
            //z字查找
            if (matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            int i = 0;
            int j = matrix[i].length - 1;
            while (i < matrix.length && j >= 0) {
                if (matrix[i][j] == target) {
                    return true;

                } else if (matrix[i][j] > target) {
                    j--;
                } else {
                    i++;


                }


            }
            return false;
//leetcode submit region end(Prohibit modification and deletion)

        }
    }
}