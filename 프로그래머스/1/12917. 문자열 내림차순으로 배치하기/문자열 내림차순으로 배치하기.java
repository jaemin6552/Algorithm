import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        char []ch = s.toCharArray();
        Arrays.sort(ch);
        answer.append(ch);
        return answer.reverse().toString();
    }
}