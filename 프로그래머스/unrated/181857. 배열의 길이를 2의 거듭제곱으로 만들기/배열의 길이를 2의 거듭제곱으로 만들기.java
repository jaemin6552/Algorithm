import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = arr;
        for(int i = 2; i<=1024; i*=2){
            if(arr.length < i && arr.length != 1){
                answer = Arrays.copyOf(arr,i);
                break;
            }   else if(arr.length == i) break;
                
        }
        return answer;
    }
}