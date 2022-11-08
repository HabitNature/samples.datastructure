package org.samples.datastructure;

import org.samples.datastructure.interfaces.IQueue;

import java.util.NoSuchElementException;

public abstract class AbstractQueue<E> implements IQueue<E> {
    protected int length = 0;
    protected void assertSize() {
        if (this.length == 0) {
            throw new NoSuchElementException();
        }
    }
}
