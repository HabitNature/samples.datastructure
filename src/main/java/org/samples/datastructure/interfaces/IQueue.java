package org.samples.datastructure.interfaces;

public interface IQueue<E> {
    void enqueue(E element);

    E dequeue();

    E head();

    boolean isEmpty();

    int size();
}
