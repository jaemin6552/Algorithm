import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int length = elements.length;
        HashSet<Integer>hashset = new HashSet<>();
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                int sum = elements[j];     
                for(int k=j; k<j+i; k++){
                    int idx = k+1 >= length ? (k+1)-length : k+1;
                    sum+= elements[idx];
                }
                hashset.add(sum);
            }
        }
        return hashset.size();
    }
}