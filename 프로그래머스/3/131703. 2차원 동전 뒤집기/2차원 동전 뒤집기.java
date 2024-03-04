class Solution {
    public int[][] board;
    public int[][] t;
    public int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] beginning, int[][] target) {
        board = beginning;
        t = target;
        dfs(0,0);
        if(answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }
    public void flipRow(int r){
        for(int i =0; i<board[0].length; i++){
            board[r][i] = board[r][i] == 0 ? 1 : 0;
        }
    }
    public int checkCol(int c){
        int check = 0;
        for(int i =0; i<board.length; i++){
            if(board[i][c] == t[i][c]) check++;
        }
        if(check == board.length) return 0;
        else if(check == 0) return 1;
        else return -1;
    }
    public void dfs(int r,int cnt){
        boolean flag = true;
        if(r == board.length){
            for(int i = 0; i<board[0].length; i++){
                if(checkCol(i) == -1){
                    flag = false;
                    break;
                }
                cnt+=checkCol(i);
            }
            if(flag) answer = Math.min(answer,cnt);
            return;
        }
        flipRow(r);
        dfs(r+1,cnt+1);
        flipRow(r);
        dfs(r+1,cnt);
    }
}