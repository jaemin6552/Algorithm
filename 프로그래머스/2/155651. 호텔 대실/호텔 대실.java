import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
class Solution {
    static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    public static final int CLEAN_TIME = 600000;
    public int solution(String[][] book_time)throws ParseException {
        int answer = 0;
        PriorityQueue<Date>queueTime = new PriorityQueue<>();
        Arrays.sort(book_time, Comparator.comparing(row -> row[0]));
        for(String[] times : book_time){
            if(!queueTime.isEmpty()){
                Date current = queueTime.peek();
                if(current.getTime()+CLEAN_TIME <= sdf.parse(times[0]).getTime()) queueTime.remove();
            }
            queueTime.add(sdf.parse(times[1]));
            answer = Math.max(answer,queueTime.size());
        }
        
        return answer;
    }
}