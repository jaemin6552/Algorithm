class Solution {
    public static int solution(int[] arrayA, int[] arrayB) {
        int tmpA = arrayA[0];
        int tmpB = arrayB[0];
        int answer = 0;
        for(int i = 0; i<arrayA.length; i++){
            tmpA = UC(tmpA,arrayA[i]);
        }
        for(int i =0; i<arrayB.length; i++){
            tmpB = UC(tmpB,arrayB[i]);
        }
        for(int i = 0; i<arrayA.length; i++){
            if(arrayA[i] % tmpB ==0) tmpB = 1;
            if( arrayB[i] % tmpA == 0) tmpA = 1;
            answer = tmpA > tmpB ? tmpA : tmpB;
        }
        if(tmpA == 1&& tmpB == 1) return 0;
        return answer;
    }
    public static int UC(int n1,int n2){

        while(n1 % n2 != 0){
            int tmp = n1 % n2;
            n1 = n2;
            n2 = tmp;
        }
        return n2;
    }
}
