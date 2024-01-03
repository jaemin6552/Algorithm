class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i =0; i<skill_trees.length; i++){
            boolean isTrue = true;
            for(int j =0; j<skill.length()-1; j++){
                    String alpa1 = ""+skill.charAt(j);
                    String alpa2 = ""+skill.charAt(j+1);
                    int cur = skill_trees[i].indexOf(alpa1);
                    int next = skill_trees[i].indexOf(alpa2);
                    if((next != -1 && cur >= next) || (cur==-1 && next != -1)) {
                        isTrue = false;
                        break;
                    }
            }
            if(isTrue)answer++;
        }
        return answer;
    }
}