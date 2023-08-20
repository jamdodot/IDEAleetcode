package leetcode.editor.cn;

//二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。 
//
// 请返回 封闭岛屿 的数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,
//0,1],[1,1,1,1,1,1,1,0]]
//输出：2
//解释：
//灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1,1,1,1,1],
//             [1,0,0,0,0,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,1,0,1,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,0,0,0,0,1],
//             [1,1,1,1,1,1,1]]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[0].length <= 100 
// 0 <= grid[i][j] <=1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 260 👎 0

public class NumberOfClosedIslands{
    public static void main(String[] args) {
        Solution solution = new NumberOfClosedIslands().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int closedIsland(int[][] grid) {
        int res=0;
        for(int i=1;i<grid.length;i++){
          for(int j=1;j<grid[i].length;j++){
               if(grid[i][j]!=1&&dfs(grid,i,j)){
                  res++;

              }
          }
        }
        return res;
    }
    public  boolean dfs(int [][] grid,int i,int j){
        if(grid[i][j]==1){
            return true;
        }
        if(grid[i][j]==0&&(i==0||j==0||i==grid.length-1||j==grid[0].length-1)){
            return false;
        }
        grid[i][j]=1;
        int [][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        boolean res=true;
        for(int [] d:dir){
            int x=d[0]+i;
            int y=d[1]+j;
            //使用&& 递归的放在前面
            res=dfs(grid,x,y)&&res;
        }
        return res;
    }
//        int total = 0;
//        for (int i = 1; i < grid.length; i++) {
//            for (int j = 1; j < grid[i].length; j++) {
//                if (grid[i][j] != 1 && dfs(i, j, grid)) {
//                    total++;
//                }
//            }
//        }
//
//        return total;
//    }
//
//    private boolean dfs(int i, int j, int[][] grid) {
//        // 如果该位置位1  则说明这一点是封闭的(还需要判断其他三个点)
//        if (grid[i][j] == 1) {
//            return true;
//        }
//
//        // 如果0在边界  则不可能封闭
//        if (grid[i][j] == 0 && (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1)) {
//            return false;
//        }
//        grid[i][j] = 1;
//
//        int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//
//        boolean res = true;
//
//        // 遍历上下左右
//        for (int[] dir : direct) {
//            int x = dir[0] + i;
//            int y = dir[1] + j;
//            res &= dfs(x, y, grid);
//        }
//
//        return res;
    }
//leetcode submit region end(Prohibit modification and deletion)

}