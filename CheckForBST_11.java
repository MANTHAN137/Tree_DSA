

public class CheckForBST_11
{
    //Function to check whether a Binary Tree is BST or not.
    static boolean binarySearch(Node root,int minValue,int maxValue){
        if(root==null)
            return true;
       
        if(root.data<minValue || root.data>maxValue)
            return false;
        
        return binarySearch(root.left,minValue,(root.data-1)) && binarySearch(root.right,(root.data+1),maxValue);
    }

    static boolean isBST(Node root)
    {
        if(root==null)
        return false;
    
        return binarySearch(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
       
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
        System.out.println(isBST(root));
    }
}