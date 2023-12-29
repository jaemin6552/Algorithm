class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        for(int i =0; i<arr.length; i++){
            answer = LCM(arr[i],answer);
        }
        return answer;
    }
    public int LCM(int a, int b){
        int multiply = a*b;
        while(a % b != 0){
            int tmp = b;
            b = a%b;
            a = tmp;
        }
        return multiply/b;
    }
}