import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String,String> userinfo = new HashMap<>();
        List<String> movement = new ArrayList<>();
        List<String> id = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        
        for(int i = 0; i < record.length;  i++){
            String []tmp = record[i].split(" ");
            if(!tmp[0].equals("Leave")){
                userinfo.put(tmp[1],tmp[2]);
            }
            movement.add(tmp[0]);
            id.add(tmp[1]);
        }
        for(int i =0; i<id.size(); i++){
            switch(movement.get(i)){
                case "Enter" :
                    answer.add(userinfo.get(id.get(i))+"님이 들어왔습니다.");
                    break;
                case "Leave" :
                    answer.add(userinfo.get(id.get(i))+"님이 나갔습니다.");
                    break;
            }
        }

        return answer.toArray(new String[0]);
    }
}