import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes,Comparator.comparingInt(a->a[1]));
        int end = routes[0][1];
        for(int i =1; i<routes.length; i++){
            if(routes[i][0] <= end){
                continue;
            }else{
                answer++;
                end = routes[i][1];
            }
        }
        return answer;
    }
}