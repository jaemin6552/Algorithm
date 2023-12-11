class Solution {
    
    public int solution(int[] num_list) {
        int answer = 0;
        for(int e : num_list){
            while( e != 1){
                if(e % 2 != 0) e--;
                e /=2;
                answer++;
            }
        }
        return answer;
    }
}