class Solution {
    boolean []visited;
    int answer;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        dfs(k,dungeons,0,0);
        return answer;
    }
    public void dfs(int k,int[][] dungeons,int start,int cnt){
        int max = cnt;
        for(int i =0; i<dungeons.length; i++){
            if(!visited[i] && k >= dungeons[i][0]){
            visited[i] = true;
            dfs(k-dungeons[i][1],dungeons,i+1,max+1);
            visited[i] = false;
            }
        }
         answer = Math.max(answer,max);
    }
}