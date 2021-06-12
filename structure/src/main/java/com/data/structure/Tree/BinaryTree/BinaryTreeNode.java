package com.data.structure.Tree.BinaryTree;

/**
 * A class of binary tree node.
 *
 * @param <T> The class type of the binary node.
 */
public class BinaryTreeNode<T> implements IBinaryTreeNode<T> {
    private T data;
    private BinaryTreeNode<T> left, right;

    BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTreeNode<T> getLeftNode() {
        return left;
    }

    public void setLeftNode(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRightNode() {
        return right;
    }

    public void setRightNode(BinaryTreeNode<T> right) {
        this.right = right;
    }
}