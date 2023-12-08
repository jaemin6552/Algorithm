package basic;

import java.util.Arrays;

//문제 설명
//이 문제에서 두 정수 배열의 대소관계를 다음과 같이 정의합니다.
//두 배열의 길이가 다르다면, 배열의 길이가 긴 쪽이 더 큽니다.
//배열의 길이가 같다면 각 배열에 있는 모든 원소의 합을 비교하여 다르다면 더 큰 쪽이 크고, 같다면 같습니다.
//두 정수 배열 arr1과 arr2가 주어질 때, 위에서 정의한 배열의 대소관계에 대하여 arr2가 크다면 -1,
//arr1이 크다면 1, 두 배열이 같다면 0을 return 하는 solution 함수를 작성해 주세요.
public class 배열비교하기 {
    public int solution(int[] arr1, int[] arr2) {
        return arr1.length > arr2.length ?
                1 : arr1.length < arr2.length ?
                -1 : Integer.compare(Arrays.stream(arr1).sum(), Arrays.stream(arr2).sum());
    }
    //길이비교후에 삼항연산자 안에 삼항연산자를 넣어서 클경우 작을경우 같을경우에 대해 처리해줬다.
}
