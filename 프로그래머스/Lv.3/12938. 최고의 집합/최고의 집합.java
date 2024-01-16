import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int []answer = new int[n];
        int idx = 0;
        while(s>0){
            int tmp = s/n;
            if(tmp == 0) return new int[]{-1};
            answer[idx++]= tmp;
            s-=tmp;
            n-=1;
        }
        return answer;
    }
}