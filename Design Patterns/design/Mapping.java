package com.endava.design;

/**
 * Created by tvasile on 7/22/2016.
 */
public class Mapping<K, V> {

    K key;
    V value;

    public Mapping(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

}
