package org.samples.datastructure;

import org.samples.datastructure.interfaces.IStack;

public class LinkedStack<E> extends AbstractStack<E>  implements IStack<E> {
    private SinglePointerNode<E> tail = new SinglePointerNode<>();

    @Override
    public void push(E element) {
        SinglePointerNode<E> newNode = new SinglePointerNode<>();
        newNode.setData(element);

        newNode.setNext(this.tail.getNext());
        this.tail.setNext(newNode);
        this.length++;
    }

    @Override
    public E peek() {
        this.assertEmpty();
        return this.tail.getNext().getData();
    }

    @Override
    public E popup() {
        this.assertEmpty();
        E value = this.tail.getNext().getData();
        this.tail.setNext(this.tail.getNext().getNext());
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
