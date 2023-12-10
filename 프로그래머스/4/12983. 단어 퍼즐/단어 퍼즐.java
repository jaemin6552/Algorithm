import java.util.Arrays;       
class Solution {
            public int solution(String[] strs, String t) {
                int n = t.length();
                int []dp = new int[20000];
                Arrays.fill(dp,Integer.MAX_VALUE/2);
                for(int i = 0; i<n; i++){
                    String current = t.substring(0,i+1);
                    for (String str : strs) {
                        if (current.endsWith(str)) {
                            int diff = current.length() - str.length();
                           
                                if(diff == 0) dp[i] = 1;
                                else if(diff >0)dp[i] = Math.min(dp[i],dp[diff-1]+1);
                            
                        }
                    }
                }


                return dp[n-1] >= Integer.MAX_VALUE/2 ? -1 : dp[n-1];
            }
        }