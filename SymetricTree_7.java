 //  class Node  {
    //     int data;
    //     Node left=null;
    //     Node right=null;
    //     Node(int data)
    //     {
    //         this.data=data;
    //     }
    // }
public class SymetricTree_7 {
    public static Node demoTreeNodeGiver()
    {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);;
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        root.right.right.right=new Node(1190);//Changed tree to check weather they are similar or not
        root.left.left.right=new Node(9);
        root.left.left.right.left=new Node(10);


                    //         1
                    //     /       \
                    //    2         3
                    //  /   \      /  \
                    // 4    5     6    7
                //     \                \
                //      9                 1190
                //     /
                //    10
        return root;
    }

    public static boolean symetricOrNot(Node root1,Node root2)
    {
            if(root1==null && root2==null)
                return true;
            else if(root1==null ||root2==null)
                return false;
            
            if(root1.data!=root2.data)
            {
                System.out.println("Different element found at :");
                System.out.println(root1.data);
                System.out.println(root2.data);
                return false;
            }
                return symetricOrNot(root1.left, root2.left) && symetricOrNot(root1.right, root2.right);
           
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
        Node root2=demoTreeNodeGiver();
        System.out.println(symetricOrNot(root, root2));
    }
}
