import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
    int answer = 0;
        LinkedList<String> name = new LinkedList<>();
        for(int i = 0; i<cities.length; i++){
            String tmp = cities[i].toUpperCase();
            if(name.size() < cacheSize && !name.contains(tmp)){
               name.add(tmp);
               answer+=5;
            } else{
                if(cacheSize == 0) {
                    answer+=5;
                } else{
                    if(name.contains(tmp)){
                        name.remove(tmp);
                        answer +=1;
                        name.add(tmp);
                    }else{
                        answer+=5;
                        name.pop();
                        name.add(tmp);
                    }
                }
            }
        }
        return answer;
    }
}