import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;

class Solution {
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss.SSS");
    public int solution(String[] lines) throws ParseException {
        int answer = 1;
        int[][] time = new int[lines.length][2]; //0시작 1끝
        for(int i =0; i<lines.length; i++){
            int hour = Integer.valueOf(lines[i].substring(11, 13));
            int min = Integer.valueOf(lines[i].substring(14, 16));
            double sec = Double.valueOf(lines[i].substring(17, 23));
            double dur = Double.valueOf(lines[i].substring(24, lines[i].length() - 1));
            time[i][1] = hour * 60 * 60 * 1000 + min * 60 * 1000 + (int)(sec*1000);
            time[i][0] = time[i][1]-(int)(dur*1000)+1;
        }
        for(int i =0; i<lines.length; i++){
            int cnt = 1;
            for(int j = i+1; j<lines.length; j++){
                if(time[i][1]+999 >= time[j][0])cnt++;
            }
            answer = Math.max(answer,cnt);
        }
        
        return answer;
    }
}