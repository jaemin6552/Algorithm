package basic;

//문제 설명
//정수가 담긴 리스트 num_list가 주어질 때, 모든 원소들의 곱이 모든 원소들의 합의 제곱보다 작으면 1을 크면 0을 return하도록 solution 함수를 완성해주세요.
public class 원소들의곱과합 {
    public int solution(int[] num_list) {
        int sum = 0;
        int multi = 1;
        for (int n : num_list) {
            sum += n;
            multi *= n;
        }

        return sum * sum > multi ? 1 : 0;
    }
}
