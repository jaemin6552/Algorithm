class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        recursion(arr,arr.length,answer);
        return answer;
    }
    public void recursion(int[][] arr,int length,int[] answer){
        if(length == 1){
            answer[arr[0][0]]++;
            return;
        }
        int first_n = arr[0][0];
        boolean isAllEquals = true;
        for(int i =0; i<length; i++){
            for(int j =0; j<length; j++){
                if(arr[i][j] != first_n){
                    isAllEquals = false;
                    break;
                }
            }
            if(isAllEquals == false) break;
        }
        if(isAllEquals){
            answer[first_n]++;
        }else{
            int [][]leftTop = new int[length/2][length/2];
            int [][]leftBottom = new int[length/2][length/2];
            int [][]rightTop = new int[length/2][length/2];
            int [][]rightBottom = new int[length/2][length/2];
            for( int i =0; i<length/2; i++){
                for( int j =0; j<length/2; j++){
                    leftTop[i][j] = arr[i][j];
                    leftBottom[i][j] = arr[i+length/2][j];
                    rightTop[i][j] = arr[i][j+length/2];
                    rightBottom[i][j] = arr[i+length/2][j+length/2];
                }
            }
            recursion(leftTop,length/2,answer);
            recursion(leftBottom,length/2,answer);
            recursion(rightTop,length/2,answer);
            recursion(rightBottom,length/2,answer);
        }
    }
}