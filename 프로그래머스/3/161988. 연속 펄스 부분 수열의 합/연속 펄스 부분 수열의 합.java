import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int length = sequence.length;
        long[] even_s = new long[length];
        long[] odd_s = new long[length];
        long[]dp = new long[2];
        for(int i =0; i<length; i++){
            even_s[i] = i % 2 == 0 ? sequence[i] : -sequence[i];
            odd_s[i] = i % 2 == 1 ? sequence[i] : -sequence[i];
        }
        
        for(int i =0; i<length; i++){
            dp[0] = Math.max(0,dp[0])+even_s[i];
            dp[1] = Math.max(0,dp[1])+odd_s[i];
            long tmp = Math.max(dp[0],dp[1]);
            answer = Math.max(answer,tmp);
        }
        return answer;
    }
}