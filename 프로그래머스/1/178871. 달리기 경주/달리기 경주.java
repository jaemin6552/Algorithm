import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<Integer,String>iMap = new HashMap<>();
        HashMap<String,Integer>sMap = new HashMap<>();
        String []answer = new String[players.length];
        for(int i =0; i<players.length; i++){
            iMap.put(i,players[i]);
            sMap.put(players[i],i);
        }
        for(String str : callings){
          int nowTmp = sMap.get(str);
          int preTmp = nowTmp-1;
          String nowStr = str;
          String preStr = iMap.get(preTmp); 
          iMap.put(nowTmp,preStr);
          iMap.put(preTmp,nowStr);
          sMap.put(nowStr,preTmp);
          sMap.put(preStr,nowTmp);
        }
        for(String str : sMap.keySet()){
            answer[sMap.get(str)] = str;
        }
        return answer;
    }
}