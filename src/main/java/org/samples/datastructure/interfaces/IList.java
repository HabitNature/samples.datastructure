package org.samples.datastructure.interfaces;

public interface IList<E> {
    void add(E element);

    boolean remove(E element);

    boolean isEmpty();

    int size();

    void add(int index, E element);

    E remove(int index);

    boolean contains(E element);

    E get(int index);

    E set(int index, E element);
}
