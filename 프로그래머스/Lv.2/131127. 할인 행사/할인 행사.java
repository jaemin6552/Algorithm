import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int i =0; i<discount.length-9; i++){
            int[] numClone = new int[number.length];
            boolean flag = true;
            for(int j = i; j<i+10; j++){
                for(int k = 0; k<want.length; k++){
                    if(discount[j].equals(want[k])) numClone[k]++; 
                }    
            }
            for(int j = 0; j<number.length; j++){
                if(numClone[j] < number[j]){
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
}