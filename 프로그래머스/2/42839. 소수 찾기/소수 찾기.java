import java.util.*;
class Solution {
    HashSet<Integer>set;
    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();   
        dfs(numbers,0,0,new boolean[numbers.length()]);
        
        return set.size();
    }
    public void dfs(String numbers,int start,int num,boolean []visited){
        if(isPrime(num)) set.add(num);
        for(int i =0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i]= true;
                int newNum=num*10+(numbers.charAt(i)-'0');
                dfs(numbers,i+1,newNum,visited);
                visited[i] = false;
            }
        }
    }
    public boolean isPrime(int a){
        for(int i =2; i*i<=a; i++){
            if(a%i == 0) return false;
        }
        return a > 1 ? true : false;
    }
}