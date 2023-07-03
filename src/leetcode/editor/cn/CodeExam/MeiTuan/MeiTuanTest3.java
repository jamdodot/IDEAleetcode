package leetcode.editor.cn.CodeExam.MeiTuan;


import java.util.Scanner;

public class MeiTuanTest3 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int n_=num;
        while(n_>0) {
            int [][] input=new int[3][num];
            for(int i=0;i<3;i++){
                for(int j=0;j<num;j++){
                    input[i][j]=sc.nextInt();
                }
            }
            for(int i=1;i<num;i++) {
                if (input[1][i] <= input[2][i - 1]) {
                    input[2][i - 1] = input[2][i - 1] - input[1][i];
                }
            }
            int sum=0;
            for(int i=0;i<num;i++){
                sum+=input[1][i]*input[2][i];
            }
            System.out.println(sum);

        }

    }


}
