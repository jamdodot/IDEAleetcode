package leetcode.editor.cn;

//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。 
//
// 
//
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
// 
//
// 示例 2: 
//
// 输入: 2
//输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0
//.05556,0.02778] 
//
// 
//
// 限制： 
//
// 1 <= n <= 11 
//
// Related Topics 数学 动态规划 概率与统计 👍 545 👎 0

public class NgeTouZiDeDianShuLcof{
    public static void main(String[] args) {
        Solution solution = new NgeTouZiDeDianShuLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] dicesProbability(int n) {
       int min=n ,max=n*6;
       double dp[][] =new double[min+1][max+1];
       for(int i=1;i<=6;i++){
           dp[1][i]=1/6.0;
       }
       for(int i=2;i<=n;i++){
           for(int j=i*1;j<=i*6;j++){
               for(int k=1;k<=6;k++){
                   if(j-k<=0){
                       break;
                   }
                   dp[i][j]+=dp[i-1][j-k]*1/6;
               }
           }
       }
       double[] res=new double [max-min+1];
       for(int i=0;i<res.length;i++){
           res[i]=dp[n][min+i];

       }
       return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}