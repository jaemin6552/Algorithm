import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        LinkedList<Integer>list = new LinkedList<>();
        for(String str : operations){
            String []tmp = str.split(" ");
            switch(tmp[0]){
                case "I":
                    list.add(Integer.valueOf(tmp[1]));
                    Collections.sort(list);
                    System.out.println(list);
                    break;
                case "D":
                    if(list.isEmpty()) break;
                    if(tmp[1].equals("-1"))
                        list.removeFirst();
                    else list.removeLast();
                    System.out.println(list);
                    break;
            }
        }
        if(list.isEmpty()) return new int[]{0,0};
        return new int[]{list.getLast(),list.getFirst()};
    }
}