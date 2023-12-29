import java.util.*;
class Solution {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();
        String []strArr =s.substring(0,s.length()-2).replaceAll("\\{","").split("},");
        Arrays.sort(strArr,Comparator.comparingInt(str -> str.length()));
        for(String str : strArr){
            String [] all = str.split(",");
            for(String each : all){
                Integer tmp = Integer.valueOf(each);
                if(!answer.contains(tmp)) answer.add(tmp);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}