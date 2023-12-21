import java.util.*;
class Solution {
    static ArrayList<ArrayList<Node>>grapes = new ArrayList<>();
    public int solution(int n, int s, int a, int b, int[][] fares) {
        for(int i =0; i<n+1; i++){
            grapes.add(new ArrayList<Node>());
        }
        for(int i =0; i<fares.length; i++){
            grapes.get(fares[i][0]).add(new Node(fares[i][1],fares[i][2]));
            grapes.get(fares[i][1]).add(new Node(fares[i][0],fares[i][2]));
        }
        int []distS = dijkstra(s);
        int []distA = dijkstra(a);
        int []distB = dijkstra(b);
        
        int answer = Integer.MAX_VALUE;
        for(int i =1; i<n+1; i++){
            answer = Math.min(answer,distS[i]+distA[i]+distB[i]);
        }
        return answer;
    }
    public int[] dijkstra(int start){
        PriorityQueue<Node>pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        int[]dist = new int[grapes.size()];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        
        while(!pq.isEmpty()){
            Node current = pq.remove();
            int cIdx = current.index;
            int cdist = current.dist;
            for(int i =0; i<grapes.get(cIdx).size(); i++){
                Node next = grapes.get(cIdx).get(i);
                int nIdx = next.index;
                int ndist = next.dist;
                if(dist[nIdx] > dist[cIdx]+ndist){
                    dist[nIdx] = dist[cIdx]+ndist;
                    pq.add(new Node(nIdx,dist[nIdx]));
                }
            }
        }
        return dist;
    }
}

class Node implements Comparable<Node>{
    int index;
    int dist;
    
    public Node(int index,int dist){
        this.index = index;
        this.dist = dist;
    }
    @Override
    public int compareTo(Node o){
        return Integer.compare(this.dist,o.dist);
    }
}