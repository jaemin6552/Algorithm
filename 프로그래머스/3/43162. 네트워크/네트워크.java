import java.util.*;
class Solution {
    static List<List<Integer>>grapes = new ArrayList<>();
    static int [] visited;
    public int solution(int n, int[][] computers) {
        visited = new int[n];
        int groupNumber = 0;
        for(int i =0; i<computers.length; i++){
            grapes.add(new ArrayList<>());
        }
        for(int i =0; i<computers.length; i++){
            for(int j =0; j<computers[i].length; j++){
                if(computers[i][j] == 1 && i != j){
                    grapes.get(i).add(j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                findAll(i,n,++groupNumber);
            }
        }
      
        return groupNumber;
    }
    public void findAll(int start,int n,int groupNumber){
        visited[start] = groupNumber;
       for (int nextIdx : grapes.get(start)) {
            if (visited[nextIdx] == 0) {
                findAll(nextIdx, n, groupNumber);
            }
        }
    }
}