import java.util.*;
class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        String []binary = new String[numbers.length];
        for(int i = 0; i<numbers.length; i++){
            String tmp = Long.toString(numbers[i],2);
            int length = tmp.length();
            int treeSize = 1;
            int nodeSize = 1;
            while(length > nodeSize) {
                treeSize*=2;
                nodeSize+=treeSize;
            }
            String front="0".repeat(nodeSize-length);
            binary[i] = front+tmp;
        }
        for(int i =0; i<binary.length; i++) answer[i] = dfsDivide(binary[i]) ? 1 : 0;
        
        return answer;
    }
    public boolean dfsDivide(String binary){
        if(binary.length() == 1) return true;
        int middle = binary.length()/2;
        if(binary.charAt(middle) == '0'){
            for(char ch : binary.toCharArray()) if(ch == '1') return false;
            return true;
        }
        String left = binary.substring(0,middle);
        String right = binary.substring(middle+1);
        return dfsDivide(left) && dfsDivide(right);
    }
}