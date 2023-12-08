package basic;

//문제 설명
//n × n 크기의 이차원 배열 arr이 매개변수로 주어질 때, arr이 다음을 만족하면 1을 아니라면 0을 return 하는 solution 함수를 작성해 주세요.
//0 ≤ i, j < n인 정수 i, j에 대하여 arr[i][j] = arr[j][i]
public class 특별한이차원배열2 {
    public int solution(int[][] arr) {
        for(int i =0; i<arr.length; i++){
            for(int j = i; j<arr[i].length; j++){
                if(arr[i][j] != arr[j][i]) return 0;
            }
        }
        return 1;
    }
    //j를 0으로 두지않고 i로 두는이유는 i에서 검사했다면 j에서 다시 i를 중복 검사할 필요가없기때문이다.
}
