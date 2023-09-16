package leetcode.editor.cn;

//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics 回溯 👍 1493 👎 0

import java.util.ArrayList;
import java.util.List;

public class Combinations{
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        solution.combine(4,2);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    boolean[] used;
    List<Integer> path=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        used=new boolean[n];
        int [] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        backtrace(nums,k, 0);
        return res;
    }

    public void backtrace(int [] nums,int k, int start){
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<nums.length-(k-path.size())+1;i++){
            path.add(nums[i]);
            backtrace(nums,k, i+1);
            path.remove(path.size()-1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}