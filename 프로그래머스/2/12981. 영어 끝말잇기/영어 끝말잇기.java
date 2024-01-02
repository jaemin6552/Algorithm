import java.util.HashSet;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String>hashSet = new HashSet<>();
        String lastWord = ""+words[0].charAt(0);
        for(int i =0; i<words.length; i++){   
            if(i > 0) lastWord = words[i-1];
            if(!hashSet.add(words[i]) || lastWord.charAt(lastWord.length()-1) !=words[i].charAt(0)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
               
        return answer;
    }
}