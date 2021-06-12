package com.data;

import com.data.structure.Tree.GeneralTree.*;

public class App {

    public static void main(String args[]) {
        GeneralTreeNode<Integer> rootNode = new GeneralTreeNode<Integer>(1);
        GeneralTree<Integer> generalTree = new GeneralTree<Integer>(rootNode);
        generalTree.addChild(1, 2);
        generalTree.addChild(1, 3);
        generalTree.addChild(2, 4);
        generalTree.addChild(2, 5);
        generalTree.addChild(2, 6);
        generalTree.addChild(4, 7);
        generalTree.addChild(4, 8);
        generalTree.addChild(4, 9);
        generalTree.addChild(7, 10);
        generalTree.addChild(7, 11);
        // System.out.println(generalTree.getPreOrderTraversal());
        // System.out.println(generalTree.getPostOrderTraversal());
        System.out.println(generalTree.getInOrderTraversal());
    }
}
