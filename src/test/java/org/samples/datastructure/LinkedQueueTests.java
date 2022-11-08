package org.samples.datastructure;

import org.samples.datastructure.interfaces.IQueue;

public class LinkedQueueTests extends QueueTests{
    @Override
    protected IQueue<Long> getQueue() {
        return new LinkedQueue<>();
    }
}
