package training.collections;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by tvasile on 7/18/2016.
 */
public class HashTable<K, V> {

    private class HashSet<K, V> {
        private K key;
        private ArrayList<V> values;

        public HashSet() {
            values = new ArrayList<>();
        }

        public K getKey() {
            return key;
        }

        public ArrayList<V> getValue() {
            return values;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.values.add(value);
        }
    }

    HashSet<K, V> []hashSets;
    Integer size;

    public HashTable(int size) {
        hashSets = new HashSet[size];
        this.size = size;
    }

    public void put(K key, V value) {
        int hash = key.hashCode() % size;

        if(hashSets[hash] == null)
            hashSets[hash] = new HashSet();

        if(key == "Pingu")
            System.out.println("Key: " + key);

        hashSets[hash].setKey(key);
        hashSets[hash].setValue(value);
    }

    public ArrayList<V> get(K key) {
        int hash = key.hashCode() % size;
        System.out.println("hash: " + hash);
        return hashSets[hash].getValue();
    }

}
