import java.util.*;
class Solution {
    int []dx = {1,0,-1,0};
    int []dy = {0,1,0,-1};
    public int solution(String[] maps) {
        int answer = 0;
        int []start = new int[2];
        int []lever = new int[2];
        int []dest = new int[2];
        int [][]visited = new int[maps.length][maps[0].length()];
        for(int i =0; i<maps.length; i++){
            if(maps[i].contains("S")) {
                start[0] = maps[i].indexOf("S");
                start[1] = i;
            }
            if(maps[i].contains("L")){
                lever[0] = maps[i].indexOf("L");
                lever[1] = i;
            }
            if(maps[i].contains("E")){
                dest[0] = maps[i].indexOf("E");
                dest[1] = i;
            }
        }
        int toLever = bfs(visited,maps,start,lever);
        int toDest =  bfs(visited,maps,lever,dest);
        if(toLever == Integer.MAX_VALUE || toDest == Integer.MAX_VALUE) return -1;
        return  toLever+toDest;
    }
    public int bfs(int[][] visited,String[] maps,int []start,int []dest){
        for(int i =0; i<visited.length; i++){
            Arrays.fill(visited[i],Integer.MAX_VALUE);
        }
        Queue<int[]>current = new LinkedList<>();
        current.add(start);
        visited[start[1]][start[0]] = 0;
        while(!current.isEmpty()){
            int []c = current.remove();
            for(int i =0; i<4; i++){
                int ny = c[1] + dy[i];
                int nx = c[0] + dx[i];
                if(ny < 0 || nx < 0 || ny>maps.length-1 || nx>maps[ny].length()-1)
                    continue;
                if(visited[ny][nx]>visited[c[1]][c[0]]+1&&maps[ny].charAt(nx) != 'X'){
                    visited[ny][nx]=visited[c[1]][c[0]]+1;
                    current.add(new int[]{nx,ny});
                }
            }
        }
        return visited[dest[1]][dest[0]];
    }
}
