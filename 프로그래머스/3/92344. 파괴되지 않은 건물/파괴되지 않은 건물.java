class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int [][]prefix = new int[board.length+1][board[0].length+1];
        for (int[] row : skill) {
            int val1 = (row[0] == 1) ? -row[5] : row[5];
            int val2 = -val1;
            prefix[row[1]][row[2]] += val1;
            prefix[row[1]][row[4] + 1] += val2;
            prefix[row[3] + 1][row[2]] += val2;
            prefix[row[3] + 1][row[4] + 1] += val1;
        }
        for(int y =1; y<prefix.length; y++){
            for(int x =0; x<prefix[0].length; x++){
                prefix[y][x] += prefix[y-1][x]; 
            }
        }
        for(int x =1; x<prefix[0].length; x++){
            for(int y =0; y<prefix.length; y++){
                prefix[y][x] += prefix[y][x-1];
            }
        }
        for(int y =0; y<board.length; y++){
            for(int x =0; x<board[0].length; x++){
                if(board[y][x]+prefix[y][x] > 0 ) answer++;
            }
        }
        return answer;
    }
}