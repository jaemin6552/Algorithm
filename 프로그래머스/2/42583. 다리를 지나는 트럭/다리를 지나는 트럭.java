import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int idx = 0;
        int totalWeight = 0;
        Queue<Truck>truck = new LinkedList<>();
        while(idx < truck_weights.length || !truck.isEmpty()){
            if(!truck.isEmpty() && answer - truck.peek().time >= bridge_length){
                totalWeight -= truck.remove().weight;
            }
            if(idx < truck_weights.length && totalWeight+truck_weights[idx]<= weight){
             
                truck.add(new Truck(answer,truck_weights[idx]));
                totalWeight+= truck_weights[idx++];
            }
            answer++;
        }
        return answer;
    }
}
class Truck{
    int time;
    int weight;
    public Truck(int time,int weight){
        this.time =time;
        this.weight = weight;
    }
}