class Solution {
    public int solution(int[] arr) {
        for(int i =0; i<arr.length-1; i++){
            arr[i+1] = LCM(arr[i+1],arr[i]);
        }
        return arr[arr.length-1];
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