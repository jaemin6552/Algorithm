import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        char []ch = s.toCharArray();
        Arrays.sort(ch);
        for(int i = ch.length-1; i>=0; i--){
            answer.append(ch[i]);
        }
        return answer.toString();
    }
}