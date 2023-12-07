package basic;
//문제 설명
//연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다. 예를 들면 다음과 같습니다.
//
//12 ⊕ 3 = 123
//3 ⊕ 12 = 312
//양의 정수 a와 b가 주어졌을 때, a ⊕ b와 b ⊕ a 중 더 큰 값을 return 하는 solution 함수를 완성해 주세요.
//
//단, a ⊕ b와 b ⊕ a가 같다면 a ⊕ b를 return 합니다.
public class 더크게합치기 {
    public int solution(int a, int b) {
        String tmpA = a+String.valueOf(b);
        String tmpB = b+String.valueOf(a);
        int sumA = Integer.parseInt(tmpA);
        int sumB = Integer.parseInt(tmpB);

        return Math.max(sumA, sumB);
    }
    //기본적으로 자바에서 문자열+숫자는 문자열연산으로 취급하기때문에 가능한방식이다.
}
