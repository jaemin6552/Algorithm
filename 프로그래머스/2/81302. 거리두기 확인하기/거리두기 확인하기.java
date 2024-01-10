import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer,1);
        for(int k = 0; k<places.length; k++){
            String []place = places[k];
            for(int i =0; i<place.length; i++){
                for(int j =0; j<place[i].length(); j++){
                    if(place[i].charAt(j) == 'P'){
                        if(!isManhattan(j,i,place)) answer[k] = 0;
                    }
                }
            }
        }
        return answer;
    }
    public boolean isManhattan(int x,int y,String[] place){
        int [][]pos1 = {{1,0},{-1,0},{0,1},{0,-1}}; //1칸 상하좌우
        for(int i =0; i<4; i++){
            int nx = x+pos1[i][0];
            int ny = y+pos1[i][1];
            if(ny < 0 || ny > place.length-1 || nx < 0 || nx > place[ny].length()-1)
                continue;
            if(place[ny].charAt(nx) == 'P') return false;
        }
        int [][]pos2 = {{2,0},{-2,0},{0,2},{0,-2}}; //2칸 상하좌우
        for(int i =0; i<4; i++){
            int nx = x+pos2[i][0];
            int ny = y+pos2[i][1];
            if(ny < 0 || ny > place.length-1 || nx < 0 || nx > place[ny].length()-1)
                continue;
            if(place[ny].charAt(nx) == 'P' && place[(y+ny)/2].charAt((x+nx)/2) != 'X') return false;
        }
        int [][]pos3 = {{-1,-1},{1,-1},{-1,1},{1,1}}; //대각선
        for(int i =0; i<4; i++){
            int nx = x+pos3[i][0];
            int ny = y+pos3[i][1];
            if(ny < 0 || ny > place.length-1 || nx < 0 || nx > place[ny].length()-1)
                continue;
            if(place[ny].charAt(nx) == 'P' && 
            (place[y].charAt(nx) != 'X' || place[ny].charAt(x) != 'X'))return false;
        }
        return true;
    }
}