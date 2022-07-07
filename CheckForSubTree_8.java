import java.util.Queue;
import java.util.LinkedList;

public class CheckForSubTree_8 {
    public static Node demoTreeNodeGiver()
    {
        Node root =new Node(4);
        root.right=new Node(9);
        root.right.left=new Node(140);

        return root;
    }
    public static boolean checkForSubTree(Node root,Node checkRoot)
    {
        if(checkSymetric(root, checkRoot))
            return true;
        if(root==null && checkRoot==null)
            return true;
        if(root==null || checkRoot==null)
            return false;
       

        return checkForSubTree(root.left, checkRoot)||
        checkForSubTree(root.right, checkRoot);

    

    }
    public static boolean checkForSubTreeUsingLevelOrder(Node root,Node checkRoot)
    {
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            Node temp=q.poll();
            if(checkSymetric(temp,checkRoot)){
                return true;
            }
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
        return false;

    }
    public static boolean checkSymetric(Node root,Node checkRoot)
    {
        if(root==null && checkRoot==null)
            return true;
        else if(root==null || checkRoot==null)
            return false;
        
        if(root.data!=checkRoot.data)
            return false;
        return checkSymetric(root.left, checkRoot.left)&& checkSymetric(root.right, checkRoot.right);
        
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
        System.out.println(checkForSubTree(root,demoTreeNodeGiver()));
        System.out.println(checkForSubTreeUsingLevelOrder(root,demoTreeNodeGiver()));
    }
}
