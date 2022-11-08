package org.samples.datastructure;

import org.samples.datastructure.interfaces.IQueue;

public class ArrayQueueTests extends QueueTests{
    @Override
    protected IQueue<Long> getQueue() {
        return new ArrayQueue<>();
    }
}
