package org.samples.datastructure;

import org.samples.datastructure.interfaces.IList;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class ArrayList<E> extends AbstractList implements IList<E> {
    private static final int INITIAL_CAPACITY = 4;
    private Object[] elements = null;
    private int capacity = INITIAL_CAPACITY;

    public ArrayList() {
        this.capacity = INITIAL_CAPACITY;
        this.elements = new Object[this.capacity];
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
        if (this.length == 0) {
            return false;
        }

        for (int i = 0; i < this.length; i++) {
            if (null == o) {
                if (null == this.elements[i]) {
                    return true;
                }
            } else {
                if (o.equals(this.elements[i])) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void add(E e) {
        if (this.length == this.capacity) {
            this.expandArray();
        }

        this.elements[this.length] = e;
        this.length++;
    }

    private void expandArray() {
        Object[] expandArray = new Object[this.capacity * 2];

        for (int i = 0; i < this.length; i++) {
            expandArray[i] = this.elements[i];
        }

        this.elements = expandArray;
    }

    @Override
    public boolean remove(E o) {
        if (this.length == 0) {
            return false;
        }

        for (int i = 0; i < this.length; i++) {
            boolean matched = false;
            if (null == o) {
                matched = null == this.elements[i];
            } else {
                matched = o.equals(this.elements[i]);
            }

            if (matched) {
                // delete & move
                for (int j = i; j < this.length; j++) {
                    this.elements[j] = this.elements[j + 1];
                }
                this.length--;
                return true;
            }
        }

        return false;
    }

    @Override
    public E get(int index) {
        this.assertIndex(index);

        return (E) this.elements[index];
    }

    @Override
    public E set(int index, E element) {
        this.assertIndex(index);
        E oldValue = (E) this.elements[index];
        this.elements[index] = element;
        return oldValue;

    }

    @Override
    public void add(int index, E element) {
        if (index > 0) {
            this.assertIndex(index - 1);
        } else {
            this.assertIndex(index);
        }

        if (this.length == this.capacity) {
            this.expandArray();
        }

        for (int i = index; i < this.length - 1; i++) {
            this.elements[i + 1] = this.elements[i];
        }

        this.elements[index] = element;
        this.length++;
    }


    @Override
    public E remove(int index) {
        this.assertIndex(index);

        E oldValue = (E) this.elements[index];
        for (int i = index; i < this.length; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.length -= 1;
        return oldValue;
    }
}
