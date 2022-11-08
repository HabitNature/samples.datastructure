package org.samples.datastructure;

import org.samples.datastructure.interfaces.IStack;

public class LinkedStackTests extends StackTests{
    @Override
    protected IStack<Long> getStack() {
        return new LinkedStack<>();
    }
}
