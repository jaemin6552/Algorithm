import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        int[] answer = new int[score.length];
        int idx = 0;
        for(int e : score){
            pq.add(e);
            if(pq.size() > k){
                pq.poll();
            }
            answer[idx++] = pq.peek();
        }
        return answer;
    }
}