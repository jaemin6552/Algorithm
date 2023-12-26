import java.util.*;
class Solution {
    static String []symbols = {"*+-","*-+","+*-","+-*","-*+","-+*"};
    static List<Long>numbers = new ArrayList<>();
    static List<Character>operators = new ArrayList<>();
    public long solution(String expression) {
        String tmp = "";
        for(int i =0; i<expression.length(); i++){
            char c = expression.charAt(i);
            if(c == '-' || c == '+' || c == '*'){
                numbers.add(Long.valueOf(tmp));
                operators.add(c);
                tmp ="";
            }else tmp+=c;
        }
        numbers.add(Long.valueOf(tmp));
        System.out.println(numbers);
        return priority();
    }
    public long priority(){
        long answer = 0;
        for(int i =0; i<symbols.length; i++){
            List<Long>numbersClone = new ArrayList<>(numbers);
            List<Character>operatorsClone = new ArrayList<>(operators);
            for(int j =0; j<symbols[i].length(); j++){
                for(int k =0; k<operatorsClone.size();){
                    if(operatorsClone.get(k) != symbols[i].charAt(j)){
                        k++;
                        continue;
                    }
                    if(operatorsClone.get(k) == symbols[i].charAt(j)){
                        switch(symbols[i].charAt(j)){
                            case '*':
                            numbersClone.set(k,numbersClone.get(k) * numbersClone.get(k+1));
                                break;
                            case '+':
                            numbersClone.set(k,numbersClone.get(k) + numbersClone.get(k+1));
                                break;
                            case '-':
                            numbersClone.set(k,numbersClone.get(k) - numbersClone.get(k+1));
                                break;
                        }
                        operatorsClone.remove(k);
                        numbersClone.remove(k+1);
                    }
                }
            }
           answer = Math.max(Math.abs(numbersClone.get(0)),answer);
       }
       return answer;
    }
}