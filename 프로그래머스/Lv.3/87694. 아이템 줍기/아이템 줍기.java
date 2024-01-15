import java.util.*;
class Solution {
    int []dX = {1,0,-1,0};
    int []dY = {0,1,0,-1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int startX = characterX * 2;
        int startY = characterY * 2;
        int endX = itemX * 2;
        int endY = itemY * 2;
        boolean [][]maps = new boolean[51*2][51*2];
        for(int [] path : rectangle){
            for(int i = path[1]*2; i<=path[3]*2; i++){
                for(int j = path[0]*2; j<=path[2]*2; j++){
                    maps[i][j] = true;
                }
            }
        }
        for(int [] path : rectangle){
            for(int i = path[1]*2+1; i<path[3]*2; i++){
                for(int j = path[0]*2+1; j<path[2]*2; j++){
                    maps[i][j] = false;
                }
            }
        }
        Stack<Node>stack = new Stack<>();
        stack.push(new Node(startX,startY));
        int cnt = 0;
        while(!stack.isEmpty()){
            Node current = stack.pop();
            if(current.x == endX && current.y == endY){
                answer = cnt/2; 
            }
            maps[current.y][current.x] = false;
            for(int i =0; i<4; i++){
                int nX = current.x+dX[i];
                int nY = current.y+dY[i];
                if(maps[nY][nX] == true){
                    stack.push(new Node(nX,nY));
                }
            }
            cnt++;
        }
        answer = Math.min(answer,(cnt/2)-answer);
        return answer;
    }
}
class Node{
    int x;
    int y;
    public Node(int x,int y){
        this.x = x;
        this.y = y;
    }
}