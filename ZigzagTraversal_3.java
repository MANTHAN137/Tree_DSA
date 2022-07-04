import java.util.ArrayList;
import java.util.Stack;

public class ZigzagTraversal_3 {
    static class Node{
        Node left=null;
        Node right=null;
        int data;
        Node(int data){
            this.data=data;
        }
    }
    public static ArrayList<ArrayList<Integer>> zigzag(Node root)
    {
        Stack<Node> s1=new Stack<>();
        Stack<Node> s2=new Stack<>();
        ArrayList<ArrayList<Integer>>m=new ArrayList<>();
        ArrayList<Integer>ar=new ArrayList<>();

        s1.add(root);
        boolean flag1=true;
        
        while(!s1.isEmpty() || !s2.isEmpty())
        {
            if(!s1.isEmpty() && flag1)
            {
            Node temp=s1.pop();
            ar.add(temp.data);
            
            
            if(temp.right!=null)
            s2.add(temp.right);
            if(temp.left!=null)
            s2.add(temp.left);
            if(s1.isEmpty())
            {
                m.add(ar);
                ar=new ArrayList<>();

            }
            }else{
                flag1=false;
            }
            if(!s2.isEmpty() && !flag1)
            {
                Node temp=s2.pop();
                ar.add(temp.data);
                if(temp.left!=null)
                s1.add(temp.left);
                if(temp.right!=null)
                s1.add(temp.right);
               
                if(s2.isEmpty())
                {
                    m.add(ar);
                    ar=new ArrayList<>();
                }
            }else{
                flag1=true;
            }
        }
        System.out.println(m);
        return m;
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
    
            System.out.println(zigzag(root));
            

    }
}
