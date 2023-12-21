class Solution {
    public String solution(String myString, String pat) {
        int length_idx = myString.lastIndexOf(pat)+pat.length();
        String answer = myString.substring(0,length_idx);
        return answer;
    }
}