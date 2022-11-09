package org.samples.datastructure;

import org.samples.datastructure.interfaces.ISet;

public class HashSet<E> implements ISet<E> {
    private HashMap<E, Object> map = new HashMap<>();

    @Override
    public boolean add(E element) {
        if (this.map.containsKey(element)) {
            return false;
        }

        this.map.set(element, null);
        return true;
    }

    @Override
    public boolean remove(E element) {
        return this.map.remove(element);
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public boolean contains(E element) {
        return this.map.containsKey(element);
    }
}
