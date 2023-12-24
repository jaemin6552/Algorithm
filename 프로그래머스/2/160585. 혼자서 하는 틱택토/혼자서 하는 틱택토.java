class Solution {
    static boolean oBingo;
    static boolean xBingo;
    
    public int solution(String[] board) {
        int oCnt = 0;
        int xCnt = 0;
        for(int i =0; i<3; i++){
            for(int j =0; j<3; j++){
                if(board[i].charAt(j) == 'O') oCnt++;
                else if(board[i].charAt(j) == 'X') xCnt++;
            }
        }
        if(oCnt-xCnt > 1 || oCnt-xCnt < 0) return 0;
        checkBingo(board);
        if(oBingo && xBingo) return 0;
        else if(oBingo){
            if(oCnt - xCnt != 1) return 0;
        } else if(xBingo){
            if(oCnt - xCnt != 0) return 0;
        }
        return 1;
    }
    public void checkBingo(String[] board){  
        for(int i =0; i<3; i++){ //가로
            if(board[i].equals("OOO") || board[i].equals("XXX")){
                if(board[i].equals("OOO")) oBingo = true;
                else if(board[i].equals("XXX")) xBingo = true;
            }
            for(int j =0; j<3; j++){//세로
                if(board[0].charAt(j) == board[1].charAt(j) && board[0].charAt(j) == board[2].charAt(j)){
                    if(board[0].charAt(j) == 'O') oBingo = true;
                    else if(board[0].charAt(j) == 'X') xBingo = true;
                }
            }
        }
        if((board[0].charAt(0) == board[1].charAt(1) && board[0].charAt(0) == board[2].charAt(2)) || 
          board[0].charAt(2) == board[1].charAt(1) && board[0].charAt(2) == board[2].charAt(0)){
                    if(board[1].charAt(1) == 'O') oBingo = true;
                     else if (board[1].charAt(1) == 'X') xBingo = true;
        }
    }
}