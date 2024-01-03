import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer>current = new LinkedList<>();
        List<Integer>answer = new ArrayList<>();
        for(int i = 0; i<progresses.length; i++){
            int workday = (int)Math.ceil((100-progresses[i]) / (double)speeds[i]);
            current.add(workday);
        }
        System.out.println(current);
        int cnt = 1;
        int prev = current.poll();
        
        while(!current.isEmpty()){
            int cur = current.poll();
            if(prev >= cur) cnt++;
            else{
                prev = cur;
                answer.add(cnt);
                cnt = 1;
            }
        }
        answer.add(cnt); 
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}