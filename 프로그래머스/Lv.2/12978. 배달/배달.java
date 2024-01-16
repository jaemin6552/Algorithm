import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<List<Node>>grapes = new ArrayList<>();
        int []dist = new int[N];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i =0; i<N; i++) grapes.add(new ArrayList<>());
        for(int []arr : road) {
            grapes.get(arr[0]-1).add(new Node(arr[1]-1,arr[2]));
            grapes.get(arr[1]-1).add(new Node(arr[0]-1,arr[2]));
        }
        PriorityQueue<Node>pq = new PriorityQueue<>();
        pq.add(new Node(0,0));
        dist[0] = 0;
        while(!pq.isEmpty()){
            int current = pq.remove().num;
            for(int i =0; i<grapes.get(current).size(); i++){
                Node next = grapes.get(current).get(i);
                if(dist[current] + next.dist < dist[next.num]){
                    dist[next.num] = dist[current]+next.dist;
                    pq.add(next);
                }
            }
        }
        for(int time : dist) if(time <= K) answer++;
        return answer;
    }
}
class Node implements Comparable<Node>{
    int num;
    int dist;
    public Node(int num,int dist){
        this.num = num;
        this.dist = dist;
    }
    @Override
    public int compareTo(Node o) {
        return this.dist-o.dist;
    }
}