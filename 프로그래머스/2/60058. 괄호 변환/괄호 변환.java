import java.util.*;
class Solution {
    
    public String solution(String p) {
        StringBuilder answer = new StringBuilder();
        recursion(p,answer);
        return answer.toString();
    }
    public void recursion(String p,StringBuilder answer){
        if (p.isEmpty()) {
            return;
        }
        int left = 0;
        int right = 0;
        StringBuilder u = new StringBuilder();
        String v = "";
        for(int i =0; i<p.length(); i++){
            char ch = p.charAt(i);
            u.append(ch);
            if(ch == '(') left++;
            else right++;
            if(left == right){
                v=p.substring(i+1);
                if(isTrueBracket(u.toString())){
                    answer.append(u.toString());
                    recursion(v,answer);
                } else {
                    answer.append("(");
                    recursion(v,answer);
                    answer.append(")");
                    u.deleteCharAt(0);
                    u.deleteCharAt(u.length() - 1);
                    for(int j =0; j<u.length(); j++){
                        if(u.charAt(j) == '(') answer.append(")");
                        else if(u.charAt(j) == ')') answer.append("(");
                    }
                }
                break;
            }
        }
    }
    public boolean isTrueBracket(String bracket){
        Stack<Character>stack = new Stack<>();
        for(char ch : bracket.toCharArray()){
            if(ch =='(') stack.push(ch);
            else{
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}