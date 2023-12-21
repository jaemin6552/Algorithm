import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        for(int i =0; i<d.length; i++){
            budget-=d[i];
            if(budget < 0) return i;
            else if(budget == 0) return ++i;
            else answer = i+1;
        }
        return answer;
    }
}