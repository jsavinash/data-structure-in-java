package com.data.structure.LinkedList.CircularLinkedList;

public class CircularLinkedListNode<T> {
    private T data;
    private CircularLinkedListNode<T> prev, next;

    public CircularLinkedListNode(T data, CircularLinkedListNode<T> prev, CircularLinkedListNode<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
