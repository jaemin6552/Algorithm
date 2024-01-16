class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][]maps = new int[rows][columns];
        for(int i =0; i<rows; i++){
            for(int j =0; j<columns; j++) maps[i][j] = columns*i+(j+1);
        }
        int idx = 0;
        for(int[] querry : queries){
            answer[idx++] = rotate(querry,maps);
        }
        return answer;
    } 
    public int rotate(int[]querry,int[][]maps){
        int r1 = querry[0]-1;
        int r2 = querry[2]-1;
        int c1 = querry[1]-1;
        int c2 = querry[3]-1;
        int tmp = maps[r1][c1];
        int min = tmp;
        for(int i =r1; i<r2; i++){
            maps[i][c1]= maps[i+1][c1];
            min = Math.min(min,maps[i][c1]);
        }
        for(int i = c1; i<c2; i++){
            maps[r2][i] = maps[r2][i+1];
            min = Math.min(min,maps[r2][i]);
        }
        for(int i = r2; i>r1; i--){
            maps[i][c2] = maps[i-1][c2];
            min = Math.min(min,maps[i][c2]);
        }
        for(int i = c2; i>c1; i--){
            maps[r1][i] = maps[r1][i-1];
            min = Math.min(min,maps[r1][i]);
        }
        maps[r1][c1+1] = tmp;
        return min;
    }

}