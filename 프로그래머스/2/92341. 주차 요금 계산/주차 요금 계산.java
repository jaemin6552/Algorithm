import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
class Solution {
    public int[] solution(int[] fees, String[] records) throws ParseException {
        List<Integer>answer = new ArrayList<>();
        TreeMap<String,ParkingFee> numMap = new TreeMap<>();
        
        for(int i =0; i<records.length; i++){
            ParkingFee pf;
            String []record = records[i].split(" ");
            if(numMap.containsKey(record[1])) pf = numMap.get(record[1]);
            else {
                pf = new ParkingFee();
                numMap.put(record[1],pf);
            }
            if(record[2].equals("IN")){
                pf.setInTime(record[0]);
            }else pf.setOutTime(record[0]);
        }
        Collection<ParkingFee> values = numMap.values();
        for(ParkingFee pf : values){
            answer.add(pf.getFee(fees));
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
class ParkingFee{
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    Date inTime;
    Date outTime;
    int totalTime;
    int fee;

    public void setInTime(String inTime) throws ParseException {
        this.inTime = sdf.parse(inTime);
    }
    public void setOutTime(String outTime) throws ParseException {
        this.outTime = sdf.parse(outTime);
        setTotalTime();
    }
    public void setTotalTime() throws ParseException {
        this.totalTime += (int) ((this.outTime.getTime()-this.inTime.getTime())/(1000*60));
        
    }
    public int getFee(int []fees) throws ParseException {
        if (this.outTime == null || this.outTime.getTime() <= this.inTime.getTime()) {
         this.outTime = sdf.parse("23:59");
         setTotalTime();
    }
       
        if(this.totalTime <= fees[0]) return fees[1];
        int time = ((this.totalTime-fees[0]) % fees[2]) == 0 ?
            ((this.totalTime-fees[0]) / fees[2]) : ((this.totalTime-fees[0]) / fees[2]) +1;
        return fees[1]+ time * fees[3];
    }

}