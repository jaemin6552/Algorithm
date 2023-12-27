import java.util.*;
class Solution {
    static List<List<Integer>>grapes = new ArrayList<>();
    public int solution(int n, int[][] edge) {
        int answer = 0;
        for(int i =0; i<n; i++){
            grapes.add(new ArrayList<>());
        }
        for(int i =0; i<edge.length; i++){
            grapes.get(edge[i][0]-1).add(edge[i][1]-1);
            grapes.get(edge[i][1]-1).add(edge[i][0]-1);
            
        }
        int []visited = new int[n];
        Arrays.fill(visited,Integer.MAX_VALUE);
        return  bfs(visited,answer);
    }
    public int bfs(int []visited,int answer){
        Queue<Integer>current = new LinkedList<>();
        current.add(0);
        visited[0] = 0;
        int max = 0;
        while(!current.isEmpty()){
            int c = current.remove();
            for(int i =0; i<grapes.get(c).size(); i++){
                int next = grapes.get(c).get(i);
                if(visited[next] > visited[c]+1){
                    visited[next] = visited[c]+1;
                    current.add(next);
                    if(max < visited[next]) {
                        answer = 1;
                        max = visited[next];
                    }
                    else if (max == visited[next]) answer++;
                }
            }
        }
        return answer;
    }
}