package basic;
//문제 설명
//한 자리 정수로 이루어진 문자열 num_str이 주어질 때, 각 자리수의 합을 return하도록 solution 함수를 완성해주세요.
public class 문자열정수의합 {
    public int solution(String num_str) {
        int answer = 0;
        for(int i =0; i<num_str.length(); i++){
            answer+=num_str.charAt(i) - '0';
        }
//        for(char ch : num_str.toCharArray()){
//            answer+=ch-'0';
//        }
        return answer;
    }
    //charAt함수를 사용 하지않고도 toCharArray()를 이용해 향상된 포문을 사용해 값을 구할수도있다.
    //기본적인 타입이 char타입이기때문에 아세키코드값에서 정수로 바꾸려고 -'0'연산을 해준다.
}
