package com.data.structure.LinkedList.SinglyLinkedList;

public class SinglyLinkedList<T> implements ISinglyLinkedList<T> {
    private int size = 0;
    private SinglyLinkedListNode<T> head = null;
    private SinglyLinkedListNode<T> tail = null;

    // Empty this linked list, O(n)
    public void clear() {
        SinglyLinkedListNode<T> trav = head;
        while (trav != null) {
            SinglyLinkedListNode<T> next = head.next;
            trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    // Return the size of this linked list
    public int size() {
        return size;
    }

    // Is this linked list empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(T elem) {
        addLast(elem);
    }

    public void addLast(T elem) {
        if ((head == null && tail == null)) {
            head = tail = new SinglyLinkedListNode<T>(elem, null);
        } else {
            SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(elem, null);
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    public void addFirst(T elem) {
        if ((head == null && tail == null)) {
            head = tail = new SinglyLinkedListNode<T>(elem, null);
        } else {
            head = new SinglyLinkedListNode<T>(elem, head);
        }
        size++;
    }

    public void addAt(int index, T elem) throws Exception {
        if (index < 0) {
            throw new Exception("Illegal Index");
        }

        if (index == size) {
            addLast(elem);
            return;
        }
        SinglyLinkedListNode<T> temp = head;
        for (int it = 0; it < index - 1; it++) {
            temp = temp.next;
        }
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(elem, temp.next);
        temp.next = newNode;
        size++;
    }

    public T peekFirst() {
        if (isEmpty())
            throw new RuntimeException("Empty list");
        return head.data;
    }

    public T peekLast() {
        if (isEmpty())
            throw new RuntimeException("Empty list");
        return tail.data;
    }

    public T removeFirst() {
        if (isEmpty())
            throw new RuntimeException("Empty list");
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public T removeLast() {
        if (isEmpty())
            throw new RuntimeException("Empty list");
        T data = null;
        if (size == 1) {
            data = head.data;
            removeFirst();
            return data;
        } else {
            SinglyLinkedListNode<T> trav = head;
            for (int it = 1; it <= size; it++) {
                if (it == size - 1) {
                    trav.next = null;
                    data = trav.data;
                } else {
                    trav = trav.next;
                }
            }
        }

        size--;
        return data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        SinglyLinkedListNode<T> trav = head;
        while (trav != null) {
            sb.append(trav.data);
            if (trav.next != null) {
                sb.append(", ");
            }
            trav = trav.next;
        }
        sb.append(" ]");
        System.out.println(sb.toString());
        return sb.toString();
    }
}
