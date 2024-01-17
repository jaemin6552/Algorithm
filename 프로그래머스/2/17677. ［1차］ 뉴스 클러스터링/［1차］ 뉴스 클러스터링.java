import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        List<String>intersection = new ArrayList<>();
        List<String>union = new ArrayList<>();
        
        List<String>forUnion1 = new ArrayList<>();
        List<String>forUnion2 = new ArrayList<>();
        
        List<String>forInter1 = new ArrayList<>();
        List<String>forInter2 = new ArrayList<>();
        for(int i =0; i<str1.length()-1; i++){
            char tmp1 = str1.charAt(i);
            char tmp2 = str1.charAt(i+1);
            if(tmp1 < 'A' || tmp1 > 'Z' || tmp2 < 'A' || tmp2 > 'Z') continue;
            String tmp = ""+tmp1+tmp2;
            forInter1.add(tmp);
            forUnion1.add(tmp);
        }
        for(int i =0; i<str2.length()-1; i++){
            char tmp1 = str2.charAt(i);
            char tmp2 = str2.charAt(i+1);
            if(tmp1 < 'A' || tmp1 > 'Z' || tmp2 < 'A' || tmp2 > 'Z') continue;
            String tmp = ""+tmp1+tmp2;
            forInter2.add(tmp);
            forUnion2.add(tmp);
        }
        for(String str : forInter1){
            if(forInter2.contains(str)) {
                intersection.add(str);
                forInter2.remove(str);
            }
        }
        for(String str : forUnion1){
            if(forUnion2.contains(str)) forUnion2.remove(str);
            union.add(str);
        }
        for(String str : forUnion2){
            union.add(str);
        }
        if(intersection.size() == 0 && union.size() == 0) return 65536;
        answer = (int)Math.floor(((double)intersection.size()/union.size())*65536);
        return answer;
    }
}