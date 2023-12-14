import java.util.*;
class Solution {
    public int solution(int[][] dots) {
        
        double slope1 = 0;
        double slope2 = 0;
        Arrays.sort(dots,(a,b) -> Integer.compare(a[0],b[0]));
        slope1 = ((double)dots[1][1]-dots[0][1])/(dots[1][0]-dots[0][0]);
        slope2 = ((double)dots[3][1]-dots[2][1])/(dots[3][0]-dots[2][0]);
        
        return slope1 == slope2 ? 1 : 0;
    }
}