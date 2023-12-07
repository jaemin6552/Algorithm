package basic;

import java.util.Scanner;

//문제 설명
//두 개의 문자열 str1, str2가 공백으로 구분되어 입력으로 주어집니다.
//입출력 예와 같이 str1과 str2을 이어서 출력하는 코드를 작성해 보세요.
public class 문자열붙여서출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(a.concat(b));
    }
    //a에다가 b를 더하거나 스트링빌더로 append해도 된다.
}
