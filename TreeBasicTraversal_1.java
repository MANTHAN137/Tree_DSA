import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class TreeBasicTraversal_1 {
    
    
    public static void levelorder(Node root)
    {
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            Node temp=q.poll();
            System.out.println(temp.data);
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
            

        }    
    }
    public static void depthfirstSearch(Node root)
    {
        Stack<Node>st=new Stack<>();
        st.add(root);

        while(!st.isEmpty())
        {
            Node temp=st.pop();
            System.out.println(temp.data);
            if(temp.left!=null)
                st.add(temp.right);
            if(temp.right!=null)
                st.add(temp.left);
        }
    }
    public static void sum(Node root)
    {
        Stack<Node>st=new Stack<>();
        st.add(root);
        int sum=0;
        while(!st.isEmpty())
        {
            Node temp=st.pop();
            sum+=temp.data;
            if(temp.left!=null)
                st.add(temp.right);
            if(temp.right!=null)
                st.add(temp.left);
        }
        System.out.println(sum);
    }
   
    static int target=6;
    public static Boolean search(Node root)
    {
        if(root==null)
        return false;

        if(root.data==target)
        return true;
        return search(root.left) || search(root.right);
    }

    public static int heightMax(Node root)
    {
        if(root==null)
            return 0;
        
        int  m=heightMax(root.left)+1;
        int  n=heightMax(root.right)+1;

        return Math.max(m, n);
    }
  


    public static void preorder(Node root)
    {
        if(root==null)
        return ;
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);

    }
    public static void postorder(Node root)
    {
        if(root==null)
        return ;

        preorder(root.left);
        preorder(root.right);

        System.out.println(root.data);

    }
    static class Node{
        Node left=null;
        Node right=null;
        int data;
        Node(int data){
            this.data=data;
        }
    }
    public static Integer diameter;
    public static int TreeDiameter(Node root,int d)
    {
        if(root==null)
            return 0;
        int left=TreeDiameter(root.left,d);
        int right=TreeDiameter(root.right,d);
        d=Math.max(left+right+1,d);
        diameter=d;
        return Math.max(left, right)+1;



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
    
        
            

    }
}
