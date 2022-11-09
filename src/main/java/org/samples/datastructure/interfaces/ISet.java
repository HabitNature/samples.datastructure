package org.samples.datastructure.interfaces;


public interface ISet<E> {
    boolean add(E element);

    boolean remove(E element);

    boolean isEmpty();

    int size();

    boolean contains(E element);
}
