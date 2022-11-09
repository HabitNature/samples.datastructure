package org.samples.datastructure;

import org.samples.datastructure.interfaces.IList;
import org.samples.datastructure.interfaces.IMap;

import java.util.List;

public class HashMap<K, V> implements IMap<K, V> {
    private final static int INIT_CAPACITY = 4;
    private int capacity = INIT_CAPACITY;
    private int length = 0;
    private IList<Pair<K, V>>[] pairsArray = new IList[this.capacity];
    private Object[] keys = new Object[this.capacity];

    public HashMap() {

    }

    @Override
    public boolean isEmpty() {
        return 0 == this.length;
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public boolean containsKey(K key) {
        this.assertKey(key);
        int hash = this.hash(key);

        if (null == this.pairsArray[hash]) {
            return false;
        }

        for (int i = 0; i < this.pairsArray[hash].size(); i++) {
            if (this.pairsArray[hash].get(i).getKey().equals(key)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < this.pairsArray.length; i++) {
            if (null != this.pairsArray[i]) {
                for (int j = 0; j < this.pairsArray[i].size(); j++) {
                    if (this.pairsArray[i].get(j).getValue() == null) {
                        if (null == value) {
                            return true;
                        }
                    } else {
                        if (this.pairsArray[i].get(j).getValue().equals(value)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    @Override
    public V get(K key) {
        this.assertKey(key);
        int hash = this.hash(key);

        if (null == this.pairsArray[hash]) {
            return null;
        }

        for (int i = 0; i < this.pairsArray[hash].size(); i++) {
            if (this.pairsArray[hash].get(i).getKey().equals(key)) {
                return this.pairsArray[hash].get(i).getValue();
            }
        }

        return null;
    }

    @Override
    public void set(K key, V value) {
        this.assertKey(key);
        int hash = this.hash(key);
        Pair<K, V> pair = new Pair<>(key, value);
        IList<Pair<K, V>> pairs = this.pairsArray[hash];

        if (pairs == null) {
            pairs = new ArrayList<>();
            this.pairsArray[hash] = pairs;
        }

        for (int i = 0; i < pairs.size(); i++) {
            if (pairs.get(i).getKey().equals(key)) {
                pairs.get(i).setValue(value);
                return;
            }
        }

        this.pairsArray[hash].add(pair);

        this.length++;
    }

    @Override
    public boolean remove(K key) {
        this.assertKey(key);

        int hash = this.hash(key);

        if (null == this.pairsArray[hash]) {
            return false;
        }

        for (int i = 0; i < this.pairsArray[hash].size(); i++) {
            if (this.pairsArray[hash].get(i).getKey().equals(key)) {
                this.pairsArray[hash].remove(i);
                this.length--;
                return true;
            }
        }

        return false;
    }

    private int hash(K key) {
        if (null == key) {
            return 0;
        }

        return Math.abs(key.hashCode()) % this.capacity;
    }

    private void assertKey(K key) {
        if (null == key) {
            throw new NullPointerException();
        }
    }
}
