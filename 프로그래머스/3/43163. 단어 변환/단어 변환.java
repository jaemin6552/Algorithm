import java.util.*;
class Solution {
    static int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        boolean []visited = new boolean[words.length];
        List<String>wordsCheck = Arrays.asList(words);
        if(!wordsCheck.contains(target)) return 0;
        check(begin,target,words,visited,0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    public void check(String begin,String target,String[]words,boolean[]visited,int cnt){
        if(begin.equals(target)) {
            answer = Math.min(answer,cnt);
            return;
        }
        for(int i =0; i<words.length; i++){
            int missmatch = 0;
            for(int j =0; j<words[i].length(); j++){
                if(begin.charAt(j) != words[i].charAt(j)) missmatch++;
            }
            if(missmatch <= 1 && visited[i] == false) {
                visited[i] = true;
                check(words[i],target,words,visited,cnt+1);
                visited[i] = false;
            }
        }
    }
}