import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int pLength = (picks[0]+picks[1]+picks[2]) * 5;
        int mLength = minerals.length;
        int length = Math.min(pLength,mLength);
        List<int[]>fatigue = new ArrayList<>();
        int diaTmp = 0;
        int ironTmp = 0;
        int stoneTmp = 0;
        for(int i =0; i<length; i++){
           switch(minerals[i]){
               case "diamond":
                   ironTmp+=5;
                   stoneTmp+=25;
                   diaTmp+=1;
                   break;
               case "iron":
                   diaTmp+=1;
                   ironTmp+=1;
                   stoneTmp+=5;
                   break;
               case "stone":
                   diaTmp+=1;
                   ironTmp+=1;
                   stoneTmp+=1;
                   break;
           }
            if(diaTmp == 5){
                fatigue.add(new int[]{diaTmp,ironTmp,stoneTmp});
                diaTmp = 0;
                ironTmp = 0;
                stoneTmp = 0;
            }
        }
        if(diaTmp != 0) fatigue.add(new int[]{diaTmp,ironTmp,stoneTmp});  
         fatigue.sort(Comparator.comparingInt(arr -> ((int[]) arr)[2]).reversed());
        
        for(int i =0; i<fatigue.size(); i++){
            if(picks[0] > 0){
                answer+=fatigue.get(i)[0];
                picks[0]--;
            }else if(picks[1] > 0){
                answer+=fatigue.get(i)[1];
                picks[1]--;
            }else {
                answer+=fatigue.get(i)[2];
                picks[2]--;
            }
        }
        return answer;
    }
}