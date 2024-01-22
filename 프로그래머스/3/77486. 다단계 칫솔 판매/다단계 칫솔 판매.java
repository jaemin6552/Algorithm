import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] result = new int[enroll.length];
        HashMap<String,String>nameMap = new HashMap<>();
        HashMap<String,Integer>moneyMap = new HashMap<>();
        for(int i =0; i<enroll.length; i++){
            if(referral[i].equals("-")) continue;
            nameMap.put(enroll[i],referral[i]);
        }
        for(int i =0; i<seller.length; i++){
            String key = seller[i];
            int sell = amount[i]*100;
            while(nameMap.get(key) != null){
                int total = moneyMap.getOrDefault(key,0);
                int share = (int)(sell*0.1);
                int myself = sell-share;
                moneyMap.put(key,total+myself);
                sell=share; 
                if(sell == 0) break;
                key = nameMap.get(key);
            }
            int total = moneyMap.getOrDefault(key,0);
            int share = (int)(sell*0.1);
            int myself = sell-share;
            moneyMap.put(key,total+myself);
        }
        for(int i =0; i<result.length; i++){
            result[i] = moneyMap.getOrDefault(enroll[i],0);
        }
        return result;
    }
}
