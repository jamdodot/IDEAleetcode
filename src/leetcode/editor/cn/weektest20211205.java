package leetcode.editor.cn;

import java.util.List;

public class weektest20211205 {

    class Solution {
        public int countHousePlacements(int n) {
            if (n==1) return 4;
            int res=0;
            res=n+n-1;
            int tag=(int)Math.pow(10,9)+7;
            int res_temp=(res%tag);
            return res_temp*res_temp;

        }
    }
}

