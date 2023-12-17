class Solution {
    int []dy = {1,0,-1,0};
    int []dx = {0,1,0,-1};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        for(int i =0; i<4; i++){
            int ny = h+dy[i];
            int nx = w+dx[i];
            if(ny <0 || ny > board.length-1 || nx < 0 || nx > board[0].length-1) continue;
            if(board[ny][nx].equals(board[h][w])) answer++;
        }
        return answer;
    }
}