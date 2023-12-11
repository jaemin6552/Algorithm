class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int tmp = 0;
        for(int[] col : queries){
            tmp = arr[col[0]];
            arr[col[0]] = arr[col[1]];
            arr[col[1]] = tmp;
        }
        return arr;
    }
}