package leetcode.editor.cn;

//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1074 👎 0

public class SpiralMatrixIi{
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        int loop=0;
        int i,j=0;
        int start=0;
        int count =1;
        while(loop++<n/2){
            for(j=start;j<n-loop;j++){
                res[start][j]=count++;
            }
            for(i=start;i<n-loop;i++){
                res[i][j]=count++;
            }
            for(;j>=loop;j--){
                res[i][j]=count++;
            }
            for(;i>=loop;i--){
                res[i][j]=count++;
            }
            start++;
        }
        if(n%2==1){
            res[start][start]=count;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}