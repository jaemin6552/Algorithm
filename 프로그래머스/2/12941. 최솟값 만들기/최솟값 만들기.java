import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        PriorityQueue<Integer>pqA = new PriorityQueue<>();
        PriorityQueue<Integer>pqB = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<A.length; i++){
            pqA.add(A[i]);
            pqB.add(B[i]);
        }
        while(!pqA.isEmpty()){
            answer+=pqA.poll()*pqB.poll();
        }

        return answer;
    }
}