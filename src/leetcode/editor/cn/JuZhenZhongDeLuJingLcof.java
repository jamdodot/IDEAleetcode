package leetcode.editor.cn;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
//
// Related Topics 数组 回溯 矩阵 👍 756 👎 0

public class JuZhenZhongDeLuJingLcof{
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean exist(char[][] board, String word) {

        int n=board.length;
        int m=board[0].length;

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if (backtrack(board,word,0,i,j)){
                    return true;
                    }
                }
            }

        return false;
    }
    int [] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    Boolean backtrack(char [][]board,String word,int u,int x,int y){
             if(board[x][y]!=word.charAt(u))return false;
             if(u==word.length()-1)return true;
             char t=board[x][y];
             board[x][y]='.';
             for(int i=0;i<4;i++) {
                 int a = x + dx[i], b = y + dy[i];
                 if (a < 0 || a >= board.length || b < 0 || b >= board[0].length || board[a][b] == '.') continue;
                 if (backtrack(board, word, u+1, a, b)) return true;
             }
             board[x][y]=t;
             return false;

            }
    }

//leetcode submit region end(Prohibit modification and deletion)

}