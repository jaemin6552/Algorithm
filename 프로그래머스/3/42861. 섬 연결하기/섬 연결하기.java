import java.util.*;
class Solution {
    int []parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for(int i =0; i<n; i++)parent[i]=i;
        Arrays.sort(costs,(o1,o2)->Integer.compare(o1[2],o2[2]));
        for(int []cost : costs)System.out.println(Arrays.toString(cost));
        for(int i =0; i<costs.length; i++){
            if(findParent(costs[i][0]) != findParent(costs[i][1])){
                answer+=costs[i][2];
                union(costs[i][0],costs[i][1]);
            }
        }
         System.out.println(Arrays.toString(parent));
        return answer;
    }
    public void union(int a,int b){
        int parent_a = findParent(a);
        int parent_b = findParent(b);
        
        if(parent_a > parent_b)parent[parent_a] = parent_b;
        else parent[parent_b] = parent_a;
    }
    public int findParent(int x){
        if(parent[x] == x) return x;
        else return findParent(parent[x]);
    }
}
