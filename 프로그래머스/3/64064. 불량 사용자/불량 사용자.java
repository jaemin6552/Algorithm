import java.util.*;
class Solution {
    boolean []visited;
    List<List<String>> answer;
    public int solution(String[] user_id, String[] banned_id) {
        answer = new ArrayList<>();
        visited = new boolean[user_id.length];
        dfs(user_id,banned_id,0);
        return answer.size();
    }
    public void dfs(String[] user_id,String[] banned_id,int start){
        if(start == banned_id.length){
            List<String> tmp = new ArrayList<>();
            for(int i =0; i<visited.length; i++){
                if(visited[i]){
                    tmp.add(user_id[i]);
                } 
            }
            if(!answer.contains(tmp)) answer.add(tmp);
            return;
        }
        for(int i =0; i<user_id.length; i++){
            if(!visited[i] && isMatch(user_id[i],banned_id[start])){
                visited[i] = true;
                dfs(user_id,banned_id,start+1);
                visited[i] = false;
            }
        }
    }
    public boolean isMatch(String user_id,String banned_id){
        if(user_id.length() != banned_id.length()) return false;
        for(int i =0; i<user_id.length(); i++){
            if(banned_id.charAt(i) == '*') continue;
            if(user_id.charAt(i) != banned_id.charAt(i)) return false;
        }
        return true;
    }
}