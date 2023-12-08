package basic;
//문제 설명
//영어 알파벳으로 이루어진 문자열 str이 주어집니다. 각 알파벳을 대문자는 소문자로 소문자는 대문자로 변환해서 출력하는 코드를 작성해 보세요.

import java.util.Scanner;

public class 대소문자바꿔서출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String tmp = "";
        for(char ch : a.toCharArray()){
            tmp += (ch >= 'a' && ch <= 'z') ?
                    Character.toUpperCase(ch) : Character.toLowerCase(ch);
        }
        System.out.println(tmp);
    }
}
