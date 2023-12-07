package basic;

import java.util.ArrayList;
import java.util.List;

//문제 설명
//정수 배열 arr과 delete_list가 있습니다.
// arr의 원소 중 delete_list의 원소를 모두 삭제하고 남은 원소들은 기존의 arr에 있던 순서를 유지한 배열을 return 하는 solution 함수를 작성해 주세요.
public class 배열의원소삭제하기 {
    public int[] solution(int[] arr, int[] delete_list) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for(int i =0; i<arr.length; i++){
            for (int k : delete_list) {
                if (arr[i] == k) arr[i] = 0;
            }
            if(arr[i] != 0) list.add(arr[i]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
        //리스트를 배열로 바꾸는 방식을 사용했다 더좋은 방법이 아마도 있다고 생각한다??
    }
}
