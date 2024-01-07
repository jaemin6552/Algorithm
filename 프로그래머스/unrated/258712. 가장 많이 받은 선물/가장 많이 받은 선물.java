import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String,HashMap<String,Integer>>map = new HashMap<>();
        HashMap<String,Integer>answer = new HashMap<>();
        HashMap<String,Integer>giftPoint = new HashMap<>();
        for(String str : friends) map.put(str,new HashMap<>());
        for(String str : friends) {
            answer.put(str,0);
            giftPoint.put(str,0);    
        }
        for(String gift : gifts){
            String []friend = gift.split(" ");
            int giverCnt = giftPoint.get(friend[0])+1;
            giftPoint.put(friend[0],giverCnt);
            int receiverCnt = giftPoint.get(friend[1])-1;
            giftPoint.put(friend[1],receiverCnt);
            int cnt = map.get(friend[0]).getOrDefault(friend[1],0)+1;
            map.get(friend[0]).put(friend[1],cnt);
        }
        for(String key : giftPoint.keySet()){
            System.out.println(key + " " + giftPoint.get(key));
        }
        for(String give : friends){
            HashMap<String,Integer>giver = map.get(give);
            for(String receive : friends){
                if(give.equals(receive)) continue;
                HashMap<String,Integer>receiver = map.get(receive);
                int giverCnt = giver.getOrDefault(receive,0);
                int receiverCnt = receiver.getOrDefault(give,0);
                if(giverCnt > receiverCnt){
                    int cnt = answer.get(give)+1;
                    answer.put(give,cnt);
                }else if(giverCnt == receiverCnt){
                    int giverPoint = giftPoint.get(give);
                    int receiverPoint = giftPoint.get(receive);
                    if(giverPoint > receiverPoint){
                         int cnt = answer.get(give)+1;
                         answer.put(give,cnt);
                    }
                }
            }
        }
        int max = 0;
        for(String key : answer.keySet()){
            max = Math.max(max,answer.get(key));
        }
        return max;
    }
}