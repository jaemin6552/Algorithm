package basic;

import java.util.Arrays;

//문제 설명
//정수 리스트 num_list와 정수 n이 주어질 때, n 번째 원소부터 마지막 원소까지의 모든 원소를 담은 리스트를 return하도록 solution 함수를 완성해주세요.
public class n번째원소부터 {
    public int[] solution(int[] num_list, int n) {
        return Arrays.copyOfRange(num_list,n-1,num_list.length);
        //인덱스는 0부터 시작하니까 -1을 넣어줘야한다.
    }
}
