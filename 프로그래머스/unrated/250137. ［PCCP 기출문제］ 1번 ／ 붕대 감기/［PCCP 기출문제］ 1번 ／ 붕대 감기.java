class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        final int maxHP = health;
        for(int i =0; i<attacks.length-1; i++){
            health-=attacks[i][1];
            if(health <= 0) return -1;
            int healT = (attacks[i+1][0]-attacks[i][0]-1); 
            health += healT*bandage[1]+(healT/bandage[0])*bandage[2];
            if(health > maxHP) health = maxHP;
        }
        health-=attacks[attacks.length-1][1];    
        
        return health > 0 ? health : -1;
    }
}