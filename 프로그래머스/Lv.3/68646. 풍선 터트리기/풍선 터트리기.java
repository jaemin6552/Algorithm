import java.util.*;
class Solution {
    public int solution(int[] a) {
        int answer = 0;
        List<Integer>left = new ArrayList<>();
        List<Integer>right = new ArrayList<>();
        int a_length = a.length-1;
        for(int i = 0; i<a.length; i++){
            if(left.isEmpty())left.add(a[i]);
            else left.add(left.get(i-1) > a[i] ? a[i] : left.get(i-1));
        }
        for(int i = 0; i<a.length; i++){
            if(right.isEmpty())right.add(a[a_length-i]);
            else right.add(right.get(i-1) > a[a_length-i] ? a[a_length-i] : right.get(i-1));
        }
        for(int i =0; i<=a_length; i++){
            if(a[i] <= left.get(i) || a[i] <= right.get(a_length-i)) answer++;
        }      
        return answer;
    }
}