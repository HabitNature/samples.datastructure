package org.samples.datastructure;

import org.samples.datastructure.interfaces.IList;

public class ArrayListTests extends ListTests {

    @Override
    protected IList<Long> getList() {
        return new ArrayList<>();
    }
}
