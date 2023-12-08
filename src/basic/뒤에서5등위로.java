package basic;

import java.util.Arrays;

//문제 설명
//정수로 이루어진 리스트 num_list가 주어집니다.
// num_list에서 가장 작은 5개의 수를 제외한 수들을 오름차순으로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
public class 뒤에서5등위로 {
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);
        return Arrays.copyOfRange(num_list,5,num_list.length);
    }
    //오름차순으로 정렬해서 0~4번째 인덱스를 버리고 나머지를 반환하도록하였다.
}
