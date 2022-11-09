package org.samples.datastructure;

import org.samples.datastructure.interfaces.ISet;

public class HashSetTests extends SetTests{
    @Override
    protected ISet<String> getSet() {
        return new HashSet<>();
    }
}
