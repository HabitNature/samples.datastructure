package org.samples.datastructure;

public class LinkedQueue<E> extends AbstractQueue<E> {
    private SinglePointerNode<E> head = new SinglePointerNode<>();
    private SinglePointerNode<E> tail = new SinglePointerNode<>();

    @Override
    public void enqueue(E element) {
        SinglePointerNode<E> newNode = new SinglePointerNode<>();

        newNode.setData(element);

        this.tail.setNext(newNode);
        this.tail = newNode;

        if (null == this.head.getNext()) {
            this.head.setNext(newNode);
        }

        this.length++;
    }

    @Override
    public E dequeue() {
        this.assertSize();

        E value = this.head.getNext().getData();
        this.head.setNext(this.head.getNext().getNext());

        this.length--;
        return value;
    }

    @Override
    public E head() {
        this.assertSize();
        if (null != this.head.getNext()) {
            return this.head.getNext().getData();
        }

        return null;
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
