package dataStructures;

import java.util.LinkedList;

public class HashTable {
  public static void main(String[] args) {
    HashTable hashTable = new HashTable();
    hashTable.put(20, "Aaron");
    hashTable.put(21, "Joseph");
    hashTable.put(2, "Joseph");
    hashTable.put(20, "Dan");
    hashTable.remove(21);
    for (int i = 0; i < hashTable.array.length; i++) {
      LinkedList entries = hashTable.array[i];
      if (entries != null) {
        var entriesArray = entries.toArray();
        for (int j = 0; j < entriesArray.length; j++) {
          System.out.println("Array Index: " + i + " Index: " + j + "  Entry: " + entriesArray[j]);
        }
      }
    }
    System.out.println("Get key 20: " + hashTable.get(20));
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
    int index = hash(key);

    LinkedList<Entry> entries = getEntries(index);
    for (Entry entry : entries) {
      if (entry.key == key)
        return entry.value;
    }
    return "";
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

  public void remove(int key) {
    int index = hash(key);

    LinkedList<Entry> entries = getEntries(index);
    entries.removeIf(entry -> entry.key == key);
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
