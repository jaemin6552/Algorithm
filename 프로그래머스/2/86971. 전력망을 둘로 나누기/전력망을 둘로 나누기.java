import java.util.*;
class Solution {
    static List<List<Integer>>grapes = new ArrayList<>();
    public int solution(int n, int[][] wires) {
        boolean []visited = new boolean[n+1];
        int answer = Integer.MAX_VALUE;
        for(int i =0; i<=n; i++){
            grapes.add(new ArrayList<>());
        }
        for(int i =0; i<n-1; i++){
            grapes.get(wires[i][0]).add(wires[i][1]);
            grapes.get(wires[i][1]).add(wires[i][0]);     
        }
        for(int [] wire : wires){
        boolean[] visitClone = Arrays.copyOf(visited, visited.length);
        int length1 = dfs(wire[0],visitClone,wire[1]);
        int length2 = dfs(wire[1],visitClone,wire[0]);
        answer = Math.min(answer,Math.abs(length1-length2));
        }
       
        
        return answer;
    }
    public int dfs(int start,boolean []visited,int target){
       visited[start] = true;
       int maxChild = 0;
       for(Integer next : grapes.get(start)){
           if(!visited[next] && next != target){
               maxChild+=dfs(next,visited,target)+1;
           }
       } 
        return maxChild;
    }
}