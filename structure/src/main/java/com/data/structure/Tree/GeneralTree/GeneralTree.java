package com.data.structure.Tree.GeneralTree;

import java.util.ArrayList;

public class GeneralTree<T> implements IGeneralTree<T> {
    private GeneralTreeNode<T> root;

    /**
     * Initialize a tree with the specified root node.
     *
     * @param root The root node of the tree
     */
    public GeneralTree(GeneralTreeNode<T> root) {
        this.root = root;
    }

    /**
     * Checks if the tree is empty (root node is null)
     *
     * @return <code>true</code> if the tree is empty, <code>false</code> otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Get the root node of the tree
     *
     * @return the root node.
     */
    public GeneralTreeNode<T> getRoot() {
        return root;
    }

    /**
     * Set the root node of the tree. Replaces existing root node.
     *
     * @param root The root node to replace the existing root node with.
     */
    public void setRoot(GeneralTreeNode<T> root) {
        this.root = root;
    }

    public boolean exists(T key) {
        return find(root, key);
    }

    public void addChild(T parentKey, T childKey) {
        GeneralTreeNode<T> newNode = new GeneralTreeNode<T>(childKey);
        GeneralTreeNode<T> foundNode = findNode(root, parentKey);
        foundNode.getChildren().add(newNode);
    }

    public void addChildAt(T parentKey, T childKey, int index) {
        GeneralTreeNode<T> newNode = new GeneralTreeNode<T>(childKey);
        GeneralTreeNode<T> foundNode = findNode(root, parentKey);
        foundNode.getChildren().add(index, newNode);
    }

    private boolean find(GeneralTreeNode<T> node, T keyNode) {
        boolean res = false;
        if (node.getData().equals(keyNode))
            return true;

        else {
            for (GeneralTreeNode<T> child : node.getChildren())
                if (find(child, keyNode))
                    res = true;
        }

        return res;
    }

    /**
     * Get the number of nodes (size) in the tree.
     *
     * @return The number of nodes in the tree
     */
    public int size() {
        return getNumberOfDescendants(root) + 1;
    }

    public int getNumberOfDescendants(GeneralTreeNode<T> node) {
        int n = node.getChildren().size();
        for (GeneralTreeNode<T> child : node.getChildren())
            n += getNumberOfDescendants(child);

        return n;

    }

    private GeneralTreeNode<T> findNode(GeneralTreeNode<T> node, T keyNode) {
        if (node == null)
            return null;
        if (node.getData().equals(keyNode))
            return node;
        else {
            GeneralTreeNode<T> cnode = null;
            for (GeneralTreeNode<T> child : node.getChildren())
                if ((cnode = findNode(child, keyNode)) != null)
                    return cnode;
        }
        return null;
    }

    public ArrayList<GeneralTreeNode<T>> getPreOrderTraversal() {
        ArrayList<GeneralTreeNode<T>> preOrder = new ArrayList<GeneralTreeNode<T>>();
        buildPreOrder(root, preOrder);
        return preOrder;
    }

    private void buildPreOrder(GeneralTreeNode<T> node, ArrayList<GeneralTreeNode<T>> preOrder) {
        preOrder.add(node);
        for (GeneralTreeNode<T> child : node.getChildren()) {
            buildPreOrder(child, preOrder);
        }
    }

    /**
     *
     * Get the list of nodes arranged by the post-order traversal of the tree.
     *
     * @return The list of nodes in the tree, arranged in the post-order
     */
    public ArrayList<GeneralTreeNode<T>> getPostOrderTraversal() {
        ArrayList<GeneralTreeNode<T>> postOrder = new ArrayList<GeneralTreeNode<T>>();
        buildPostOrder(root, postOrder);
        return postOrder;
    }

    private void buildPostOrder(GeneralTreeNode<T> node, ArrayList<GeneralTreeNode<T>> postOrder) {
        for (GeneralTreeNode<T> child : node.getChildren()) {
            buildPostOrder(child, postOrder);
        }
        postOrder.add(node);
    }

    /**
     *
     * Get the list of nodes arranged by the post-order traversal of the tree.
     *
     * @return The list of nodes in the tree, arranged in the post-order
     */
    public ArrayList<GeneralTreeNode<T>> getInOrderTraversal() {
        ArrayList<GeneralTreeNode<T>> inOrder = new ArrayList<GeneralTreeNode<T>>();
        buildInOrder(root, inOrder, root, false);
        return inOrder;
    }

    private void buildInOrder(GeneralTreeNode<T> node, ArrayList<GeneralTreeNode<T>> inOrder,
            GeneralTreeNode<T> parentNode, boolean addPrant) {
        for (int i = 0; i < node.getChildren().size(); i++) {
            buildInOrder(node.getChildren().get(i), inOrder, node, (i == 1));
        }
        inOrder.add(node);
        if (addPrant) {
            inOrder.add(parentNode);
        }
    }

}
