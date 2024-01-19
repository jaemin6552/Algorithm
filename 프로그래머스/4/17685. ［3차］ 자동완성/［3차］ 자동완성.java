import java.util.*;
class Solution {
    public int solution(String[] words) {
        int answer = 0;
        Arrays.sort(words);
        for(int i =0; i<words.length; i++){
            int cnt = 0;
            int next = i+1;
            int prev = i-1;
            int max = 0;
            if(prev >= 0 && words[prev].contains(words[i])) cnt=words[prev].length()+1;                     else if(prev >= 0){
                StringBuilder sb = new StringBuilder();
                for(int j =0; j<words[i].length(); j++){
                    sb.append(words[i].charAt(j));
                    if(!words[prev].startsWith(sb.toString())){
                        max=Math.max(max,j+1);
                        break;
                    }
                }
            }
            if(next <= words.length-1 && words[next].contains(words[i]))cnt=words[i].length();
            else if(next <= words.length-1){
                StringBuilder sb = new StringBuilder();
                for(int j =0; j<words[i].length(); j++){
                    sb.append(words[i].charAt(j));
                    if(!words[next].startsWith(sb.toString())){
                        max=Math.max(max,j+1);
                        break;
                    }
                }
            }
            if(cnt == 0) answer+=max;
            else answer+=cnt;
        }
        
        return answer;
    }
}