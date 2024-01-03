class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i =0; i<skill_trees.length; i++){
            boolean isTrue = true;
            String alpa1 = ""+skill.charAt(0);
            for(int j =1; j<skill.length(); j++){                   
                    String alpa2 = ""+skill.charAt(j);
                    int cur = skill_trees[i].indexOf(alpa1);
                    int next = skill_trees[i].indexOf(alpa2);
                    if((next != -1 && cur >= next) || (cur==-1 && next != -1)) {
                        isTrue = false;
                        break;
                    }
                alpa1 = alpa2;
            }
            if(isTrue)answer++;
        }
        return answer;
    }
}