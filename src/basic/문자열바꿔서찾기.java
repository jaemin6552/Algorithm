package basic;
//문제 설명
//문자 "A"와 "B"로 이루어진 문자열 myString과 pat가 주어집니다.
// myString의 "A"를 "B"로, "B"를 "A"로 바꾼 문자열의 연속하는 부분 문자열 중 pat이 있으면 1을 아니면 0을 return 하는 solution 함수를 완성하세요.
public class 문자열바꿔서찾기 {
    public int solution(String myString, String pat) {
        String tmp ="";
        for(int i =0; i<myString.length(); i++){
            tmp += myString.charAt(i) == 'A' ? "B" : "A"; //삼항연산자로 'A','B'를 스왑해주는데 미리 대문자 A를 소문자 a로
        }                                                 //스왑해준뒤 모든B를 A로 스왑하고 a를 B로 스왑해주는것도 가능하다.
        return tmp.contains(pat) ? 1 : 0;
    }
}
