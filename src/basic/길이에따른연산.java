package basic;

import java.util.Arrays;

//문제 설명
//정수가 담긴 리스트 num_list가 주어질 때,
//리스트의 길이가 11 이상이면 리스트에 있는 모든 원소의 합을 10 이하이면 모든 원소의 곱을 return하도록 solution 함수를 완성해주세요.
public class 길이에따른연산 {
    public int solution(int[] num_list) {
        return num_list.length >= 11 ? Arrays.stream(num_list).sum()
                : Arrays.stream(num_list).reduce(1,(a, b)->a*b);
    }
    //조건을 걸고 조건에 따라서 for문으로 모든 원소를 더해주거나 곱하는법도 있지만 스트림을 사용할경우 코드가 극한으로 짧아지는 이점이있다.
    //reduce( 초기값,람다식(어떤연산을할것인지에 관한) );
}
