class Solution {
    public int solution(String[] spell, String[] dic) {
        for(String dic_str : dic){
            int cnt = 0;
            for(String spell_str : spell){
                if(dic_str.contains(spell_str)) cnt++;
            }
            if(cnt == spell.length) return 1;
        }
        return 2;
    }
}