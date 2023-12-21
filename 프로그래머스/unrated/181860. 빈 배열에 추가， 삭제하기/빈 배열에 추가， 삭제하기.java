import java.util.*;
class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        LinkedList<Integer>list_tmp = new LinkedList<>();
        for(int i =0; i<arr.length; i++){
            if(flag[i]) {
                for(int j =0; j<arr[i]*2; j++){
                    list_tmp.add(arr[i]);
                }
            }else{
                for(int j = 0; j<arr[i]; j++){
                    list_tmp.removeLast();
                }
            }
        }
        
        return list_tmp.stream().mapToInt(Integer::intValue).toArray();
    }
}