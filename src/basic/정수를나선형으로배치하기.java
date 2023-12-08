package basic;

//문제 설명
//양의 정수 n이 매개변수로 주어집니다.
// n × n 배열에 1부터 n2 까지 정수를 인덱스 [0][0]부터 시계방향 나선형으로 배치한 이차원 배열을 return 하는 solution 함수를 작성해 주세요.
public class 정수를나선형으로배치하기 {
    public int[][] solution(int n) {
        //여러가지 방법이 있겠지만 나는 네모를 한번그릴때마다 한변이 2씩 줄어든다는 공식을 이용했다.
        int[][] answer = new int[n][n];
        int num = 1;
        int x = 0;
        int y = 0;
        for(int i = n; i>0 ; i -= 2){
            for(int j = 0; j<i; j++){
                answer[y][x] = num++;
                x++;
            }
            x--;
            y++;
            for(int j = 1; j<i; j++){
                answer[y][x] = num++;
                y++;
            }
            y--;
            x--;
            for(int j = 1; j<i; j++){
                answer[y][x] = num++;
                x--;
            }
            x++;
            y--;
            for(int j = 2; j<i; j++){
                answer[y][x] = num++;
                y--;
            }
            y++;
            x++;
        }
        return answer;
    }
}
