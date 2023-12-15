class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int attIdx = 0;
        final int maxHP = health;
        int healCnt = 0;
        for(int i =1; i<=attacks[attacks.length-1][0]; i++){
            if(i == attacks[attIdx][0]) {
                health-= attacks[attIdx++][1];
                if(health <= 0) return -1;
                healCnt = 0;
            } else{
                 healCnt++;
                if(health < maxHP) {
                    health+=bandage[1];
                    if(healCnt == bandage[0]) {
                        health+=bandage[2];
                        healCnt = 0;
                    }
                    if(health > maxHP) health = maxHP;
                }
            }
            
        }
        return health;
    }
}