class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i =0; i<skill_trees.length; i++){
            boolean isTrue = true;
            int cur = skill_trees[i].indexOf(skill.charAt(0));
            for(int j =1; j<skill.length(); j++){                   
                    int next = skill_trees[i].indexOf(skill.charAt(j));
                    if((next != -1 && cur >= next) || (cur==-1 && next != -1)) {
                        isTrue = false;
                        break;
                    }
                cur = next;
            }
            if(isTrue)answer++;
        }
        return answer;
    }
}