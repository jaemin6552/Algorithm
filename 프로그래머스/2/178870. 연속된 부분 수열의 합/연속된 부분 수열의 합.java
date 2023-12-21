class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = sequence.length;
        int end = 0;
        int tmp = 0;
        for(int i =0; i<sequence.length; i++){
            while(tmp < k  && end < sequence.length){ 
                tmp += sequence[end];
                end++;
            }
            int j = end-1;
            if(tmp == k){
                if(j-i < answer[1]-answer[0]){
                    answer[0] = i;
                    answer[1] = j;
                }
            }
            tmp -=sequence[i];
        }
        return answer;
    }
}