package org.samples.datastructure.interfaces;

public interface IMap<K, V> {
    boolean isEmpty();

    int size();

    boolean containsKey(K key);

    boolean containsValue(V value);

    V get(K key);

    void set(K key, V value);

    boolean remove(K key);
}
