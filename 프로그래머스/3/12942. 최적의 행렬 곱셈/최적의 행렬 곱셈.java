import java.util.*;
class Solution {
    int answer;
    boolean []visited;
    public int solution(int[][] matrix_sizes) {
        answer = 0;
        int size = matrix_sizes.length;
        int [][]dp = new int[size][size];
        for(int []e : dp) Arrays.fill(e,Integer.MAX_VALUE);
        for(int i =0; i<dp.length; i++)dp[i][i] = 0;
        
        for(int i = 0; i<size; i++){
            for(int j=0; j<size-i; j++){
                int a = j;
                int b = j + i;
                for(int k = a; k<b; k++){
                    dp[a][b] = Math.min(dp[a][b],dp[a][k]+dp[k+1][b]+
                        matrix_sizes[a][0]*matrix_sizes[k][1]*matrix_sizes[b][1]);
                }
            }
        }
        return dp[0][size-1];
    }
    
}