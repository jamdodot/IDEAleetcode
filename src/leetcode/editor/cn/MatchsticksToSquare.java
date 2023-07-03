package leetcode.editor.cn;

//你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能
//折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。 
//
// 如果你能使这个正方形，则返回 true ，否则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: matchsticks = [1,1,2,2,2]
//输出: true
//解释: 能拼成一个边长为2的正方形，每边两根火柴。
// 
//
// 示例 2: 
//
// 
//输入: matchsticks = [3,3,3,3,4]
//输出: false
//解释: 不能用所有火柴拼成一个正方形。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= matchsticks.length <= 15 
// 1 <= matchsticks[i] <= 10⁸ 
// 
// Related Topics 位运算 数组 动态规划 回溯 状态压缩 👍 309 👎 0

import jdk.nashorn.internal.runtime.regexp.joni.constants.MetaChar;

import java.util.Arrays;

public class MatchsticksToSquare{
    public static void main(String[] args) {
        Solution solution = new MatchsticksToSquare().new Solution();
        int[] input={3,3,3,3,4};
        System.out.println(solution.makesquare(input));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length<4)return false;
        int sum=0;
        for(int l:matchsticks){
            sum+=l;
        }
        if(sum%4!=0) return false;
        int [] edge=new int[4];
        int target=sum/4;
        Arrays.sort(matchsticks);
        for(int i=0,j=matchsticks.length-1;i<j;i++,j--){
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        return backtrack(matchsticks,0,edge,target);
    }
    public boolean backtrack(int[] matchsticks,int index,int[] edge,int target){
        if(index==matchsticks.length){
            for(int i=0;i<edge.length;i++){
                if(edge[i]!=target){
                    return false;
                }
            }
            return true;
        }
        for(int i=0;i<edge.length;i++){
            if(edge[i]+matchsticks[index]>target){
                continue;
            }
            edge[i]+=matchsticks[index];
            if(backtrack(matchsticks,index+1,edge,target)){
                return true;
            }
           // edge[i]-= matchsticks[index];
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}