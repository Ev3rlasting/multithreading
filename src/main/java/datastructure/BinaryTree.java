package datastructure;

public class BinaryTree {
    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public void preOrderTraverse(TreeNode node) {
        if (node == null)
            return;

        System.out.println(node.getValue());

        if (node.getLeftChild() != null) {
            preOrderTraverse(node.getLeftChild());
        }

        if (node.getRightChild() != null) {
            preOrderTraverse(node.getRightChild());
        }
    }

    public void inOrderTraverse(TreeNode node) {
        if (node == null)
            return;

        if (node.getLeftChild() != null) {
            inOrderTraverse(node.getLeftChild());
        }

        System.out.println(node.getValue());
        
        if (node.getRightChild() != null) {
            inOrderTraverse(node.getRightChild());
        }
    }

    public void printTreeVertically() {

    }
}
