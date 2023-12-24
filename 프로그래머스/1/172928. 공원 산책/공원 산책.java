class Solution {
    public int[] solution(String[] park, String[] routes) {
        int []start = findStartIdx(park);
        for(String str : routes){
            String []tmp = str.split(" ");
                check(start,tmp,park);
            }
        return start;
    }
    public int[] findStartIdx(String[] park){
        int []idx = new int[2];
        for(int i =0; i<park.length; i++){
            if(park[i].contains("S")){
                idx[1]=park[i].indexOf("S");
                idx[0]=i;
            }; 
        }
        return idx;
    }
    public void check(int []start,String []tmp,String []park){
        int []next = start.clone();
        for(int i =0; i<Integer.valueOf(tmp[1]); i++){
            switch(tmp[0]){
                case "E":
                    next[1]++;
                    break;
                case "S":
                    next[0]++;
                    break;
                case "N":
                    next[0]--;
                    break;
                case "W":
                    next[1]--;
                    break;
            }
            if(next[0] < 0 || next[1] < 0 || next[1] > park[0].length()-1 || next[0] > park.length-1 || park[next[0]].charAt(next[1]) == 'X') return;
        }
         start[0] = next[0];
         start[1] = next[1];
    }
}