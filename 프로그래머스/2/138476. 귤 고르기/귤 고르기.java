import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer,Integer>map = new HashMap<>();
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int e : tangerine){
            int cnt = map.getOrDefault(e,0)+1;
            map.put(e,cnt);
        }
        for(Integer key : map.keySet()){
            pq.add(map.get(key));
        }
        while(k > 0){
            k -= pq.remove();
            answer++;
        }
        return answer;
    }
}