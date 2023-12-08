package basic;
import java.util.*;
//문제 설명
//문자열 myString이 주어집니다.
// myString을 문자 "x"를 기준으로 나눴을 때 나눠진 문자열 각각의 길이를 순서대로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
public class x사이의개수 {
    public int[] solution(String myString) {
        List<Integer> list = new ArrayList<>();
        int length = 0;
        for(char ch : myString.toCharArray()){
            if(ch != 'x') length++;
            else {
                list.add(length);
                length = 0;
            }
        }
        list.add(length);
        return list.stream().mapToInt(Integer::intValue).toArray();
        //String타입의 경우는 래퍼클래스라 바로 변환 가능하지만 다른 기본타입들은 래퍼클래스로 바꿔준후 변환가능하기
        //때문에 stream을 사용해서 래퍼클래스에서 기본타입으로 바꿔준후 배열로 변환했다.
    }
}
