package com.data.structure.Tree.BinaryTree;

/**
 * A interface of binary tree node.
 *
 * @param <T> The type of the binary tree node interface.
 */
public interface IBinaryTreeNode<T> {
    T getData();

    void setData(T data);

    BinaryTreeNode<T> getLeftNode();

    BinaryTreeNode<T> getRightNode();

    void setLeftNode(BinaryTreeNode<T> left);

    void setRightNode(BinaryTreeNode<T> right);
}
