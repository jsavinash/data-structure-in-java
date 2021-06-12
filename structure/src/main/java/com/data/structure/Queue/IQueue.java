package com.data.structure.Queue;

public interface IQueue<T> {

    public void offer(T elem);

    public T poll();

    public T peek();

    public int size();

    public boolean isEmpty();
}
