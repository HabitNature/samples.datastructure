package org.samples.datastructure;

import org.junit.Assert;
import org.junit.Test;
import org.samples.datastructure.interfaces.IQueue;

import java.util.NoSuchElementException;

public abstract class QueueTests {
    protected abstract IQueue<Long> getQueue();

    @Test
    public void isEmpty_noElement_returnTrue() {
        IQueue<Long> queue = this.getQueue();

        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void isEmpty_hasElement_returnFalse() {
        IQueue<Long> queue = this.getQueue();

        queue.enqueue(3L);

        Assert.assertFalse(queue.isEmpty());
    }

    @Test
    public void size_noElement_returnZero() {
        IQueue<Long> queue = this.getQueue();

        Assert.assertEquals(0, queue.size());
    }

    @Test
    public void size_hasElement_returnSize() {
        IQueue<Long> queue = this.getQueue();

        queue.enqueue(3L);

        Assert.assertEquals(1, queue.size());
    }

    @Test
    public void enqueue_nullElement_successfully() {
        IQueue<Long> queue = this.getQueue();

        queue.enqueue(null);

        Assert.assertEquals(1, queue.size());
        Assert.assertEquals(null, queue.head());
    }

    @Test
    public void enqueue_notNullElement_successfully() {
        IQueue<Long> queue = this.getQueue();

        queue.enqueue(3L);

        Assert.assertEquals(1, queue.size());
        Assert.assertEquals(3L, (Object) queue.head());
    }

    @Test
    public void enqueue_notEmpty_successfully() {
        IQueue<Long> queue = this.getQueue();

        queue.enqueue(1L);
        queue.enqueue(2L);
        queue.enqueue(3L);

        Assert.assertEquals(3, queue.size());
        Assert.assertEquals(1L, (Object) queue.head());
    }

    @Test
    public void enqueue_multiElements_successfully() {
        IQueue<Long> queue = this.getQueue();

        final int count = 100;

        for (long i = 0; i < count; i++) {
            queue.enqueue(i);
        }

        Assert.assertEquals(count, queue.size());
        Assert.assertEquals(0, (long) queue.head());
    }

    @Test
    public void enqueue_dequeue_successfully() {
        IQueue<Long> queue = this.getQueue();

        final int count = 100;

        Long enqueueValue = 0L;
        Long dequeValue = 0L;
        for (long i = 0; i < count; i++) {
            enqueueValue = i;
            queue.enqueue(enqueueValue);
            dequeValue = queue.dequeue();
        }

        Assert.assertEquals(0, queue.size());
        Assert.assertEquals(enqueueValue, dequeValue);
    }

    @Test
    public void head_notEmpty_successfully() {
        IQueue<Long> queue = this.getQueue();

        queue.enqueue(1L);

        Assert.assertEquals(1L, (Object) queue.head());
    }

    @Test(expected = NoSuchElementException.class)
    public void head_empty_throwException() {
        IQueue<Long> queue = this.getQueue();

        queue.head();
    }

    @Test(expected = NoSuchElementException.class)
    public void dequeue_empty_throwException() {
        IQueue<Long> queue = this.getQueue();

        queue.dequeue();
    }

    @Test
    public void dequeue_notEmpty_successfully() {
        IQueue<Long> queue = this.getQueue();

        queue.enqueue(1L);
        Long value = queue.dequeue();

        Assert.assertEquals(1L, (long) value);
        Assert.assertEquals(0, queue.size());
    }

    @Test
    public void dequeue_multiElements_successfully() {
        IQueue<Long> queue = this.getQueue();

        final int count = 100;

        Long enqueueValue = 0L;
        for (long i = 0; i < count; i++) {
            enqueueValue = i;
            queue.enqueue(enqueueValue);
        }

        Long dequeValue = 0L;
        for (long i = 0; i < count; i++) {
            dequeValue = queue.dequeue();
        }

        Assert.assertEquals(0, queue.size());
        Assert.assertEquals((long) enqueueValue, (long) dequeValue);
    }
}
