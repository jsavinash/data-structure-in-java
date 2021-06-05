package com.data.structure.LinkedList.SinglyLinkedList;

public class SinglyLinkedListNode<T> {
    private T data;
    private SinglyLinkedListNode<T> next;

    public SinglyLinkedListNode(T data, SinglyLinkedListNode<T> prev, SinglyLinkedListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
