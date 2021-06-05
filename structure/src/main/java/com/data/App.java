package com.data;

import com.data.structure.LinkedList.SinglyLinkedList.*;

public class App {

    public static void main(String args[]) {
        SinglyLinkedList<Number> singlyLinkedListObj = new SinglyLinkedList<Number>();
        singlyLinkedListObj.add(1);
        // singlyLinkedListObj.add(2);
        // singlyLinkedListObj.add(3);
        // singlyLinkedListObj.add(4);
        // singlyLinkedListObj.add(5);

        // System.out.println(singlyLinkedListObj.size());
        singlyLinkedListObj.toString();
        singlyLinkedListObj.removeLast();
        singlyLinkedListObj.toString();
    }
}
