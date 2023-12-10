class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int front_length =intervals[0][1]-intervals[0][0]+1;
        int back_length = intervals[1][1]-intervals[1][0]+1;

        int[] answer = new int[front_length+back_length];
                System.arraycopy(arr,
                intervals[0][0],answer,0,front_length);
                System.arraycopy(arr,
                intervals[1][0],answer,front_length,back_length);
        
        return answer;
    }
}