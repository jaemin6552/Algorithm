import java.util.*;
class Solution {
    int []dX = {1,0,-1,0};
    int []dY = {0,1,0,-1};
    public int[] solution(String[] maps) {
        List<Integer>answer = new ArrayList<>();
        boolean [][]visited = new boolean[maps.length][maps[0].length()];
        for(int i =0; i<maps.length; i++){
            for(int j =0; j<maps[i].length(); j++){
                if(!visited[i][j] && maps[i].charAt(j) != 'X'){
                    answer.add(bfs(maps,visited,new int[]{j,i}));
                }
            }
        }
        Collections.sort(answer);
        if(answer.isEmpty()) return new int[]{-1};
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    public int bfs(String[] maps,boolean [][]visited,int []start){
        Queue<int[]>current = new LinkedList<>();
        current.add(new int[]{start[0],start[1]});
        visited[start[1]][start[0]] = true;
        int size = maps[start[1]].charAt(start[0])-'0';
        while(!current.isEmpty()){
            int []c = current.remove();
            int cX = c[0];
            int cY = c[1];
            for(int i =0; i<4; i++){
                int nX = cX+dX[i];
                int nY = cY+dY[i];
                if(nX < 0 || nY < 0 || nX > maps[0].length()-1 || nY > maps.length-1)continue;
                if(!visited[nY][nX] && maps[nY].charAt(nX) != 'X'){
                    visited[nY][nX] = true;
                    size+=maps[nY].charAt(nX)-'0';
                    current.add(new int[]{nX,nY});
                }
            }
        }
        return size;
    }
}