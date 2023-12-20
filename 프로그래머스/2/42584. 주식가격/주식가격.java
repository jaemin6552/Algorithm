import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]>stack = new Stack<>();
        for(int i =0; i<prices.length; i++){
            while(!stack.isEmpty() && stack.peek()[0] > prices[i]){
                answer[stack.peek()[1]] = i-stack.peek()[1];
                stack.pop(); 
            }
            stack.push(new int[]{prices[i],i});
        }
        for(int i=1; i<answer.length; i++){
            if(answer[i-1] == 0) answer[i-1] = prices.length-i;
        }
        return answer;
    }
}