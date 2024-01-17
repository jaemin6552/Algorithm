import java.util.*;
class Solution {
    boolean [][]visited;
    int []dx = {1,0,-1,0};
    int []dy = {0,1,0,-1};
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[picture.length][picture[0].length];
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea,bfs(j,i,picture,picture[i][j]));
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public int bfs(int x,int y,int[][]picture,int target){
        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[y][x] = true;
        int cnt = 1;
        while(!queue.isEmpty()){
            int [] current = queue.remove();
            int cx = current[0];
            int cy = current[1];
            for(int i =0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(ny < 0 || ny > picture.length-1 || nx < 0 || nx > picture[0].length-1) continue;
                if(!visited[ny][nx] && picture[ny][nx] == target){
                    visited[ny][nx] = true;
                    cnt++;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
        return cnt;
    }
}