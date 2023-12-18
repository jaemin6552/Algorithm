class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        for(long i =l-1; i<r; i++){
            long idx = i;
            while(idx > 5){
                if(idx % 5 == 2) break;
                idx /= 5;
            }
            if(idx % 5 != 2) answer++;
        }
        return answer;
    }
    
}
