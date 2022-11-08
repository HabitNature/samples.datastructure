package org.samples.datastructure;

import org.junit.Assert;
import org.junit.Test;
import org.samples.datastructure.interfaces.IStack;

import java.util.EmptyStackException;

public abstract class StackTests {
    protected abstract IStack<Long> getStack();

    @Test
    public void isEmpty_noElement_returnTrue() {
        IStack stack = this.getStack();

        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void isEmpty_hasElement_returnFalse() {
        IStack stack = this.getStack();

        stack.push(3L);

        Assert.assertFalse(stack.isEmpty());
    }

    @Test
    public void size_noElement_returnZero() {
        IStack stack = this.getStack();

        Assert.assertEquals(0, stack.size());
    }

    @Test
    public void size_hasElement_returnSize() {
        IStack stack = this.getStack();

        stack.push(3L);

        Assert.assertEquals(1, stack.size());
    }

    @Test
    public void push_nullElement_successfully() {
        IStack stack = this.getStack();

        stack.push(null);

        Assert.assertEquals(null, stack.peek());
        Assert.assertEquals(1, stack.size());
    }

    @Test
    public void push_notNullElement_successfully() {
        IStack stack = this.getStack();

        stack.push(3L);

        Assert.assertEquals(3L, stack.peek());
    }

    @Test
    public void peek_element_successfully() {
        IStack stack = this.getStack();

        stack.push(3L);
        stack.push(4L);
        stack.push(5L);

        Assert.assertEquals(5L, stack.peek());
        Assert.assertEquals(3, stack.size());
    }

    @Test(expected = EmptyStackException.class)
    public void peek_emptyStack_throwException() {
        IStack stack = this.getStack();

        stack.peek();
    }

    @Test
    public void popup_element_successfully() {
        IStack stack = this.getStack();

        stack.push(3L);
        stack.push(4L);
        stack.push(5L);

        Assert.assertEquals(5L, stack.popup());
        Assert.assertEquals(2, stack.size());
    }

    @Test(expected = EmptyStackException.class)
    public void popup_emptyStack_throwException() {
        IStack stack = this.getStack();

        stack.popup();
    }
}
