package basic;

import java.util.Arrays;

//문제 설명
//정수 리스트 num_list가 주어질 때,
// 마지막 원소가 그전 원소보다 크면 마지막 원소에서 그전 원소를 뺀 값을 마지막 원소가 그전 원소보다 크지 않다면 마지막 원소를
// 두 배한 값을 추가하여 return하도록 solution 함수를 완성해주세요.
public class 마지막두원소 {
    public int[] solution(int[] num_list) {
        int size = num_list.length;
        int[] answer;
        answer = Arrays.copyOfRange(num_list,0,size+1);
        answer[size] = answer[size-1] > answer[size-2] ?
                answer[size-1] - answer[size-2] : answer[size-1]*2;
        return answer;
    }
    //원본배열을 통째로 복사해오면서 크기만 1칸 늘려서 삼항연산자를 통해 비교하였다. 더좋은방법을 찾아보자.
}
