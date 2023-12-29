import java.util.*;
class Solution {
    public int solution(int storey) {
        int answer = 0;
        int []arr = new int[Integer.toString(storey).length()+1];
        int idx = 0;
        while(storey > 0){
            arr[idx++] = storey % 10;
            storey/=10;
        }
        for(int i =0; i<arr.length-1; i++){
            if(arr[i] == 10) {
                arr[i+1]++;
                continue;
            }
            if(arr[i] <= 4) answer+=arr[i];
            else if(arr[i] == 5 && arr[i+1]>4){
                answer+=5;
                arr[i+1]++;
            } else if(arr[i] == 5 && arr[i+1] < 5){
                answer+=5;
            } else {
                answer+=10-arr[i];
                arr[i+1]++;
            }
        }
        if(arr[arr.length-1] != 0) answer++;
        return answer;
    }
    
}