import java.util.*;
class Solution {
    int idx;
    int[][] answer;
    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        
        PriorityQueue<Node>pq = new PriorityQueue<>();
        for(int i =0; i<nodeinfo.length; i++){
            pq.add(new Node(i+1,nodeinfo[i]));
        }
        Node root = pq.remove();
        while(!pq.isEmpty()){
            Node child = pq.remove();
            insertChild(root,child);
        }
        System.out.println(root.index);
        idx = 0;
        preorder(root);
        idx = 0;
        postorder(root);
        return answer;
    }
    public void preorder(Node root){
        if(root != null){
            answer[0][idx++] = root.index;
            preorder(root.leftChild);
            preorder(root.rightChild);
        }
    }
    public void postorder(Node root){
         if(root != null){
             postorder(root.leftChild);
             postorder(root.rightChild);
             answer[1][idx++] = root.index;
         }
    }
    public void insertChild(Node parent,Node child){
        if(parent.position[0] > child.position[0]){
            if(parent.leftChild == null) parent.leftChild = child;
            else insertChild(parent.leftChild,child);
        }else{
            if(parent.rightChild == null) parent.rightChild = child;
            else insertChild(parent.rightChild,child);
        }
    }
}
class Node implements Comparable<Node>{
    int index;
    int[] position;
    Node leftChild;
    Node rightChild;
    public Node(int index,int[] position){
        this.index = index;
        this.position = position;
    }
    @Override
    public int compareTo(Node o){
        if(this.position[1] > o.position[1]) return -1;
        else if(this.position[1] < o.position[1]) return 1;
        else return Integer.compare(this.position[0],o.position[0]);
    }
}