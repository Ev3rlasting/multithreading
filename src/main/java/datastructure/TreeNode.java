package datastructure;

class TreeNode {
    private Object value;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public Object getValue() {
        return this.value;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode getLeftChild() {
        return this.leftChild;
    }

    public TreeNode getRightChild() {
        return this.rightChild;
    }

    public TreeNode(Object value) {
        this.value = value;
    }
}
