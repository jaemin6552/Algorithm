import java.util.*;
class Solution {
    boolean [][]visitedT;
    boolean [][]visitedG;
    int []dx = {1,0,-1,0};
    int []dy = {0,1,0,-1};
    final int BOARD = 0;
    final int TABLE = 1;
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        visitedG = new boolean[table.length][table[0].length];
        visitedT = new boolean[table.length][table[0].length];
        List<List<int[]>>game_puzzle = new ArrayList<>();
        List<List<int[]>>table_puzzle = new ArrayList<>();
        for(int i = 0; i<game_board.length; i++){
            for(int j =0; j<game_board.length; j++){
                if(game_board[i][j] == 0 && !visitedG[i][j]){
                    List<int[]>gPuzzle = (bfs(new int[]{j,i},game_board,BOARD,visitedG));
                    game_puzzle.add(gPuzzle);
                }
                if(table[i][j] == 1 && !visitedT[i][j]){
                    List<int[]>tPuzzle = (bfs(new int[]{j,i},table,TABLE,visitedT));
                    table_puzzle.add(tPuzzle);
                }
            }
        }
        for(List<int[]> t_puzzle : table_puzzle){
            for(int i =0; i<4; i++){
                rotation(t_puzzle);
                int tmp = comparingPuzzle(game_puzzle,t_puzzle);
                if(tmp > 0){
                    answer+=tmp;
                    break;
                }
            }

        }
        return answer;
    }
    public List<int[]> bfs(int []xy,int[][] table,int type,boolean [][]visited){
        List<int[]>list = new ArrayList<>();
        Queue<int[]>queue = new LinkedList<>();
        visited[xy[1]][xy[0]] = true;
        list.add(xy);
        queue.add(xy);
        int minX = xy[0];
        int minY = xy[1];
        while(!queue.isEmpty()){
            int []current = queue.remove();
            for(int i =0; i<4; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if(ny < 0 || ny > table.length-1 || nx < 0 || nx > table[0].length-1)
                    continue;
                if(!visited[ny][nx] && table[ny][nx] == type){
                    list.add(new int[]{nx,ny});
                    visited[ny][nx] = true;
                    queue.add(new int[]{nx,ny});
                    minX = Math.min(minX,nx);
                    minY = Math.min(minY,ny);
                }
            }
        }
        list.sort(Comparator.comparingInt((int[] arr)->arr[0]).thenComparingInt(arr->arr[1]));
        for (int[] tmp : list) {
            tmp[0] -= minX;
            tmp[1] -= minY;
        }
        return list;
    }
    public int comparingPuzzle(List<List<int[]>>game_puzzle, List<int[]> t_puzzle){
        for(int i =0; i<game_puzzle.size(); i++){
            List<int[]>g_puzzle = game_puzzle.get(i);
            boolean flag = true;
            if(g_puzzle.size() != t_puzzle.size()) continue;
            for(int j = 0; j<g_puzzle.size(); j++){
                int [] g_tmp = g_puzzle.get(j);
                int [] t_tmp = t_puzzle.get(j);
                if(g_tmp[0] != t_tmp[0] || g_tmp[1] != t_tmp[1]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                int size = g_puzzle.size();
                game_puzzle.remove(i);
                return size;
            }
        }
        return 0;
    }
    public void rotation(List<int[]> list){
        int length = 0;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for(int[] tmp : list){
            length = Math.max(length,Math.max(tmp[0],tmp[1]));
        }
        for(int[] arr : list){
            int tmp = arr[0];
            arr[0] = length-arr[1];
            arr[1] = tmp;
            minX = Math.min(minX,arr[0]);
            minY = Math.min(minY,arr[1]);
        }
        for (int[] tmp : list) {
            tmp[0] -= minX;
            tmp[1] -= minY;
        }
        list.sort(Comparator.comparingInt((int[] arr)->arr[0]).thenComparingInt(arr->arr[1]));
    }
}