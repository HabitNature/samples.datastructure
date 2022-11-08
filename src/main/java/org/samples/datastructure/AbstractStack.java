package org.samples.datastructure;

import org.samples.datastructure.interfaces.IStack;

import java.util.EmptyStackException;

public abstract class AbstractStack<E> implements IStack<E> {
    protected int length = 0;

    protected void assertEmpty(){
        if (this.length == 0) {
            throw new EmptyStackException();
        }
    }
}
