class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers,target,0,0);
    }
    public int dfs(int[]numbers,int target,int start,int sum){
        if(start == numbers.length) return sum == target ? 1 : 0;
        int count = 0;
        count+=dfs(numbers,target,start+1,sum+numbers[start]);
        count+=dfs(numbers,target,start+1,sum-numbers[start]);
        
        return count;
    }
}