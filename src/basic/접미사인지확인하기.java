package basic;

//문제 설명
//어떤 문자열에 대해서 접미사는 특정 인덱스부터 시작하는 문자열을 의미합니다.
// 예를 들어, "banana"의 모든 접미사는 "banana", "anana", "nana", "ana", "na", "a"입니다.
//문자열 my_string과 is_suffix가 주어질 때, is_suffix가 my_string의 접미사라면 1을, 아니면 0을 return 하는 solution 함수를 작성해 주세요.
public class 접미사인지확인하기 {
    public int solution(String my_string, String is_suffix) {
        int length = my_string.length()-is_suffix.length();
        if(length < 0 ) return 0;
        String tmp = my_string.substring(length);
        //my_string.endsWith(is_suffix);
        return tmp.equals(is_suffix) ? 1 : 0;
    }
    //처음접근 방식은 두번째인자로 들어온 접미사 길이만큼부터 잘라낸뒤 접미사와 비교하는
    //방식을 사용했는데 endsWith()를 사용해서 간단하게 확인가능하다
}
