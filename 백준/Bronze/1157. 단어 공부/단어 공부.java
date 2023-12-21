import java.util.Scanner;
public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
    
        String s = sc.next();
        int []arr = new int[26];
        int max = -1;
        char result = '?';
        
        for(int i = 0; i<s.length(); i++) {
            if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') { // 대문자 범위
                arr[s.charAt(i) - 'A']++;	// 해당 인덱스의 값 1 증가
            }
            else {	// 소문자 범위
                arr[s.charAt(i) - 'a']++;
            }
        }
        for(int i = 0; i<26; i++){
            if(arr[i] > max) {
                max = arr[i];
                result = (char)(i + 'A');
            } 
            else if(arr[i] == max){
                result = '?';
            }
        }
        System.out.print(result);
    }
}