import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PriorityQueue;

class Solution {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

    public String solution(int n, int t, int m, String[] timetable) throws ParseException {
        Date start = sdf.parse("09:00");
        PriorityQueue<Date> pq = new PriorityQueue<>();

        for (String str : timetable) {
            pq.add(sdf.parse(str));
        }

        Date last = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Date current = pq.peek();
                if (current != null && current.getTime() <= start.getTime()) {
                    last = pq.poll();
                    if(j < m-1) last = start;
                    else last.setTime(last.getTime() - 60000);
                } else {
                    if(j < m-1) last = start;
                    break;
                }
            }
            if (i == n - 1) {
                break;
            }
            start.setTime(start.getTime() + 60000 * t);
        }
        return sdf.format(last != null ? last : start);
    }
}