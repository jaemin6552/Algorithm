import java.util.*;
class Solution {
   public long solution(int r1, int r2) {
    long answer = 0;
       
    // x-0의 제곱 + y-0의 제곱이 r1보다 크거나 같고 r2보다 작거나 같게 만들면 됨
    for(int x = 1; x<=r2; x++){
       double maxY = Math.sqrt(Math.pow(r2,2)-Math.pow(x,2));
       double minY = Math.sqrt(Math.pow(r1,2)-Math.pow(x,2));
       answer += (long)maxY - (long)Math.ceil(minY) +1; 
    }

    

    return answer*4;
    }
}