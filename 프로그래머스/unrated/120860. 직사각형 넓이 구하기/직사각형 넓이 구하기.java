import java.util.*;
class Solution {
    public int solution(int[][] dots) {
        int x = 0;
        int y = 0;
        Arrays.sort(dots,(o1,o2)->{return o1[0]-o2[0];});
        x = Math.abs(dots[0][1]-dots[1][1]);
        y = Math.abs(dots[2][0]-dots[0][0]);
        return x*y;
    }
}