class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        answer[0] = Integer.MAX_VALUE;
        int area = brown+yellow;
        for(int i =area/2; i>0; i--){
            if(area%i ==0){
                int x = i;
                int y = area/i;
                if((x-2)*(y-2) == yellow){
                    answer[0] = x;
                    answer[1] = y;
                    break;
                }
            }
        }
        return answer;
    }
}