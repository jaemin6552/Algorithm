package basic;
//문제 설명
//어떤 문자열에 대해서 접두사는 특정 인덱스까지의 문자열을 의미합니다.
// 예를 들어, "banana"의 모든 접두사는 "b", "ba", "ban", "bana", "banan", "banana"입니다.
//문자열 my_string과 is_prefix가 주어질 때, is_prefix가 my_string의 접두사라면 1을, 아니면 0을 return 하는 solution 함수를 작성해 주세요.

public class 접두사인지확인하기 {
    public int solution(String my_string, String is_prefix) {
        return my_string.startsWith(is_prefix) ? 1 : 0;
        //startsWith()를 사용하지않는다면 substring()으로 my_string의0번째 인덱스부터 is_prefix의 길이까지 잘라서
        //둘이 같은 문자인지를 비교해서 확인하는 방법도 가능하다.
    }
}
