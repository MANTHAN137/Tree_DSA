import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class VerticalTraversal_2 {

    static class Node{
        int data;
        Node left=null;
        Node right=null;
        Node(int data)
        {
            this.data=data;
        }
    
    }
    static class Hybrid{
        int distance;
        Node root;

        Hybrid(int distance,Node root)
        {
            this.root=root;
            this.distance=distance;
        }

    }
    public static HashMap<Integer,ArrayList<Integer>> verticalTraversal(Node root){
        HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();
        Queue<Hybrid>q=new LinkedList<>();
        Hybrid h=new Hybrid(0, root);
        q.add(h);
        while(!q.isEmpty()){
            Hybrid temp=q.poll();
            if(!map.containsKey(temp.distance))
            {
            map.put(temp.distance, new ArrayList<>(){
                {
                    add(temp.root.data);
                }
            });
            }else{
                ArrayList<Integer>ar=map.get(temp.distance);
                ar.add(temp.root.data);
                map.put(temp.distance,ar);
            }
            if(temp.root.left!=null)
            {
                Hybrid durex=new Hybrid(temp.distance-1,temp.root.left);
                q.add(durex);
            }
            if(temp.root.right!=null)
            {
                Hybrid durex=new Hybrid(temp.distance+1,temp.root.right);
                q.add(durex);
            }

            
        }

        return map;
    }

    public static void main(String[] args) {
        
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);;
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        root.right.right.right=new Node(8);
        root.left.left.right=new Node(9);
        root.left.left.right.left=new Node(10);


                    //         1
                    //     /       \
                    //    2         3
                    //  /   \      /  \
                    // 4    5     6    7
                //      \                \
                //      9                 8
                //     /
                //    10

        HashMap<Integer,ArrayList<Integer>>hashmap=verticalTraversal(root);
        System.out.println(hashmap.get(-2));
        System.out.println(hashmap.get(-1));
        System.out.println(hashmap.get(0));
        System.out.println(hashmap.get(1));
        System.out.println(hashmap.get(2));
        System.out.println(hashmap.get(3));
    }
}
