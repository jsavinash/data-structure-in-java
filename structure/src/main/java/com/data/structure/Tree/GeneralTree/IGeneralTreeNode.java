package com.data.structure.Tree.GeneralTree;

import java.util.List;

public interface IGeneralTreeNode<T> {

    public void addChild(GeneralTreeNode<T> child);

    public void addChildAt(int index, GeneralTreeNode<T> child);

    public void setChildren(List<GeneralTreeNode<T>> children);

    public void removeChildren();

    public GeneralTreeNode<T> removeChildAt(int index);

    public boolean removeChild(GeneralTreeNode<T> childToBeDeleted);

    public List<GeneralTreeNode<T>> getChildren();

    public GeneralTreeNode<T> getChildAt(int index);
}
