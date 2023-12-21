class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        hand = hand.toUpperCase().substring(0,1);
        int [][]pos = {{3,1},{0,0},{0,1},{0,2},
                       {1,0},{1,1},{1,2},
                       {2,0},{2,1},{2,2},
                       {3,0},{3,2}};
        int []left = pos[10];
        int []right = pos[11];
        for(int i =0; i<numbers.length; i++){
            switch(numbers[i]){
                case 1 : case 4 : case 7 : {
                    answer+="L";
                    left = pos[numbers[i]];
                    break;
                }
                case 3 : case 6: case 9 :  {   
                    answer+="R";
                    right = pos[numbers[i]];
                    break;
                }
                default : {
                        if(Math.abs(pos[numbers[i]][0] - left[0]) + 
                           Math.abs(pos[numbers[i]][1] - left[1]) <
                           Math.abs(pos[numbers[i]][0] - right[0]) + 
                           Math.abs(pos[numbers[i]][1] - right[1])) {
                             answer+= "L";
                             left = pos[numbers[i]];    
                        }
                        else if(Math.abs(pos[numbers[i]][0] - left[0]) + 
                           Math.abs(pos[numbers[i]][1] - left[1]) ==
                           Math.abs(pos[numbers[i]][0] - right[0]) + 
                           Math.abs(pos[numbers[i]][1] - right[1])) {
                            answer+=hand;
                            switch(hand){
                                case "R" :
                                    right = pos[numbers[i]];
                                    break;
                                case "L" :
                                    left = pos[numbers[i]];
                                    break;
                            }
                        }
                    else{
                        answer+="R";
                        right = pos[numbers[i]];
                    }
                    break;
                }
            }
        }
        return answer;
    }
}