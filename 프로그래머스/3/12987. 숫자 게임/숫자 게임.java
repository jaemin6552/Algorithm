import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> pq_a = new PriorityQueue<>();
        PriorityQueue<Integer> pq_b = new PriorityQueue<>();
        for(int e : A)pq_a.add(e);
        for(int e : B)pq_b.add(e);
        while(!pq_b.isEmpty()){
            int ca = pq_a.peek();
            int cb = pq_b.remove();
            if(cb > ca) {
                pq_a.remove();
                answer++;
            }
        }
        return answer;
    }
}