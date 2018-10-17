package datastructure;

import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);

        BinaryTree binaryTree = new BinaryTree(root);

        root.setLeftChild(new TreeNode(2));
        root.setRightChild(new TreeNode(3));
        root.getLeftChild().setLeftChild(new TreeNode(4));
        root.getLeftChild().setRightChild(new TreeNode(5));

        root.getRightChild().setLeftChild(new TreeNode(6));
        root.getRightChild().setRightChild(new TreeNode(7));

        //binaryTree.printTreeVertically();
        binaryTree.preOrderTraverse(root);
        //binaryTree.inOrderTraverse(root);
        return;
    }

}