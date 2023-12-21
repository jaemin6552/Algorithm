import java.util.*;
class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer>list = new ArrayList<>();
        int tmp =0;
        for(String str : intStrs){
            tmp = Integer.parseInt(str.substring(s,s+l));
            if(tmp > k) list.add(tmp);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}