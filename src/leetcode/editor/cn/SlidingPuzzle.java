package leetcode.editor.cn;

//在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示. 
//
// 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换. 
//
// 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。 
//
// 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。 
//
// 示例： 
//
// 
//输入：board = [[1,2,3],[4,0,5]]
//输出：1
//解释：交换 0 和 5 ，1 步完成
// 
//
// 
//输入：board = [[1,2,3],[5,4,0]]
//输出：-1
//解释：没有办法完成谜板
// 
//
// 
//输入：board = [[4,1,2],[5,0,3]]
//输出：5
//解释：
//最少完成谜板的最少移动次数是 5 ，
//一种移动路径:
//尚未移动: [[4,1,2],[5,0,3]]
//移动 1 次: [[4,1,2],[0,5,3]]
//移动 2 次: [[0,1,2],[4,5,3]]
//移动 3 次: [[1,0,2],[4,5,3]]
//移动 4 次: [[1,2,0],[4,5,3]]
//移动 5 次: [[1,2,3],[4,5,0]]
// 
//
// 
//输入：board = [[3,2,4],[1,5,0]]
//输出：14
// 
//
// 提示： 
//
// 
// board 是一个如上所述的 2 x 3 的数组. 
// board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列. 
// 
// Related Topics 广度优先搜索 数组 矩阵 👍 246 👎 0

import com.sun.org.apache.bcel.internal.generic.SWAP;

import javax.xml.transform.sax.SAXTransformerFactory;
import java.util.*;

public class SlidingPuzzle{
    public static void main(String[] args) {
        Solution solution = new SlidingPuzzle().new Solution();
        int[][] board={{4,1,2},{5,0,3}};
        System.out.println(solution.slidingPuzzle(board));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int slidingPuzzle(int[][] board) {
        int m=2,n=3;
        String start="";
        String target="123450";
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                start+=board[i][j];
            }
        }
       int [][] neighbor={{ 1, 3 },
               { 0, 4, 2 },
               { 1, 5 },
               { 0, 4 },
               { 3, 1, 5 },
               { 4, 2 }};
        Queue<String> q=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        q.add(start);
        visited.add(start);
        int step=0;
        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                String cur=q.poll();
                if(target.equals(cur)){
                    return  step;
                }
                int idx =0;
                char[]cur_=cur.toCharArray();
                for(;cur_[idx]!='0';idx++);
                for(int adj:neighbor[idx]){
                    String new_board=cur;
                    new_board=swap(new_board,adj,idx);
                    if(!visited.contains(new_board)){
                        q.offer(new_board);
                        visited.add(new_board);
                    }

                }
            }
            step++;
        }
        return -1;
    }
    public String swap(String new_board,int adj,int idx){
                char[] S_= new_board.toCharArray();
                char temp=S_[adj];
                S_[adj]=S_[idx];
                S_[idx]=temp;
                return String.valueOf(S_);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}