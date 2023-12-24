import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
class Solution {
    static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    public String[] solution(String[][] plans) throws ParseException{
        String[] answer = new String[plans.length];
        Arrays.sort(plans, (o1, o2) -> o1[1].compareTo(o2[1]));
        int idx = 0;
        Stack<Subject>stack = new Stack<>();
        for(int i =0; i<plans.length-1; i++){
            long now = sdf.parse(plans[i][1]).getTime()+60000*Long.parseLong(plans[i][2]);
            long next = sdf.parse(plans[i+1][1]).getTime();
            long remainT = next-now;
            if(now > next){
                stack.push(new Subject(plans[i][0],now-next));
            }else{
                answer[idx++] = plans[i][0];
                while(!stack.isEmpty() && remainT > 0){
                    Subject subject = stack.peek();
                    if(remainT >= subject.remainT){
                        answer[idx++] = subject.name;
                        remainT-= subject.remainT;
                        stack.pop();
                    }else{
                        long newRemain = subject.remainT - remainT;
                        String newName = subject.name;
                        stack.pop();
                        stack.push(new Subject(newName,newRemain));
                        remainT = 0;
                    }
                }
            }   
        }
        answer[idx++] = plans[plans.length-1][0];
        while(!stack.isEmpty()){
            answer[idx++] = stack.pop().name;
        }
        return answer;
    }
}
class Subject{
    String name;
    long remainT;
    public Subject(String name,long remainT){
        this.name = name;
        this.remainT = remainT;
    }
}