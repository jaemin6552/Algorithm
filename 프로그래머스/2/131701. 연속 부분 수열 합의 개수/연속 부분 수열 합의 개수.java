import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int length = elements.length;
        int []dp = new int[length];
        HashSet<Integer>hashset = new HashSet<>();
        for(int i=1; i<=length; i++){
            for(int j=0; j<length; j++){
                dp[j] = elements[(j+i-1) % length]+dp[j];
                hashset.add(dp[j]);
            }
        }
        return hashset.size();
    }
}