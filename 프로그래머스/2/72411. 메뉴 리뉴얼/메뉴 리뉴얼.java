import java.util.*;
class Solution {
      HashMap<Integer,HashMap<String,Integer>>map;
      Set<Integer>set;
      int maxCourse;
    public String[] solution(String[] orders, int[] course) {
        map = new HashMap<>();
        set = new HashSet<>();
        maxCourse = course[course.length-1];
        List<String>answer = new ArrayList<>();
        for(int length : course) {
            map.put(length,new HashMap<>());
            set.add(length);
        }
        for(String str : orders){
            str = charSort(str);
            dfs(str,0,new StringBuilder(), new boolean[str.length()]);
        }
        for(Integer key : set){
            Set<String>mapKeySet = map.get(key).keySet();
            int maxCnt = 0;
            for(String strKey : mapKeySet){
                maxCnt = Math.max(maxCnt,map.get(key).get(strKey));
            }
            if(maxCnt < 2) continue;
            for(String strKey : mapKeySet){
                if(maxCnt == map.get(key).get(strKey)) answer.add(strKey);
            }
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    public void dfs(String order,int idx,StringBuilder sb,boolean []check){
        int len = sb.length();
        if(set.contains(len)){
            String str = sb.toString();
            int cnt = map.get(len).getOrDefault(str,0)+1;
            map.get(len).put(str,cnt);
            if(len == maxCourse) return;
        }
        for(int i = idx; i<order.length(); i++){
            if(!check[i]){
                check[i] = true;
                sb.append(order.charAt(i));
                dfs(order,i+1,sb,check);
                check[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public String charSort(String str){
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}