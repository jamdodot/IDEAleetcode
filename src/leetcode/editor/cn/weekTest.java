package leetcode.editor.cn;
import com.sun.javafx.scene.EnteredExitedHandler;
import com.sun.javafx.scene.SceneUtils;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.InputStream;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.util.*;

public class weekTest {
    public static void main(String[] args) {
        String[] foods={"kimchi","miso","sushi","moussaka","ramen","bulgogi"};
        String[] cuisines={"korean","japanese","japanese","greek","japanese","korean"};
        int[] ratings={9,12,8,15,14,7};
        FoodRatings solution = new weekTest().new FoodRatings(foods,cuisines,ratings);
        solution.highestRated("korean");

        return ;

    }

    class FoodRatings {
//        food+cuisines ranking
        Map<String,Integer> table=new HashMap<>();
        int n;
        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            n= foods.length;
                for(int i=0;i<foods.length;i++){
                    String temp=foods[i]+" "+cuisines[i];
                    table.put(temp,ratings[i]);
                }
        }

        public void changeRating(String food, int newRating) {
            for(Map.Entry<String,Integer> entry:table.entrySet()){
                if(entry.getKey().split(" ")[0].equals(food)){
                    table.put(food+" "+entry.getKey().split(" ")[1],newRating);
                }
            }
        }

        public String highestRated(String cuisine) {
            String[] res=new String[n];
            int idx=0;
            int count=0;
            for(Map.Entry<String,Integer> entry:table.entrySet()){
                if(entry.getKey().split(" ")[1].equals(cuisine)){
                   res[idx++]=entry.getKey().split(" ")[0];
                   count++;
                }
            }
//            Arrays.sort(res, new Comparator<String>() {
//                @Override
//                public int compare(String o1, String o2) {
//                    return o1==o2?o2-o1:o1-o2;
//                }
//            });

            String[] res2=new String[count];
            for(int i=0;i<count;i++){
                res2[i]=res[i];
            }

            Arrays.sort(res2, (o1,o2) -> (o1 + o2).compareTo((o2 + o1)));
            return res2[0];
        }
    }

}


