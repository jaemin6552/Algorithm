package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//문제 설명
//문자열 myString이 주어집니다. "x"를 기준으로 해당 문자열을 잘라내 배열을 만든 후 사전순으로 정렬한 배열을 return 하는 solution 함수를 완성해 주세요.
//단, 빈 문자열은 반환할 배열에 넣지 않습니다.
public class 문자열잘라서정렬하기 {
    public static String[] solution(String myString) {
        String[] tmp = myString.split("x+");
        Arrays.sort(tmp);
        List<String> result = new ArrayList<>();
        for (String s : tmp) {
            if (!s.isEmpty()) result.add(s);
        }
        return result.toArray(new String[0]);
    }
    //trim의 경우 String문자열 타입에만 사용가능 하기때문에 xx가 연속된 경우 빈배열이 발생하기때문에 그것을 따로 제어해야함.
}
