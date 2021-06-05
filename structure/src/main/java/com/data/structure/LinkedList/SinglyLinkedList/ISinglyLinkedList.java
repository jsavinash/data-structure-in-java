package com.data.structure.LinkedList.SinglyLinkedList;

interface ISinglyLinkedList<T> {
    int size = 0;
    Object head = null;

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

    // T removeAt(int index);

    // boolean remove(Object obj);

    // int indexOf(Object obj);

    // public String toString();
}