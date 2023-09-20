package com.wut.learn.CodeExam.HuaWei;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/20/20:10
 * @Description:
 */
import java.util.*;
public class test22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] nums = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                nums[i][j] = in.nextInt();
            }
        }
        System.out.println(solution(nums));
    }
    public static int solution(int[][] nums){
        int m = nums.length;
        int n = nums[0].length;
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> queue = new ArrayDeque<>();
        int res = 0;
        for(int i=0;i<m;i++){
            if(nums[i][0]==1){
                queue.offer(new int[]{i,0});
                visited[i][0] = true;
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            res++;
            for(int i=0;i<size;i++){
                int[] head = queue.poll();
                int col = head[0];
                int row = head[1];
                if(col-1>=0 && nums[col-1][row]==1 && !visited[col-1][row]){
                    queue.offer(new int[]{col-1,row});
                    visited[col-1][row] = true;
                }
                if(col+1<m && nums[col+1][row]==1 && !visited[col+1][row]){
                    queue.offer(new int[]{col+1,row});
                    visited[col+1][row] = true;
                }
                if(row-1>=0 && nums[col][row-1]==1 && !visited[col][row-1]){
                    queue.offer(new int[]{col,row-1});
                    visited[col][row-1] = true;
                }
                if(row+1<n && nums[col][row+1]==1 && !visited[col][row+1]){
                    queue.offer(new int[]{col,row+1});
                    visited[col][row+1] = true;
                    if(row+1==n-1){
                        return res;
                    }
                }
            }
        }
        return -1;
    }
}
