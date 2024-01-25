import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        answer[1] = Integer.MAX_VALUE;
        HashMap<String,Integer>hashmap = new HashMap<>();
        HashSet<String>hashset = new HashSet<>();
        int left = 0;
        int right = 0;
        for(String str : gems){
            hashset.add(str);
        }
        while(left < gems.length){
            int cnt = 0;
            if(hashmap.size() == hashset.size()){
                cnt = hashmap.get(gems[left]);
                if(cnt == 1){
                    if(answer[1]-answer[0] > right-(left+1)){
                        answer[0] = left+1;
                        answer[1] = right;
                    }
                    hashmap.remove(gems[left++]);
                }else hashmap.put(gems[left++],cnt-1);
            }else{
            if(right ==gems.length) break;
            cnt = hashmap.getOrDefault(gems[right],0)+1;
            hashmap.put(gems[right++],cnt);
            }
        }
        return answer;
    }
}