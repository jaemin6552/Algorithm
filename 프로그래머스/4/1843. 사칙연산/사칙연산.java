import java.util.*;
class Solution {
    public int solution(String arr[]) {
        int answer = -1;
        int size = arr.length-arr.length/2;
        int [][]max_dp = new int[size][size];
        for(int[]max : max_dp) Arrays.fill(max,-Integer.MAX_VALUE);
        int [][]min_dp = new int[size][size];
        for(int[]min : min_dp) Arrays.fill(min,Integer.MAX_VALUE);
        
        for(int i =0; i<size; i++){
            for(int j =0; j<size-i; j++){
                int a = j+i;
                if(i == 0){
                    max_dp[j][j] = Integer.parseInt(arr[j*2]);
                    min_dp[j][j] = Integer.parseInt(arr[j*2]);
                }else {
                    for(int k = j; k < a; k++){
                        if(arr[(k*2)+1].equals("+")){
                            max_dp[j][a] = Math.max(max_dp[j][a],max_dp[j][k]+max_dp[k+1][a]);
                            min_dp[j][a] = Math.min(min_dp[j][a],min_dp[j][k]+min_dp[k+1][a]);
                        } else {
                            max_dp[j][a] = Math.max(max_dp[j][a],max_dp[j][k]-min_dp[k+1][a]);
                            min_dp[j][a] = Math.min(min_dp[j][a],min_dp[j][k]-max_dp[k+1][a]);
                        }
                    }
                }
            }
        }
        return max_dp[0][size-1];
        
    }
}