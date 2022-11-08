package org.samples.datastructure.interfaces;

public interface IStack<E> {
    void push(E element);

    E peek();

    E popup();

    boolean isEmpty();

    int size();
}
