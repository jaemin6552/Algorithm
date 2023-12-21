import java.util.*;
import java.util.stream.Stream;

class Solution {
    public int[][] solution(int n) {
        List<Integer[]> list = new ArrayList<>();
        hanoi(1,2,3,n,list);
        
        return list.stream().map(array-> Stream.of(array).mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }
    public void hanoi(int start,int middle,int dest,int num,List<Integer[]>list){
        if(num == 0) return;
        hanoi(start,dest,middle,num-1,list);
        list.add(new Integer[]{start,dest});
        hanoi(middle,start,dest,num-1,list);
    }
}