import java.util.*;
class Solution {
    static final int MAX_VALUE = 1000000;
    public int solution(int n, int[][] results) {
        int answer = 0;
        int [][]grapes = new int[n][n];
        for(int i =0; i<n; i++){
            for(int j =0; j<n; j++){
                if(i == j) continue;
                grapes[i][j] = MAX_VALUE;
            }
        }
        for(int[] result : results){
            grapes[result[0]-1][result[1]-1] = 1;
            grapes[result[1]-1][result[0]-1] = -1;
        }
        for(int i = 0; i<n; i++){
            for(int j =0; j<n; j++){
                for(int k =0; k<n; k++){
                    if(grapes[j][i] == 1 && grapes[i][k] == 1){
                        grapes[j][k] = 1;
                    }else if(grapes[j][i] == -1 && grapes[i][k] == -1){
                        grapes[j][k] = -1;
                    }
                }
            }
        }
        for(int []grape : grapes){
            boolean isRank = true;
            for(int e : grape){
                if(e == MAX_VALUE){
                    isRank = false;
                    break;
                }
            }
            if(isRank) answer++;
        }
        return answer;
    }
}