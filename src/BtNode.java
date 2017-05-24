/**
 * Created by pradeepkumar.v on 05/02/17.
 */
public class BtNode {
    int key;
    BtNode left, right;

    public BtNode(int item)
    {
        key = item;
        left = right = null;
    }
}


class BinaryTree{
    BtNode root;

    BinaryTree(int key){
        root = new BtNode(key);
    }

    BinaryTree(){
        root = null;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new BtNode(1);
        tree.root.left = new BtNode(2);
        tree.root.right = new BtNode(3);
        tree.root.left.left = new BtNode(4);
        tree.root.left.right = new BtNode(5);
        tree.root.right.left = new BtNode(6);
        tree.root.right.right = new BtNode(7);


    }
}
