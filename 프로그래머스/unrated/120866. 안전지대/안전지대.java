class Solution {
        int[]dy={-1,-1,-1,0,0,1,1,1};
        int[]dx={-1,0,1,-1,1,-1,0,1};
 public  int solution(int[][] board) {
        boolean [][]visited = new boolean[board.length][board.length];
        int answer = board.length * board.length;
     
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                if(board[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
                    answer--;
                    for(int k =0; k<8; k++){
                        int ny = i+dy[k];
                        int nx = j+dx[k];
                        if(ny < 0 || ny > board.length-1 || nx < 0 || nx > board.length-1) continue;
                        if(!visited[ny][nx] && board[ny][nx] != 1){
                            visited[ny][nx] = true;
                            answer--;
                        }
                    }
                }
            }
        }
       
        return answer;
    }
    
 
}
