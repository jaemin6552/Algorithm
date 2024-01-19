import java.util.*;
class Solution {
    int []dx = {1,0,-1,0};
    int []dy = {0,1,0,-1};
    public int solution(int[][] land, int height) {
        int answer = 0;
        boolean [][]visited = new boolean[land.length][land.length];
        List<Integer>mst = new ArrayList<>();
        PriorityQueue<Node>pq = new PriorityQueue<>();
        pq.add(new Node(0,0,land[0][0]));
        while(!pq.isEmpty()){
            Node current = pq.remove();
            int cx= current.x;
            int cy= current.y;
            if(visited[cy][cx]) continue;
            visited[cy][cx]= true;
            mst.add(current.cost);
            for(int i =0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(ny < 0 || ny > land.length-1 || nx < 0 || nx > land.length-1)
                    continue;
                int between = Math.abs(land[cy][cx]-land[ny][nx]);
                pq.add(new Node(nx,ny,between));
            }
        }
        for(int i =1; i<mst.size(); i++){
            if(mst.get(i) > height) answer+=mst.get(i);
        }
        return answer;
    }
}
class Node implements Comparable<Node>{
    int x;
    int y;
    int cost;
    public Node(int x,int y,int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node other){
        return this.cost - other.cost;
    }
}