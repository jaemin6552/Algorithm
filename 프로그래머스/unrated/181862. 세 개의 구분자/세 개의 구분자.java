import java.util.*;
class Solution {
    public String[] solution(String myStr) {
        String[] tmp = myStr.split("a|b|c");
        List<String>answer = new ArrayList<>();
        for(String str : tmp){
            if(!str.isEmpty()) answer.add(str);
        }
        
        return answer.isEmpty() ? new String[] {"EMPTY"} : answer.toArray(new String[0]);
    }
}