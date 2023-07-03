package leetcode.editor.cn;

//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
//
// Related Topics 字符串 回溯 👍 660 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZiFuChuanDePaiLieLcof{
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<String> res=new ArrayList<>();
        StringBuilder track=new StringBuilder();
        Boolean[] used ;
    public String[] permutation(String s) {
        sortArray(s.toCharArray());
        String[] resArray=new String[res.size()];
        for(int i=0;i<res.size();i++){
            resArray[i]=res.get(i);
        }
        return resArray;
    }
    public List<String> sortArray(char[] nums){
        Arrays.sort(nums);
        used=new Boolean[nums.length];
        backtrace(nums);
        return res;

    }

    public void backtrace(char[] nums){
        if(track.length()==nums.length){
            res.add(track.toString());
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            if(i>0&&nums[i]==nums[i-1]&&!used[i-1]){
                continue;
            }
            track.append(nums[i]);
            used[i]=true;
            backtrace(nums);
            track.deleteCharAt(track.length()-1);
            used[i]=false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}