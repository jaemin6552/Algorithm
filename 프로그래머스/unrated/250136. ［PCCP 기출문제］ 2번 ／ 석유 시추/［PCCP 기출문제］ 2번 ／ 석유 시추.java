import java.util.*;
class Solution {
    int []dy = {1,0,-1,0};
    int []dx = {0,1,0,-1};
    public int solution(int[][] land) {
        int answer = 0;
        boolean [][]visited = new boolean[land.length][land[0].length];
        int []oils = new int[land[0].length];
        for(int i =0; i<land.length; i++){
            for(int j =0; j<land[i].length; j++){
                if(land[i][j] == 1 && visited[i][j] == false){
                    getOilAmount(land,visited,oils,j,i);
                } else visited[i][j] = true;
            }
        }
        for(int j=0; j<land[0].length; j++){
        answer = Math.max(oils[j],answer);
        }
        return answer;
    }
    public void getOilAmount(int[][]land,boolean [][]visited,int[] oils,int x,int y){
        Queue<int[]>current = new LinkedList<>();
        current.add(new int[]{x,y});
        int startX = x;
        int endX = x;
        int oil = 0;
        visited[y][x] = true;
        while(!current.isEmpty()){
            int[] c = current.remove();
            int cy = c[1];
            int cx = c[0];
            oil++;
            startX = Math.min(startX,cx);
            endX = Math.max(endX,cx);
            
            for(int i=0; i<4; i++){
                int ny = cy+dy[i]; 
                int nx = cx+dx[i]; 
                if(ny<0 || ny>land.length-1 || nx<0 || nx>land[0].length-1) continue;
                if(land[ny][nx] ==1 && visited[ny][nx] == false){
                    visited[ny][nx] = true;
                    current.add(new int[]{nx,ny});
                }
            }
        }
        for(int i=startX; i<=endX; i++){
            oils[i] += oil;
        }
    }
}