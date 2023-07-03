package leetcode.editor.cn;

//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 字符串 排序 👍 1124 👎 0

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber{
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
//        if(nums.length==0||nums==null) return"";
//        if(nums.length==1) return String.valueOf(nums[0]);
//        String[] strArr=new String[nums.length];
//        for(int i=0;i<nums.length;i++){
//            strArr[i]=String.valueOf(nums[i]);
//        }
//        Arrays.sort(strArr, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return (o2+o1).compareTo((o1+o2));
//            }
//        });
//        StringBuilder sb=new StringBuilder();
//        for(String s:strArr){
//            sb.append(s);
//        }
//        if(sb.charAt(0)=='0'){
//            return "0";
//        }
//        return sb.toString();
        return Arrays.stream(nums)
                .boxed()
                .map(String::valueOf)
                .sorted((o1,o2)->(o2+o1).compareTo(o1+o2))
                .reduce(String::concat)
                .filter(s->!s.startsWith("0"))
                .orElse("0");

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}