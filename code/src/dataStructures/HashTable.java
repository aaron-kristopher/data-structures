package dataStructures;

import java.util.Arrays;
import java.util.LinkedList;

public class HashTable {
    // TODO put(K, V)
    // TODO get(K) V
    // TODO remove(K)
    // k: int
    // v: string
    // Collisions: chaining
    // LinkedList<Entry>[]
    // [ LL, LL, LL, LL ]

    // ! FIX duplicate key problem

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.put(20, "Aaron");
        hashTable.put(21, "Joseph");
        hashTable.put(2, "Joseph");
        hashTable.put(20, "Aaron");
        for (int i = 0; i < hashTable.array.length; i++) {
            LinkedList entries = hashTable.array[i];
            if (entries != null) {
                var entriesArray = entries.toArray();
                for (int j = 0; j < entriesArray.length; j++) {
                    System.out.println("Array Index: " + i + " Index: " + j + "  Entry: " + entriesArray[j]);
                }
            }
        }
    }

    public LinkedList[] array = new LinkedList[5];

    private class Entry {

        public int key;
        public String value;

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
        int index = hash(key);

        if (array[index] == null)
            createEntryAt(index);

        entries = getEntry(index);
        Entry entry = new Entry(key, value);
        entries.add(entry);
    }

    private void isPresent(LinkedList entries, int key) {
        for (var entry : entries) {
            if (entry.key == key)
                return true;
        }

        return false;
    }

    private Entry getEntry(int index) {
        return LinkedList<Entry> entries = array[index];
    }

    private void createEntryAt(int index) {
        LinkedList<Entry> entries = new LinkedList<>();
        array[index] = entries;
    }

    private int hash(int key) {
        return (key % array.length);
    }

}
