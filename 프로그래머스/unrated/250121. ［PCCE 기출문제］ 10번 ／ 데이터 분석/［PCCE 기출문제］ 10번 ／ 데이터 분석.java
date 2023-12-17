import java.util.*;

class Solution {
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]>answer = new ArrayList<>();
        int ext_idx = ext.equals("code") ? 0 : ext.equals("date") ? 1 : ext.equals("maximum") ? 2 : 3;
        int sort_idx=sort_by.equals("code") ? 0:sort_by.equals("date") ? 1:sort_by.equals("maximum") ? 2 : 3;
        for(int i =0; i<data.length; i++){
           if(data[i][ext_idx] < val_ext) answer.add(data[i]);
        }
        answer.sort((a, b) -> Integer.compare(a[sort_idx], b[sort_idx]));
        
        return answer;
    }
}