class Solution {
    int n,m;
    int answer;
    int[][] board;
    int[][] t;
    public int solution(int[][] beginning, int[][] target) {
        answer = Integer.MAX_VALUE;
        n = beginning.length;
        m = beginning[0].length;
        t = target;
        board = beginning;
        dfs(0,0);
        if(answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }
    public void flipRow(int r){
        for(int i =0; i<m; i++){
            board[r][i] = board[r][i] == 0 ? 1 : 0;
        }
    }
    public int checkCol(int c){
        int check = 0;
        for(int i =0; i<n; i++){
            if(board[i][c] == t[i][c]) check++;
        }
        if(check == n) return 0;
        else if(check == 0) return 1;
        else return -1;
    }
    public void dfs(int r,int cnt){
        boolean flag = true;
        if(r == n){
            for(int i = 0; i<m; i++){
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