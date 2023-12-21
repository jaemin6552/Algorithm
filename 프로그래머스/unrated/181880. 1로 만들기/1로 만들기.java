class Solution {
    
    public int solution(int[] num_list) {
        int answer = 0;
        for(int e : num_list){
            while( e != 1){
                e /=2;
                answer++;
            }
        }
        return answer;
    }
}