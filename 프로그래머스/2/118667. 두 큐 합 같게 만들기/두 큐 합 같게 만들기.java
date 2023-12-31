import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer>que1= new LinkedList<>();
        Queue<Integer>que2= new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        for(int i =0; i<queue1.length; i++){
            que1.add(queue1[i]);
            que2.add(queue2[i]);
            sum1+=(long)queue1[i];
            sum2+=(long)queue2[i];
        }
        long target = (sum1+sum2)/2;
        if(target*2 != sum1+sum2) return -1;
        while(sum1 != target && sum2 != target){
            answer++;
            if(sum1 > sum2){
                int tmp = que1.remove();
                que2.add(tmp);
                sum1-=tmp;
                sum2+=tmp;
            }else if(sum2 > sum1){
                int tmp = que2.remove();
                que1.add(tmp);
                sum1+=tmp;
                sum2-=tmp;
            }
            if(answer > (que1.size()+que2.size())*2) return -1;
        }
        return answer;
    }
}