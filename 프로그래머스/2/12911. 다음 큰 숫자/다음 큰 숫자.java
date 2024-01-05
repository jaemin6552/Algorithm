class Solution {
    public int solution(int n) {
        int answer = 0;
        String tmp = Integer.toString(n,2);
        int cnt = 0;
        int idx = 1;
        for(char ch : tmp.toCharArray()) cnt += ch == '1' ? 1 : 0;
        for(int i =n+1; i<1000000; i++){
            String score = Integer.toString(i,2);
            int cnt_clone = cnt;
             for(char ch : score.toCharArray()) cnt_clone -= ch == '1' ? 1 : 0;
            if(cnt_clone == 0) return i;
        }
        return -1;
    }
}