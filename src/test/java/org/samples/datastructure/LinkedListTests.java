package org.samples.datastructure;

import org.samples.datastructure.interfaces.IList;

public class LinkedListTests extends ListTests {
    @Override
    protected IList<Long> getList() {
        return new LinkedList<>();
    }
}
