import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        int maxLength = t*m;
        int idx = 0;
        while(tmp.length() < maxLength){
            tmp.append(Integer.toString(idx++,n));
        }
        for(int i =p-1; i<maxLength; i+=m){
            answer.append(tmp.charAt(i));
        }
        return answer.toString().toUpperCase();
    }
}