import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, ((x, y) -> x[1] - y[1]));
        int start = 0;
        for(int[] target : targets){
           if(start<=target[0]){
               start = target[1];
               answer++;
           }
            
        }
    
        return answer;
    }
}