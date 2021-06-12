package com.data;

import com.data.structure.Tree.BinaryTree.*;
import java.util.Iterator;

public class App {

    public static void main(String args[]) {
        BinaryTree<String> tree = new BinaryTree<>();
        tree.add("A");
        tree.add("B");
        Iterator<String> iter = tree.traverse(TreeTraversalOrderEnum.PRE_ORDER);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
