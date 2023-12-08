package basic;

//알파벳으로 이루어진 문자열 myString이 주어집니다. 모든 알파벳을 소문자로 변환하여 return 하는 solution 함수를 완성해 주세요.
public class 소문자로바꾸기 {
    public String solution(String myString) {
        return myString.toLowerCase();
    }
    //toLowerCase()를 사용하지않는다면 아래 방식처럼 대문자인경우만 소문자로 바꿔줄수도 있을것이다.
    //String answer= "";
    //        for(char ch : myString.toCharArray()){
    //            answer += (char)(ch < 'a' ? ch+32 : ch);
    //        }
    //        return answer;
}
