package org.samples.datastructure;

public class ArrayQueue<E> extends AbstractQueue<E> {
    private final static int INITIAL_CAPACITY = 4;
    private int capacity = INITIAL_CAPACITY;
    private Object[] elements = new Object[capacity];
    private int head = 0;

    public ArrayQueue() {

    }

    @Override
    public void enqueue(E element) {
        if (this.length == this.capacity) {
            Object[] newElements = new Object[this.capacity * 2];
            for (int i = 0; i < this.length; i++) {
                int oldIndex = (this.head + i) % this.length;
                newElements[i] = this.elements[oldIndex];
            }

            this.elements = newElements;
            this.head = 0;
            this.capacity *= 2;
        }

        int index = (this.head + this.length) % this.capacity;
        this.elements[index] = element;

        this.length++;
    }

    @Override
    public E dequeue() {
        this.assertSize();
        E value = (E) this.elements[this.head];
        this.head = (this.head + 1) % this.capacity;
        this.length--;
        return value;
    }

    @Override
    public E head() {
        this.assertSize();

        return (E) this.elements[this.head];
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
