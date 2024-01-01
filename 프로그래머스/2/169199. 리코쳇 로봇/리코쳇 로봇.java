import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
class Solution {
    public int solution(String[] board) {
        int []start = new int[2];
        int []dest = new int[2];
        int[][] visited = new int[board.length][board[0].length()];
        for(int i =0; i<visited.length; i++){
            Arrays.fill(visited[i],Integer.MAX_VALUE);
        }
        for(int i =0; i<board.length; i++){
            if(board[i].contains("R")){
                start[0] = board[i].indexOf("R");
                start[1] = i;
            }
             if(board[i].contains("G")){
                dest[0] = board[i].indexOf("G");
                dest[1] = i;
            }
        }
        bfs(start[0],start[1],board,visited);
        return visited[dest[1]][dest[0]] == Integer.MAX_VALUE ? -1 : visited[dest[1]][dest[0]];
    }
    public void bfs(int x,int y,String[] board,int [][]visited){
        visited[y][x] = 0;
        Queue<int[]>current = new LinkedList<>();
        current.add(new int[]{x,y});
        while(!current.isEmpty()){
            int []c = current.remove();
            int cX = c[0];
            int cY = c[1];
            for(int i =0; i<4; i++){ //0.상 1.하 2.좌 3.우
                int []next = movePosition(i,cX,cY,board);
                int nX = next[0];
                int nY = next[1];
                if(visited[nY][nX] > visited[cY][cX]+1){
                    visited[nY][nX] = visited[cY][cX]+1;
                    current.add(new int[]{nX,nY});
                }
            }
        }
    }
    public int []movePosition(int dir,int x,int y,String[] board){
        switch(dir){
            case 0: //상
                while(y > 0){
                    y--;
                    if(board[y].charAt(x) == 'D'){
                        y++;
                        break;
                    }
                }
                break;
            case 1: //하
                 while(y < board.length-1){
                    y++;
                    if(board[y].charAt(x) == 'D'){
                        y--;
                        break;
                    }
                }
                break;
            case 2: //좌
              while(x > 0){
                    x--;
                    if(board[y].charAt(x) == 'D'){
                        x++;
                        break;
                    }
                }
                break;
            case 3: //우
                while(x < board[y].length()-1){
                    x++;
                    if(board[y].charAt(x) == 'D'){
                        x--;
                        break;
                    }
                }
                break;
        }  
        return new int[]{x,y};
    } 
    
}