import java.util.*;
class Solution {
    List<String>list;
    int []dx = {1,0,0,-1};
    int []dy = {0,-1,1,0};
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        list = new ArrayList<>();
        return dfs(n,m,x,y,r,c,k,0,new StringBuilder());
    }
    public String dfs(int n,int m,int x,int y,int r,int c,int k,int cnt,StringBuilder sb){
        int dist = Math.abs(x-r)+Math.abs((y-c));
        if(dist > k || (k-dist) % 2 == 1 )return "impossible";        
        while(cnt != k){
            for(int i =0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx < 1 || nx > n || ny < 1 || ny > m) continue;
                int cost = Math.abs(nx-r)+Math.abs((ny-c));
                int remain = k-(cnt+1);
                char tmp = ' ';
                if(cost > remain )continue;
                if (dx[i] == 1) tmp = 'd';
                else if (dx[i] == -1) tmp = 'u';
                else if (dy[i] == 1) tmp = 'r';
                else if (dy[i] == -1) tmp = 'l';
                sb.append(tmp);
                cnt++;
                x=nx;
                y=ny;
                break;
            }
        }
        return sb.toString();    
    }
}