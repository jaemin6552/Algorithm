import java.util.*;
class Solution {
    public int solution(int[] a) {
        int answer = 0;
        HashMap<Integer,Integer>hashmap = new HashMap<>();
        PriorityQueue<Node>pq = new PriorityQueue<>();
        for(int e : a){
            int cnt = hashmap.getOrDefault(e,0)+1;
            hashmap.put(e,cnt);
        }
        for(Integer key : hashmap.keySet()) pq.add(new Node(key,hashmap.get(key)));
        while(!pq.isEmpty()){
            Node current = pq.remove();
            int target = current.num;
            int sum = 0;
            if(current.cnt <= answer) break;
            for(int i=0; i<a.length-1; i++){
                if(a[i] != target && a[i+1] != target || a[i] == a[i+1]) continue;
                i++;
                sum++;
            }
            answer = Math.max(answer,sum);
        }
        return answer*2;
    }
}
class Node implements Comparable<Node>{
    int num;
    int cnt;
    public Node(int num,int cnt){
        this.num = num;
        this.cnt = cnt;
    }
    @Override
    public int compareTo(Node o){
        return o.cnt-this.cnt;
    }
}