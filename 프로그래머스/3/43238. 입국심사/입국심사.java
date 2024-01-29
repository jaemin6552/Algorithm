import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long min = 1;
        long max = (long)times[0] * n;
        while(min <= max){
            long mid = (max+min)/2;
            int cnt = 0;
            for(int e : times) {
                cnt += mid/e;
                if(cnt > n)break;
            }
            System.out.println(min);
            System.out.println(max);
            if(cnt >= n ) max = mid-1;
            else min= mid+1;
        }
        System.out.println(min +" "+max);
        return min;
    }
}