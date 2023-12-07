package basic;

import java.util.Arrays;

//문제 설명
//정수 리스트 num_list와 정수 n이 주어질 때,
//num_list의 첫 번째 원소부터 n 번째 원소까지의 모든 원소를 담은 리스트를 return하도록 solution 함수를 완성해주세요.
public class n번째원소까지 {
    public int[] solution(int[] num_list, int n) {
        return Arrays.stream(num_list)
                .limit(n)
                .toArray();
    }
    //limit(정수) <<-몇번째까지 선택 ex)1이면 0번째 인덱스까지 선택한것임
    //stream을 사용하지않을경우 Arrays.copyOfRange(num_list,0,n);이것도 가능할것이다.
}
