package com.data.structure.Stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> implements IStack<T> {
    private StackNode stackNode;

    public Stack() {
        stackNode = new StackNode();
        stackNode.capacity = 16;
        stackNode.data = new Object[stackNode.capacity];
    }

    public int size() {
        return stackNode.size;
    }

    public boolean isEmpty() {
        return stackNode.size == 0;
    }

    public void push(T elem) {
        if (stackNode.size == stackNode.capacity) {
            increaseCapacity();
        }
        stackNode.data[stackNode.size++] = elem;
    }

    private void increaseCapacity() {
        stackNode.capacity *= 2;
        stackNode.data = Arrays.copyOf(stackNode.data, stackNode.capacity);
    }

    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();
        T elem = (T) stackNode.data[--stackNode.size];
        stackNode.data[stackNode.size] = null;
        System.out.println();

        return elem;
    }

    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return (T) stackNode.data[stackNode.size - 1];
    }
}
