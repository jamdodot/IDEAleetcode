package leetcode.editor.cn.CodeExam.kedaxunfei;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/07/22/20:40
 * @Description:
 */
public class Test2 {
    /**
     * 小红定义一个 字符串的权值如下:
     * 不断进行如下操作:选择字符串的若干不相邻的字符删除。
     * 最终使得字符串所有字符相同的最小操作次数为初始字符串
     * 权值。
     * 例如"arcaea"-> "araa"->"aaa",需要操作2次使得字符串所
     * 有字符相等。所以"arcaea"的权值为2。
     * 现在给定两个正整数n和k,小红希望你构造一个长度为n
     * 内、仅由小写字母组成的字符串，其权值等于k。
     *
     * @param args
     */
    public static void main(String[] args) {


    }
    public static String getStr(int n,int k){
        if(n<=Math. pow(2,k-1)) return "-1";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Math. pow(2 , k-1);i++){
            sb.append('b');
        }
        while(sb.length()<n){
            sb.append("a");
        }
        return sb.toString();
    }
}
