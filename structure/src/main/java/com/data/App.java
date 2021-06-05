package com.data;

import com.data.structure.LinkedList.DoublyLinkedList.*;

public class App {

    public static void main(String args[]) {
        DoublyLinkedList<Number> doublyLinkedListObj = new DoublyLinkedList<Number>();
        doublyLinkedListObj.add(1);
        doublyLinkedListObj.toString();
        doublyLinkedListObj.add(2);
        doublyLinkedListObj.toString();
        doublyLinkedListObj.add(3);
        doublyLinkedListObj.toString();
        doublyLinkedListObj.add(4);
        doublyLinkedListObj.toString();
        doublyLinkedListObj.add(5);
        doublyLinkedListObj.toString();
        doublyLinkedListObj.add(6);
        doublyLinkedListObj.toString();
        try {
            doublyLinkedListObj.addAt(2, 25);
        } catch (Exception e) {
            System.err.println(e);
        }
        doublyLinkedListObj.toString();
        try {
            doublyLinkedListObj.removeAt(2);
        } catch (Exception e) {
            System.err.println(e);
        }
        doublyLinkedListObj.toString();
    }
}
