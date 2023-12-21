import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int move = length-1;
    
        for(int i =0; i<name.length(); i++){
            answer += name.charAt(i) <= 'N' ? name.charAt(i) - 'A' : 'Z' - name.charAt(i)+1;
            int index = i+1;
            while(index < length && name.charAt(index) == 'A'){
                index++;
            }
            move = Math.min(i*2+length-index,move);
            move = Math.min((length-index)*2+i,move);
        }
        
       
        return answer+move;
    }
}