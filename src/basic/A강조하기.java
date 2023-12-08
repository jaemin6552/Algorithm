package basic;

//문제 설명
//문자열 myString이 주어집니다. myString에서 알파벳 "a"가 등장하면 전부 "A"로 변환하고,
//"A"가 아닌 모든 대문자 알파벳은 소문자 알파벳으로 변환하여 return 하는 solution 함수를 완성하세요.
public class A강조하기 {
    public String solution(String myString) {
        return myString.toLowerCase().replaceAll("a","A");
    }
}
//발상의 전환 먼저 소문자로 다바꾸고 a만 대문자로 바꾸면된다.
