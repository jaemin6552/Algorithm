import java.util.*;
class Solution {
    public int result = 0;
    public List<List<Integer>>map = new ArrayList<>();
    public int solution(int n, int[][] lighthouse) {
        for(int i =0; i<=n; i++) map.add(new ArrayList<>());
        for(int[] row : lighthouse){
            map.get(row[0]).add(row[1]);
            map.get(row[1]).add(row[0]); 
        }
        dfs(1,0);
        return result;
    }
    public int dfs(int cur, int before){
        if(map.get(cur).size() == 1 && map.get(cur).get(0) == before) return 1;
        int cnt = 0;
        for(int i =0; i<map.get(cur).size(); i++){
            int next = map.get(cur).get(i);
            if(next == before) continue;
            cnt += dfs(next,cur);
        }
        if(cnt == 0) return 1;
          
        result++;
        return 0;
    }
}