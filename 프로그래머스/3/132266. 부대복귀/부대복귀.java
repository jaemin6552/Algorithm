import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int [sources.length];
        List<List<Integer>>grapes = new ArrayList<>();
        for(int i =0; i<=n; i++)grapes.add(new ArrayList<>());
        for(int i =0; i<roads.length; i++){
            grapes.get(roads[i][0]).add(roads[i][1]);
            grapes.get(roads[i][1]).add(roads[i][0]);    
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<Integer>queue = new LinkedList<>();
        dist[destination] = 0;
        queue.add(destination);
        
        while(!queue.isEmpty()){
            int current = queue.remove();
            for(int i =0; i<grapes.get(current).size(); i++){
                int next = grapes.get(current).get(i);
                if(dist[next] > dist[current]+1){
                    dist[next] = dist[current]+1;
                    queue.add(next);
                }
            }
        }
        for(int i =0; i<sources.length; i++){
            answer[i] = dist[sources[i]] < Integer.MAX_VALUE ? dist[sources[i]] : -1;
        }
        return answer;
    }
}