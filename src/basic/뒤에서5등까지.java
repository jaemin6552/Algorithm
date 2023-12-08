package basic;

import java.util.Arrays;

//문제 설명
//정수로 이루어진 리스트 num_list가 주어집니다.
//num_list에서 가장 작은 5개의 수를 오름차순으로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
public class 뒤에서5등까지 {
    public int[] solution(int[] num_list) {
//        Arrays.sort(num_list);
//        int []answer = Arrays.copyOfRange(num_list,0,5);
//        return answer;
        return Arrays.stream(num_list)
                .sorted()
                .limit(5)
                .toArray();
    }
    //주석친것처럼 정렬해서 5개만큼 잘라서 반환하는 방법과 스트림을 사용한 방법이 가능하다.
}
