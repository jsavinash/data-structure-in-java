package com.data.structure.LinkedList.DoublyLinkedList;

public class DoublyLinkedListNode<T> {
    public T data;
    public DoublyLinkedListNode<T> prev, next;

    public DoublyLinkedListNode(T data, DoublyLinkedListNode<T> prev, DoublyLinkedListNode<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
