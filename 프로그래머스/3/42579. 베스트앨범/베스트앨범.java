import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer>answer = new ArrayList<>();
        HashMap<String,Site>hashmap = new HashMap<>();
        PriorityQueue<Site>orders = new PriorityQueue<>();
        
        for(int i =0; i<genres.length; i++){
            Site site = hashmap.getOrDefault(genres[i],new Site(genres[i],0));
            site.cnt+=plays[i];
            site.pq.add(new Music(i,plays[i]));
            if(site.pq.size() > 2) site.pq.remove();
            hashmap.put(genres[i],site);
        }
        for(String key : hashmap.keySet()) orders.add(hashmap.get(key));
        while(!orders.isEmpty()){
            Site site = orders.remove();
            Stack<Integer>tmp = new Stack<>();
            while(!site.pq.isEmpty()){
                int num = site.pq.remove().num;
                tmp.push(num);
            }
            while(!tmp.isEmpty()) answer.add(tmp.pop());
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
class Music implements Comparable<Music>{
    int num;
    int cnt;
    public Music(int num,int cnt){
        this.num = num;
        this.cnt = cnt;
    }
    @Override
    public int compareTo(Music o){
        if(this.cnt == o.cnt) return o.num-this.num;
        return this.cnt-o.cnt;
    }
}
class Site implements Comparable<Site>{
    String genres;
    int cnt;
    PriorityQueue<Music>pq;
    public Site(String genres,int cnt){
        this.genres = genres;
        this.cnt = cnt;
        this.pq = new PriorityQueue<>();
    }
    @Override
    public int compareTo(Site o){
        return o.cnt - this.cnt;
    }
}