class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        answer = a == b && b == c ? (a+b+c) *(a*a+b*b+c*c)*(a*a*a+b*b*b+c*c*c) :
        a == b || b == c || a == c ? (a+b+c) *(a*a+b*b+c*c) : a+b+c;
        return answer;
    }
}
