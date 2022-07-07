   //  class Node  {
    //     int data;
    //     Node left=null;
    //     Node right=null;
    //     Node(int data)
    //     {
    //         this.data=data;
    //     }
    // }
public class CheckForMirrorTree_9 {

    public static Node demoNodeGiver()
    {
        Node root=new Node(1);
        root.right=new Node(2);
        root.left=new Node(3);
        root.right.right=new Node(4);
        root.right.left=new Node(5);;
        root.left.right=new Node(6);
        root.left.left=new Node(7);
        root.left.left.left=new Node(8);
        root.right.right.left=new Node(9);
        root.right.right.left.right=new Node(10);
        return root;
    }
    
    public static boolean checkMirrorTree(Node root1,Node root2)
    {
        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null)
            return false;
        if(root1.data!=root2.data)
            return false;
        return checkMirrorTree(root1.left, root2.right)&&
        checkMirrorTree(root1.right, root2.left);
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
         System.out.println(checkMirrorTree(root,demoNodeGiver()));
    }
}
