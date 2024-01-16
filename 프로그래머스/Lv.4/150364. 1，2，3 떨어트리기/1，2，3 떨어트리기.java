import java.util.*;
class Solution {
    List<List<Integer>>grapes;
    List<Integer>orders;
    public int[] solution(int[][] edges, int[] target) {
        int[] treeCnt = new int[target.length];
        grapes = new ArrayList<>();
        orders = new ArrayList<>();
        List<Integer>head = new ArrayList<>();
        for(int i =0; i<target.length; i++){
            grapes.add(new ArrayList<>());
            head.add(i);
        }
        for(int[] edge : edges){
            grapes.get(edge[0]-1).add(edge[1]-1);
            if(head.contains(edge[1]-1)) head.remove(Integer.valueOf(edge[1]-1));
        }
        for(List<Integer>list : grapes){
            Collections.sort(list);
        }
        int cnt =getCaseCnt(target,treeCnt,head.get(0));
        if(cnt == -1) return new int[]{-1};
        List<Integer>answer = new ArrayList<>();
        for(int i =0; i<orders.size(); i++){
            int cur = orders.get(i);
            for(int j = 1; j<=3; j++){
                if(target[cur]-j <= (treeCnt[cur]-1) * 3){
                    target[cur] -=j;
                    treeCnt[cur]--;
                    answer.add(j);
                    break;
                }
            }  
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    public int getCaseCnt(int[] target,int[] treeCnt,int head){
        Queue<Integer>queue = new LinkedList<>();
        queue.add(head);
        int total = 0;
        while(!queue.isEmpty()){
            int cur = queue.remove();
            if(!grapes.get(cur).isEmpty()){
                int next = grapes.get(cur).get(treeCnt[cur] % grapes.get(cur).size());
                treeCnt[cur]++;
                queue.add(next);
            } else{
                total++;
                treeCnt[cur]++;
                boolean flag = true;
                orders.add(cur);
                for(int i = 0; i<treeCnt.length; i++){
                    if(treeCnt[i]*3 < target[i]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    return total;
                }
                if(treeCnt[cur]*3 > (target[cur] * 3)) return -1;
                queue.add(head);
                }
        }
        return -1;
    }
}