package basic;

//문제 설명
//문자열 binomial이 매개변수로 주어집니다. binomial은 "a op b" 형태의 이항식이고 a와 b는 음이 아닌 정수,
//op는 '+', '-', '*' 중 하나입니다. 주어진 식을 계산한 정수를 return 하는 solution 함수를 작성해 주세요.
public class 간단한식계산하기 {
    public int solution(String binomial) {
        String []st = binomial.split(" ");
        switch (st[1]){
            case "+": return Integer.parseInt(st[0])+Integer.parseInt(st[2]);
            case "-":return Integer.parseInt(st[0])-Integer.parseInt(st[2]);
            case "*": return Integer.parseInt(st[0])*Integer.parseInt(st[2]);
        }
        return 0;
    }
}
