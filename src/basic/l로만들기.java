package basic;

//문제 설명
//알파벳 소문자로 이루어진 문자열 myString이 주어집니다.
//알파벳 순서에서 "l"보다 앞서는 모든 문자를 "l"로 바꾼 문자열을 return 하는 solution 함수를 완성해 주세요.
public class l로만들기 {
    public String solution(String myString) {
        StringBuilder stb = new StringBuilder();
        for(char ch : myString.toCharArray()){
            stb.append(ch < 'l' ? 'l' : ch);
        }
        return stb.toString();
    }
    //문자열을 붙일때 String은 불변성이기때문에 연산이 들어가면 새로 공간을 할당해서 속도가 느린것은 알고있었지만
    //자바10버전부터는 많이 개선되어서 속도차이가 얼마 안난다고 생각했으나 프로그래머스에서 계산할경우 속도차이가 800ms->6ms정도로 차이가
    //발생하여서 스트링빌더로 append하는 방식으로 바꾸었다.
}
