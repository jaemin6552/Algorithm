import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int e : B){
            pq.add(e);
        }
        for(int e : A){
            answer+=e*pq.poll();
        }

        return answer;
    }
}