package com.data.structure.Tree.GeneralTree;

import java.util.List;
import java.util.ArrayList;

/**
 * A node of any type. A node contains a data and links to it's children and
 * it's parent.
 *
 * @param <T> The class type of the node
 */
public class GeneralTreeNode<T> implements IGeneralTreeNode<T> {
    private T data;
    private List<GeneralTreeNode<T>> children;
    private GeneralTreeNode<T> parent;

    public GeneralTreeNode(T data) {
        this.data = data;
        this.children = new ArrayList<GeneralTreeNode<T>>();
    }

    public GeneralTreeNode(GeneralTreeNode<T> node) {
        this.data = node.getData();
        children = new ArrayList<GeneralTreeNode<T>>();
    }

    /**
     *
     * Add a child to this node.
     *
     * @param child child node
     */
    public void addChild(GeneralTreeNode<T> child) {
        child.setParent(this);
        children.add(child);
    }

    public void addChildAt(int index, GeneralTreeNode<T> child) {
        child.setParent(this);
        this.children.add(index, child);
    }

    public void setChildren(List<GeneralTreeNode<T>> children) {
        for (GeneralTreeNode<T> child : children)
            child.setParent(this);

        this.children = children;
    }

    /**
     * Remove all children of this node.
     */
    public void removeChildren() {
        this.children.clear();
    }

    /**
     *
     * Remove child at given index.
     *
     * @param index The index at which the child has to be removed.
     * @return the removed node.
     */
    public GeneralTreeNode<T> removeChildAt(int index) {
        return children.remove(index);
    }

    public boolean removeChild(GeneralTreeNode<T> childToBeDeleted) {
        List<GeneralTreeNode<T>> list = getChildren();
        return list.remove(childToBeDeleted);
    }

    public List<GeneralTreeNode<T>> getChildren() {
        return this.children;
    }

    public GeneralTreeNode<T> getChildAt(int index) {
        return children.get(index);
    }

    public T getData() {
        return this.data;
    }

    public void setParent(GeneralTreeNode<T> parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj)
            return false;

        if (obj instanceof GeneralTreeNode) {
            if (((GeneralTreeNode<?>) obj).getData().equals(this.data))
                return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}