import java.util.*;
class Solution {
    public int solution(int[][] matrix_sizes) {
        int answer = 0;
        int m_size = matrix_sizes.length;
        int [][]dp = new int[m_size][m_size];
        for(int [] tmp : dp) Arrays.fill(tmp,Integer.MAX_VALUE);
        for(int i =0; i<dp.length; i++) dp[i][i] = 0;
        
        for(int i =0; i<m_size; i++){
            for(int j =0; j<m_size-i; j++){
                int a = j;
                int b = j+i;
                for(int k=a;k<b;k++){
                    dp[a][b]=Math.min(dp[a][b],dp[a][k]+dp[k+1][b]
                                      +matrix_sizes[a][0]*matrix_sizes[k][1]*matrix_sizes[b][1]);
                }
            }
        }
        return dp[0][m_size-1];
    }
}