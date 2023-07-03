package leetcode.editor.cn;

//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。 
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 1351 👎 0

public class Sqrtx{
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        System.out.println(solution.mySqrt(2147395599));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        if(x==0||x==1) return x;
        return toSearch(x,0,x);


    }
    int toSearch(int x,int start,int end){
        int mid=(start+end)/2;
        if(mid<=(x/mid)&&(mid+1)>x/(mid+1)){
            return mid;
        }
        if(mid<(x/mid)){
            return toSearch(x,mid,end);
        }else{
            return toSearch(x,start,mid);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}