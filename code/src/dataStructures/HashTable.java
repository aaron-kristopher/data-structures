package dataStructures;

import java.beans.ConstructorProperties;
import java.util.LinkedList;

public class HashTable {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.put(20, "Aaron");
        hashTable.put(21, "Joseph");
        hashTable.put(2, "Joseph");
        hashTable.put(20, "Dan");
        hashTable.remove(21);
        System.out.println("Get key 20: " + hashTable.get(20));
    }

    public LinkedList<Entry>[] entries = new LinkedList[5];

    private class Entry {

        private int key;
        private String value;

        Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    public void put(int key, String value) {
        Entry entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
        }

        getOrCreateBucket(key).addLast(new Entry(key, value));
    }

    public String get(int key) {
        Entry entry = getEntry(key);
        return (entry == null) ? null : entry.value;
    }

    public void remove(int key) {
        Entry entry = getEntry(key);
        if (entry == null)
            throw new IllegalStateException();

        getBucket(key).remove(entry);
    }

    private Entry getEntry(int key) {
        LinkedList<Entry> bucket = getBucket(key);
        if (bucket != null)
            for (Entry entry : bucket) {
                if (entry.key == key)
                    return entry;
            }
        return null;
    }

    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(int key) {
        int index = hash(key);
        LinkedList<Entry> bucket = entries[index];
        if (bucket == null) {
            bucket = new LinkedList<>();
            entries[index] = bucket;
        }

        return bucket;
    }

    private int hash(int key) {
        return (key % entries.length);
    }

}
