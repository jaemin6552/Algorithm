import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int e : works) pq.add(e);
        while(n > 0 && !pq.isEmpty()){
            int tmp = pq.remove()-1;
            n--;
            if(tmp ==0) continue;
            pq.add(tmp);
        }
        while(!pq.isEmpty()){
            int tmp = pq.remove();
            answer+=Math.pow(tmp,2);
        }
        return answer;
    }
}