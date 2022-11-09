package org.samples.datastructure;

import org.samples.datastructure.interfaces.IMap;

public class HashMapTests extends MapTests {
    @Override
    protected IMap<String, String> getMap() {
        return new HashMap<>();
    }
}
