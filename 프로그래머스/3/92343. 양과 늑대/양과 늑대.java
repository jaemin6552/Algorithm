import java.util.*;
class Solution {
    static int answer = 0;
    static ArrayList<ArrayList<Integer>>grapes = new ArrayList<>();
    public int solution(int[] info, int[][] edges) {
        boolean[]visited = new boolean[info.length];
        
        for(int i =0; i<info.length; i++){
            grapes.add(new ArrayList<>());
        }
        for(int i =0; i<edges.length; i++){
            grapes.get(edges[i][0]).add(edges[i][1]);
            grapes.get(edges[i][1]).add(edges[i][0]);
        }
        dfs(0,0,0,visited,info);
        return answer;
    }
    public void dfs(int root,int wolf,int sheep,boolean []visited,int[] info){
        if(info[root] == 1) wolf++;
        if(info[root] == 0) sheep++;
        if(wolf >= sheep){
            return;
        }
        boolean [] newVisited = visited.clone();
        newVisited[root] = true;
        answer=Math.max(answer,sheep);
        for(int i =0; i<newVisited.length; i++){
            if(newVisited[i] == true){
                for(int j =0; j<grapes.get(i).size(); j++){
                    int nRoot = grapes.get(i).get(j);
                    if(newVisited[nRoot] == false){
                        dfs(nRoot,wolf,sheep,newVisited,info);
                    }
                }
            }
        }
    }
}