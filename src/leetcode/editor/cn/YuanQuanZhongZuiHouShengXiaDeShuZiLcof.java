package leetcode.editor.cn;

//0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
// 
//
// 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。 
//
// 
//
// 示例 1： 
//
// 
//输入: n = 5, m = 3
//输出: 3
// 
//
// 示例 2： 
//
// 
//输入: n = 10, m = 17
//输出: 2
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10^5 
// 1 <= m <= 10^6 
// 
//
// Related Topics 递归 数学 👍 778 👎 0

import java.util.Arrays;

public class YuanQuanZhongZuiHouShengXiaDeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new YuanQuanZhongZuiHouShengXiaDeShuZiLcof().new Solution();
        System.out.println(solution.lastRemaining(5,3));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastRemaining(int n, int m) {
//        boolean[] flag = new boolean[n];
//        Arrays.fill(flag, true);
//        int count = 0, index = 0;
//        while(count < n-1){
//            int temp_count=m;
//            while(temp_count > 0){
//               if(index == n){
//                   index = 0;
//               }
//               else if(flag[index]){
//                   temp_count--;
//                   index++;
//               }else if (!flag[index]){
//                   index++;
//               }
//            }
//            flag[index-1] = false;
//            count++;
//        }
//        for(int i = 0; i < n; i++){
//            if(flag[i]){
//                index = i;
//                break;
//            }
//        }
//        return index;
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}