package org.samples.datastructure;

import org.junit.Assert;
import org.junit.Test;
import org.samples.datastructure.interfaces.IStack;

public class ArrayStackTests extends StackTests{
    @Override
    protected IStack<Long> getStack() {
        return new ArrayStack<>();
    }

    @Test
    public  void push_multiElements_successfully(){
        IStack stack = this.getStack();

        stack.push(1L);
        stack.push(2L);
        stack.push(3L);
        stack.push(4L);
        stack.push(5L);
        stack.push(6L);
        stack.push(7L);
        stack.push(8L);
        stack.push(9L);

        Assert.assertEquals(9L, stack.peek());
        Assert.assertEquals(9, stack.size());
    }
}
