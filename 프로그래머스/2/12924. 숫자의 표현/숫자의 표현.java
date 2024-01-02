class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i =1; i<=n; i++){
            int sum = i;
            int total = 0;
            while(total < n){
                total += sum++;
                if(total == n) answer++;
            }
        }
        return answer;
    }
}