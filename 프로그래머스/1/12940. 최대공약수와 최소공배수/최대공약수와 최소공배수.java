class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
            int max = n >= m ? n : m;
            int min = n >= m ? m : n;
            int tmp = 0;
            while(true){
                if(max % min == 0) break;
                tmp = min;
                min = max % min;
                max = tmp;
            }
            answer[0] = min;
            answer[1] = n * m / min;

            return answer;
    }
}