package org.samples.datastructure;

import org.samples.datastructure.interfaces.IStack;

import java.util.EmptyStackException;

public class ArrayStack<E> extends AbstractStack<E> implements IStack<E> {
    private final static int INITIAL_CAPACITY = 4;
    private Object[] elements = new Object[]{};
    private int capacity = INITIAL_CAPACITY;

    public ArrayStack() {
        this.elements = new Object[this.capacity];
    }

    @Override
    public void push(E element) {
        if (this.length == this.capacity) {
            // expand
            this.capacity *= 2;
            Object[] newElements = new Object[this.capacity];
            for (int i = 0; i < this.length; i++) {
                newElements[i] = this.elements[i];
            }

            this.elements = newElements;
        }
        this.length++;
        this.elements[this.length - 1] = element;
    }

    @Override
    public E peek() {
        this.assertEmpty();

        return (E) this.elements[this.length - 1];
    }

    @Override
    public E popup() {
        this.assertEmpty();

        E value = (E) this.elements[this.length - 1];
        this.elements[this.length - 1] = null;
        this.length--;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return 0 == this.length;
    }

    @Override
    public int size() {
        return this.length;
    }
}
