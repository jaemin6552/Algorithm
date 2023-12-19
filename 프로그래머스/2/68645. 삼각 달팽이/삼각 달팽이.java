import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[][] answer = new int[n][];
        for(int i =0; i<n; i++){
            answer[i] = new int[i+1];
        }
        
        int length = (n * (n+1)) / 2;
        int [][]dir = {{0,1},{1,0},{-1,-1}};
        int num =1;
        int x = 0;
        int y = 0;
        int direction = 0;
        answer[y][x] = num;
        
         while (num < length) {
            int nx = x + dir[direction][0];
            int ny = y + dir[direction][1];

            if (ny<0||ny>n-1||nx<0||answer[ny] == null
                ||nx>=answer[ny].length||answer[ny][nx] != 0) {
                direction = (direction + 1) % 3;
            } else {
                x = nx;
                y = ny;
                answer[ny][nx] = ++num;
            }
        }
        return Arrays.stream(answer)
                     .flatMapToInt(row -> Arrays.stream(row))
                     .toArray();
    }
  
}