import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int []tmp = arr.clone();
        Arrays.sort(tmp);
        int min = tmp[0];
        List<Integer>answer = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            if(arr[i] != min) answer.add(arr[i]);
        }
        if(answer.isEmpty()) return new int[]{-1};
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}