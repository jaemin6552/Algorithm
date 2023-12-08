package basic;

//문제 설명
//최대 5명씩 탑승가능한 놀이기구를 타기 위해 줄을 서있는 사람들의 이름이 담긴 문자열 리스트 names가 주어질 때,
// 앞에서 부터 5명씩 묶은 그룹의 가장 앞에 서있는 사람들의 이름을 담은 리스트를 return하도록 solution 함수를 완성해주세요.
// 마지막 그룹이 5명이 되지 않더라도 가장 앞에 있는 사람의 이름을 포함합니다.
public class 다섯명씩 {
    public String[] solution(String[] names) {
        int size = names.length % 5 == 0 ? names.length / 5 : names.length / 5 + 1;
        String[] answer = new String[size];
        int cnt = 0;
        for(int i = 0; i<names.length; i+=5){
            answer[cnt++] = names[i];
        }
        return answer;
    }
    //처음에는 따로 인덱스 카운트를 잡지말고 names[i*]로 표현해보려 했으나 그렇게하면 for문이 쓸대없이 더 돌아가기때문에 방식을
    //바꿔서 cnt변수를 생성해주었다.
}
