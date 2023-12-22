import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer>list = new ArrayList<>();
        HashMap<String,Integer>map = new HashMap<>();
        for(int i =0; i<yearning.length; i++){
            map.put(name[i],yearning[i]);
        }
        for(String[] arrStr : photo){
            int total = 0;
            for(String str : arrStr){
                if(map.containsKey(str)){
                total+=map.get(str);
                }
            }
            list.add(total);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}