package dataStructures;

import java.util.LinkedList;

public class HashTable {
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
    hashTable.put(20, "Dan");
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

  static class Entry {

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


    LinkedList entries = getEntries(index);
    if (!overrideEntryIfPresent(entries, key, value)) {
      Entry entry = new Entry(key, value);
      entries.add(entry);
    }
  }

  public String get(int key) {


  }

  private static boolean overrideEntryIfPresent(LinkedList<Entry> entries, int key, String value) {
    for (var entry : entries) {
      if (entry.key == key) {
        entry.value = value;
        return true;
      }
    }

    return false;
  }

  private LinkedList getEntries(int index) {
        return array[index];
    }

  private void createEntryAt(int index) {
    LinkedList<Entry> entries = new LinkedList<>();
    array[index] = entries;
  }

  private int hash(int key) {
    return (key % array.length);
  }

}
