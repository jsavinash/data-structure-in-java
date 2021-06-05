package com.data.structure.LinkedList.DoublyLinkedList;

public class DoublyLinkedList<T> implements IDoublyLinkedList<T>, Iterable<T> {
    private int size = 0;
    private DoublyLinkedListNode<T> head = null;
    private DoublyLinkedListNode<T> tail = null;

    // Empty this linked list, O(n)
    public void clear() {
        DoublyLinkedListNode<T> trav = head;
        while (trav != null) {
            DoublyLinkedListNode<T> next = head.next;
            trav.prev = trav.next = null;
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

    // Add an element to the tail of the linked list, O(1)
    public void addLast(T elem) {
        if (head == null && tail == null) {
            head = tail = new DoublyLinkedListNode<T>(elem, null, null);
        } else {
            tail.next = new DoublyLinkedListNode<T>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    // Add an element to the head of the linked list, O(1)
    public void addFirst(T elem) {
        if (head == null && tail == null) {
            head = tail = new DoublyLinkedListNode<T>(elem, null, null);
        } else {
            head.prev = new DoublyLinkedListNode<T>(elem, null, head);
            head = head.prev;
        }
        size++;
    }

    public void addAt(int index, T data) throws Exception {
        if (index < 0) {
            throw new Exception("Illegal Index");
        }
        if (index == size) {
            addLast(data);
            return;
        }
        DoublyLinkedListNode<T> temp = head;
        for (int it = 0; it < index - 1; it++) {
            temp = temp.next;
        }
        DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(data, temp, temp.next);
        temp.next.prev = newNode;
        temp.next = newNode;
        size++;
    };

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
        if (isEmpty())
            tail = null;
        else
            head.prev = null;

        return data;
    }

    public T removeLast() {
        if (isEmpty())
            throw new RuntimeException("Empty list");
        T data = tail.data;
        tail = tail.prev;
        size--;
        if (isEmpty())
            head = null;
        else
            tail.next = null;

        return data;
    }

    // Remove an arbitrary node from the linked list, O(1)
    private T remove(DoublyLinkedListNode<T> node) {
        // If the node to remove is somewhere either at the
        // head or the tail handle those independently
        if (node.prev == null)
            return removeFirst();
        if (node.next == null)
            return removeLast();

        // Make the pointers of adjacent nodes skip over 'node'
        node.next.prev = node.prev;
        node.prev.next = node.next;

        // Temporarily store the data we want to return
        T data = node.data;

        // Memory cleanup
        node.data = null;
        node = node.prev = node.next = null;

        --size;

        // Return the data in the node we just removed
        return data;
    }

    public T removeAt(int index) {
        // Make sure the index provided is valid
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        int i;
        DoublyLinkedListNode<T> trav;
        if ((index < (size / 2))) {
            for (i = 0, trav = head; i != index; i++) {
                trav = trav.next;
            }
        } else {
            for (i = size - 1, trav = tail; i != index; i--) {
                trav = trav.prev;
            }
        }

        return remove(trav);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        DoublyLinkedListNode<T> trav = head;
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

    // Remove a particular value in the linked list, O(n)
    public boolean remove(Object obj) {
        DoublyLinkedListNode<T> trav = head;

        if (obj == null) {
            for (trav = head; trav != null; trav = head.next) {
                if (trav.data == null) {
                    remove(trav);
                    return true;
                }
            }
        } else {
            for (trav = head; trav != null; trav = head.next) {
                if (obj.equals(trav.data)) {
                    remove(trav);
                    return true;
                }

            }
        }

        return true;
    }

    public int indexOf(Object obj) {
        int index = 0;
        DoublyLinkedListNode<T> trav = head;
        if (obj == null) {
            for (; trav != null; trav = trav.next, index++) {
                if (trav.data == null) {
                    return index;
                }
            }

        } else {
            for (; trav != null; trav = trav.next, index++) {
                if (obj.equals(trav.data)) {
                    return index;
                }
            }
        }

        return -1;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private DoublyLinkedListNode<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
