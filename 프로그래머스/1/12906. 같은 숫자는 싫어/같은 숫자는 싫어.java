import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer>stack = new Stack<>();
        for(int e : arr){
            if(!stack.isEmpty() && stack.peek() == e)continue;
            stack.push(e);
        }
        
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}