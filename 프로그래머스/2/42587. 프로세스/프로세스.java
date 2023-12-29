import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Node>que = new LinkedList<>();
        List<Integer>list = new ArrayList<>();
        for(int i = 0; i<priorities.length; i++){
            que.add(new Node(i,priorities[i]));
            list.add(priorities[i]);
        }
        Collections.sort(list,Collections.reverseOrder());
        int idx=0;
        while(!que.isEmpty()){
            Node cur = que.remove();
            if(cur.priority != list.get(idx)) que.add(cur);
            else{
                idx++;
                answer++;
                if(cur.location == location) break;
            }
        }
        return answer;
    }
}
class Node{
    int location;
    int priority;
    
    public Node(int location,int priority){
        this.location = location;
        this.priority = priority;
    }
}