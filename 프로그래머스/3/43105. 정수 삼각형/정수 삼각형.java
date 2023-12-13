import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        for(int i =1; i<triangle.length; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(j ==0) triangle[i][j] += triangle[i-1][j];
                else if(j == triangle[i-1].length){
                    triangle[i][j] += triangle[i-1][j-1];
                }
                else{
                    triangle[i][j] += Math.max(triangle[i-1][j],triangle[i-1][j-1]);
                }
            }
        }
        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }
}
//아래로 가면서 계산 계산했는데 이전 높이에서 계산한값보다 낮으면 가지치기