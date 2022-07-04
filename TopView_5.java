import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopView_5 {
    static class Node {
        Node left = null;
        Node right = null;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    static class Hybrid {
        int distance;
        Node root;

        Hybrid(int distance, Node root) {
            this.distance = distance;
            this.root = root;
        }
    }
    public static ArrayList<Integer> topView(Node root)
    {
        if(root==null)
            return new ArrayList<>();
        HashMap<Integer,Integer>map=new HashMap<>();

        Queue<Hybrid>q=new LinkedList<>();
        q.add(new Hybrid(0, root));

        while(!q.isEmpty())
        {
            Hybrid temp=q.poll();
            if(!map.containsKey(temp.distance))
            {
                map.put(temp.distance,temp.root.data);
            }
            if(temp.root.left!=null)
            {
                Hybrid durex=new Hybrid(temp.distance-1, temp.root.left);
                q.add(durex);
            }
            if(temp.root.right!=null)
            {
                Hybrid durex=new Hybrid(temp.distance+1, temp.root.right);
                q.add(durex);
            }

        }
        Collection<Integer> values=map.values();
        return new ArrayList<>(values);
    
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
        System.out.println(topView(root));
    }
}
