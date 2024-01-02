import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer>collatz = new ArrayList<>();
        List<Double>area = new ArrayList<>();
        collatz.add(k);
        while(k > 1){
            k = k % 2 == 0 ? k/2 : k*3+1;
            collatz.add(k);
        }
        int collSize = collatz.size();
        for(int i =0; i<collSize-1; i++){
            area.add(((double)collatz.get(i)+collatz.get(i+1))/2);
        }
        System.out.println(area);
        for(int i =0; i<ranges.length; i++){
            int range = collSize+ranges[i][1]-1;
            if(ranges[i][0] == 0 && ranges[i][1] == 0) range = collSize-1;
            if(ranges[i][0] > range) answer[i] = -1;
            for(int j=ranges[i][0]; j<range; j++){
                if(j >=area.size()) answer[i] = -1;
                else answer[i]+=area.get(j);
            }
        }
        return answer;
    }
}