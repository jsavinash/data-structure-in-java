package com.data.structure.Tree.BinaryTree;

/**
 * A class of binary tree.
 *
 * @param <T> The class type of the binary tree.
 */
public class BinaryTree<T extends Comparable<T>> implements IBinaryTree<T> {
    private int nodeCount = 0;

    BinaryTreeNode<T> root;

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    // Check if this binary tree is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    // Get the number of nodes in this binary tree
    public int size() {
        return nodeCount;
    }

    void setRoot(T data) {
        root = new BinaryTreeNode<T>(data);
    }

    // Add an element to this binary tree. Returns true
    // if we successfully perform an insertion
    public boolean add(T elem) {

        // Check if the value already exists in this
        // binary tree, if it does ignore adding it
        if (contains(elem)) {
            return false;

            // Otherwise add this element to the binary tree
        } else {
            root = add(root, elem);
            nodeCount++;
            return true;
        }
    }

    private BinaryTreeNode<T> add(BinaryTreeNode<T> node, T data) {
        if (node == null) {
            node = new BinaryTreeNode<T>(data, null, null);
        } else {
            if (node.getLeftNode() == null) {
                BinaryTreeNode<T> newNode = add(root.getLeftNode(), data);
                node.setLeftNode(newNode);
            } else if (node.getRightNode() == null) {
                BinaryTreeNode<T> newNode = add(root.getRightNode(), data);
                node.setRightNode(newNode);
            }
        }

        return node;
    }

    // returns true is the element exists in the tree
    public boolean contains(T elem) {
        return contains(root, elem);
    }

    // private recursive method to find an element in the tree
    private boolean contains(BinaryTreeNode<T> node, T elem) {

        // Base case: reached bottom, value not found
        if (node == null)
            return false;

        int cmp = elem.compareTo(node.getData());

        // Dig into the left subtree because the value we're
        // looking for is smaller than the current value
        if (cmp < 0)
            return contains(node.getLeftNode(), elem);

        // Dig into the right subtree because the value we're
        // looking for is greater than the current value
        else if (cmp > 0)
            return contains(node.getRightNode(), elem);

        // We found the value we were looking for
        else
            return true;
    }

    public java.util.Iterator<T> traverse(TreeTraversalOrderEnum order) {
        switch (order) {
            case PRE_ORDER:
                return preOrderTraversal();
            default:
                return null;
        }
    }

    private java.util.Iterator<T> preOrderTraversal() {
        final int expectedNodeCount = nodeCount;
        final java.util.Stack<BinaryTreeNode<T>> stack = new java.util.Stack<>();
        stack.push(root);

        return new java.util.Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (expectedNodeCount != nodeCount)
                    throw new java.util.ConcurrentModificationException();
                return root != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if (expectedNodeCount != nodeCount)
                    throw new java.util.ConcurrentModificationException();
                BinaryTreeNode<T> node = stack.pop();
                if (node.getLeftNode() != null)
                    stack.push(node.getLeftNode());
                if (node.getRightNode() != null)
                    stack.push(node.getRightNode());
                return node.getData();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
