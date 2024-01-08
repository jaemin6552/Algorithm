import java.util.*;

class Solution {
    int[] inputCnt = new int[1000000];
    int[] outputCnt = new int[1000000];

    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int max = 0;
        for(int[] edge : edges){
            max = Math.max(max,Math.max(edge[0],edge[1]));
            inputCnt[edge[1]]++;
            outputCnt[edge[0]]++;
        }
        for(int i =1; i<=max; i++){
            if(outputCnt[i] == 0) answer[2]++;
            else if(outputCnt[i] == 2 && inputCnt[i] >= 2) answer[3]++;
            else if(outputCnt[i] >= 2 && inputCnt[i] == 0) answer[0] = i;
        }
        answer[1] = outputCnt[answer[0]] - (answer[2]+answer[3]);
        return answer;
    }
}