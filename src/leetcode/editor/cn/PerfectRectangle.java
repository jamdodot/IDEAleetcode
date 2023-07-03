package leetcode.editor.cn;

//给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。这个矩形的左下顶点是
// (xi, yi) ，右上顶点是 (ai, bi) 。 
//
// 如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。 
// 
//
// 示例 1： 
//
// 
//输入：rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
//输出：true
//解释：5 个矩形一起可以精确地覆盖一个矩形区域。 
// 
//
// 示例 2： 
//
// 
//输入：rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]
//输出：false
//解释：两个矩形之间有间隔，无法覆盖成一个矩形。 
//
// 示例 3： 
//
// 
//输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[3,2,4,4]]
//输出：false
//解释：图形顶端留有空缺，无法覆盖成一个矩形。 
//
// 示例 4： 
//
// 
//输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]
//输出：false
//解释：因为中间有相交区域，虽然形成了矩形，但不是精确覆盖。 
//
// 
//
// 提示： 
//
// 
// 1 <= rectangles.length <= 2 * 10⁴ 
// rectangles[i].length == 4 
// -10⁵ <= xi, yi, ai, bi <= 10⁵ 
// 
// Related Topics 数组 扫描线 👍 112 👎 0

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PerfectRectangle{
    public static void main(String[] args) {
        Solution solution = new PerfectRectangle().new Solution();
        int [][]input={{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        System.out.println( solution.isRectangleCover(input));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        float X1=Float.MAX_VALUE,Y1=Float.MAX_VALUE;
        float X2=Float.MIN_VALUE,Y2=Float.MIN_VALUE;
        Set<int[]> points=new HashSet<int[]>();
        float actual_area=0;
        for(int [] temp:rectangles){
            X1=Math.min(X1,temp[0]);
            Y1=Math.min(Y1,temp[1]);
            X2=Math.max(X2,temp[2]);
            Y2=Math.max(Y2,temp[3]);
            actual_area+=(temp[2]-temp[0])*(temp[3]-temp[1]);
            int x1=temp[0],x2=temp[2],y1=temp[1],y2=temp[3];
            int[]p1={x1,y1};
            int[]p2={x2,y2};
            int[]p3={x2,y1};
            int[]p4={x1,y2};
            int[][] pp={p1,p2,p3,p4};
            boolean flag=true;
            for(int[]p:pp){
                for(Iterator<int []> i = points.iterator(); i.hasNext();){
                        int[] inset=i.next();
                        if(inset[0]==p[0]&&inset[1]==p[1]){
                            i.remove();
                            flag=false;
                        }
                    }
                if(flag){
                    points.add(p);
                }
                flag=true;
                }

        }
        float expected_area=(X2-X1)*(Y2-Y1);
        if(actual_area!=expected_area){
            return  false;
        }
        if(points.size()!=4){
            return false;
        }
        float[]p1={X1,Y1};
        float[]p2={X2,Y2};
        float[]p3={X2,Y1};
        float[]p4={X1,Y2};
        int count=0;
        for(int[] arr:points){
            if(p1[0]==arr[0]&&p1[1]==arr[1]){
                count++;
            }
            if(p2[0]==arr[0]&&p2[1]==arr[1]){
                count++;
            }
            if(p3[0]==arr[0]&&p3[1]==arr[1]){
                count++;
            }
            if(p4[0]==arr[0]&&p4[1]==arr[1]){
                count++;
            }
        }
        if(count!=4)return false;

        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}