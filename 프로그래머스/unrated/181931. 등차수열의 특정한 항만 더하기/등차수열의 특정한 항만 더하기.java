class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        for(boolean b : included){
            answer += b ? a : 0;
            a+=d;
        }
        return answer;
    }
}