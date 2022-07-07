import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
 //  class Node  {
    //     int data;
    //     Node left=null;
    //     Node right=null;
    //     Node(int data)
    //     {
    //         this.data=data;
    //     }
    // }
public class InvertTree_6 {
    

    public static Node invertTreeUsingRecursion(Node root)
    {
        if(root==null)
            return null;
        
        Node temp=root.left;
        root.left=root.right;
        root.right=temp;
        if(root.left!=null)
        invertTreeUsingRecursion(root.left);

        if(root.right!=null)
        invertTreeUsingRecursion(root.right);
        
        return root;
        
    }
    public static ArrayList<Integer> printInvertTree(Node root)
    {
        if(root==null)
            return new ArrayList<>();
        ArrayList<Integer>ar=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            Node x=q.poll();
            ar.add(x.data);
            if(x.right!=null)
                q.add(x.right);
            if(x.left!=null)
                q.add(x.left);
        }
        return ar;
}
public static Node invertTree(Node root)
    {
        if(root==null)
            return null;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            Node x=q.poll();
            Node temp=x.left;
            x.left=x.right;
            x.right=temp;
            if(x.left!=null)
                q.add(x.left);
            if(x.right!=null)
                q.add(x.right);
            
        }
        return root;
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
                //     \                \
                //      9                 8
                //     /
                //    10
        System.out.println(printInvertTree(root));
        Node x=invertTreeUsingRecursion(root);
        System.out.println(x.left.left.data);
        Node y=invertTree(root);
        System.out.println(y.left.left.data);
    }


}
