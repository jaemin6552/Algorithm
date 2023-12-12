import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        LinkedList<Integer>list = new LinkedList<>();
        int[] answer = new int[score.length];
        int idx = 0;
        for(int e : score){
            list.push(e);
            Collections.sort(list);
            if(list.size() == k+1){
                list.pop();
            }
            answer[idx++] = list.peek();
        }
        return answer;
    }
}