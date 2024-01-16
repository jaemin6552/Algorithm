import java.util.*;
class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        int a_length = a.length-1;
        HashSet<Integer>hashset = new HashSet<>();
        for(int i =0; i<=a_length; i++){
            left = Math.min(left,a[i]);
            right = Math.min(right,a[a_length-i]);
            hashset.add(left);
            hashset.add(right);
        }
        return hashset.size();
    }
}