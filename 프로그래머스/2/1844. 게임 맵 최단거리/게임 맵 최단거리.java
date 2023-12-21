import java.util.*;
class Solution {
    int []dy = {1,0,-1,0};
    int []dx = {0,-1,0,1};
    public int solution(int[][] maps) {
        int[][]visited = new int[maps.length][maps[0].length];
        bfs(maps,visited);
        int answer = visited[maps.length-1][maps[0].length-1];
        return answer == 0 ? -1 : answer;
    }
    public void bfs(int[][]maps,int[][]visited){
        visited[0][0] = 1;
        Queue<int[]>current = new LinkedList<>();
        current.add(new int[]{0,0});
        
        while(!current.isEmpty()){
            int[] c = current.remove();
            int cy = c[0];
            int cx = c[1];
            
            for(int i =0; i<4; i++){
                int ny = cy+dy[i];
                int nx = cx+dx[i];
                
                if(ny<0 || ny>maps.length-1 || nx<0 ||nx>maps[0].length-1) continue;
                
                if(maps[ny][nx] == 1 && visited[ny][nx] == 0){
                    current.add(new int[]{ny,nx});
                    visited[ny][nx] = visited[cy][cx]+1;
                }
            }
        }
    }
}