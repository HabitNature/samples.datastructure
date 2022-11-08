package org.samples.datastructure;

import org.samples.datastructure.interfaces.IList;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class LinkedList<E> extends AbstractList implements IList<E> {
    private SinglePointerNode<E> head = new SinglePointerNode<>();

    public LinkedList() {

    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public boolean contains(Object o) {
        SinglePointerNode<E> tempNode = head.getNext();

        while (null != tempNode) {
            if (null == tempNode.getData()) {
                if (o == null) {
                    return true;
                }
            } else {
                if (tempNode.getData().equals(o)) {
                    return true;
                }
            }

            tempNode = tempNode.getNext();
        }

        return false;
    }

    @Override
    public void add(E e) {
        SinglePointerNode<E> tempNode = head;

        while (null != tempNode.getNext()) {
            tempNode = tempNode.getNext();
        }

        SinglePointerNode<E> newNode = new SinglePointerNode<>();

        newNode.setData(e);
        tempNode.setNext(newNode);
        this.length++;
    }

    @Override
    public boolean remove(Object o) {
        SinglePointerNode<E> tempNode = head.getNext();
        SinglePointerNode<E> pre = head;

        while (null != tempNode) {
            boolean matched = false;
            if (o == null) {
                if (null == tempNode.getData()) {
                    matched = true;
                }
            } else {
                if (o.equals(tempNode.getData())) {
                    matched = true;
                }
            }
            if (matched) {
                pre.setNext(tempNode.getNext());
                this.length--;
                // to delete
                return true;
            }

            pre = tempNode;
            tempNode = tempNode.getNext();
        }

        return false;
    }

    @Override
    public E get(int index) {
        this.assertIndex(index);
        SinglePointerNode<E> tempNode = this.head.getNext();
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.getNext();
        }

        return tempNode.getData();
    }

    @Override
    public E set(int index, E element) {
        this.assertIndex(index);
        SinglePointerNode<E> tempNode = this.head.getNext();
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.getNext();
        }

        E old = tempNode.getData();
        tempNode.setData(element);
        return old;
    }

    @Override
    public void add(int index, E element) {
        if (index > 0) {
            // add 允许添加在最后一个元素之后
            this.assertIndex(index - 1);
        } else {
            this.assertIndex(index);
        }

        SinglePointerNode<E> tempNode = this.head.getNext();
        SinglePointerNode<E> pre = this.head;

        for (int i = 0; i < index; i++) {
            pre = tempNode;
            tempNode = tempNode.getNext();
        }

        SinglePointerNode<E> node = new SinglePointerNode<>();
        node.setData(element);
        node.setNext(tempNode);
        pre.setNext(node);

        this.length++;
    }

    @Override
    public E remove(int index) {
        this.assertIndex(index);
        SinglePointerNode<E> tempNode = this.head.getNext();
        SinglePointerNode<E> pre = this.head;

        for(int i = 0; i < index; i++){
            pre = tempNode;
            tempNode = tempNode.getNext();
        }

        pre.setNext(tempNode.getNext());
        this.length--;

        return tempNode.getData();
    }
}
