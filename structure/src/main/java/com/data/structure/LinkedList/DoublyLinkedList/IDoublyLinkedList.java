package com.data.structure.LinkedList.DoublyLinkedList;

import com.data.structure.LinkedList.SinglyLinkedList.SinglyLinkedListNode;

interface IDoublyLinkedList<T> {
    int size = 0;
    Object head = null;
    Object tail = null;

    public void clear();

    int size();

    boolean isEmpty();

    void add(T elem);

    void addLast(T elem);

    void addFirst(T elem);

    void addAt(int index, T data) throws Exception;

    T peekFirst();

    T peekLast();

    T removeFirst();

    T removeLast();

    T removeAt(int index);

    boolean remove(Object obj);

    int indexOf(Object obj);

    public String toString();
}