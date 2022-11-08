package org.samples.datastructure;

public abstract class AbstractList {
    protected int length = 0;

    protected void assertIndex(int index) {
        if (index < 0 || index >= this.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
