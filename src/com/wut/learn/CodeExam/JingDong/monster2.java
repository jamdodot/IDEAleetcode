package com.wut.learn.CodeExam.JingDong;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/08/26/20:40
 * @Description:
 */
class Role{
    String name;
    int total;
    boolean isDead=false;
    public Role(String name, int total){
        this.name=name;
        this.total=total;
        this.isDead=false;
    }
}
public class monster2 {
    public static void main(String[]args){
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        Role[] ans=new Role[n+1];
        for(int i=1;i<=n;i++){
            ans[i]=new Role(in.next(),in.nextInt());
        }
        for(int i=0;i<m;i++){
            int x,y;
            char x2y,y2x;
            x=in.nextInt();y=in.nextInt();
            x2y=in.next().equals("Y")?'Y':'N';
            y2x=in.next().equals("Y")?'Y':'N';
            battle(ans,x,y,x2y,y2x);
        }
        for(int i=1;i<ans.length;i++){
            System.out.println(ans[i].isDead?"N":"Y");
        }

    }
    public static void battle(Role[] ans,int x,int y,char xState ,char  yState) {
        if (ans[x].isDead || ans[y].isDead) {
            return;
        }
        if (ans[x].name.equals(ans[y].name)) {
            return;
        } else if (xState == 'Y' && yState == 'N') {
            if (ans['X'].name.equals("Human")) {
                Gan(ans, x, y);
            } else {
                if (ans[y].total > ans[x].total) {
                    ans[x].isDead = true;
                }
            }

        } else if (xState == 'N' && yState == 'Y') {
            if (ans[x].name.equals("monster")) {
                Gan(ans, x, y);
            } else {
                if (ans[x].total > ans[y].total) {
                    ans[y].isDead = true;
                }
            }
        }
    }
    public static void Gan(Role[] ans,int x,int y){
        if(ans[x].total==ans[y].total){
            ans[x].isDead=true;
            ans[y].isDead=true;
        }else if(ans[x].total<ans[y].total){
            ans[x].isDead=true;
        }else{
            ans[y].isDead=true;
        }
    }

}
