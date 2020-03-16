package at.ghazarian.data.structure;

import lombok.AllArgsConstructor;

/**
 * Fixed sized HashTable with an linkedList implementation
 * -> duplicate key -> old value is overwritten and old value is returned otherwise null
 * -> does not allow null key and value
 * @param <K>
 * @param <V>
 */
public class MyHashTable<K, V> {

    private int CAPACITY = 1000;
    private Entry<K, V>[] table = new Entry[CAPACITY];

    public V put(K k, V v) {
        if (k == null || v == null)
            throw new IllegalArgumentException("neither key nor value can be null.");

        // 0...999
        int index = k.hashCode() % CAPACITY;
        var newEntry = new Entry<K, V>(k, v, null);
        var currentEntry = table[index];

        if (currentEntry != null) {
            var duplicateKeyValue = getDuplicateKeyValue(currentEntry, k);
            if (duplicateKeyValue != null) {
                var oldValue = duplicateKeyValue.value;
                duplicateKeyValue.value = v;
                return oldValue;
            }
            newEntry.next = currentEntry;
        }

        table[index] = newEntry;
        return null;
    }

    public V get(K k) {
        int index = k.hashCode() % CAPACITY;
        var entry = table[index];
        while (entry != null) {
            if (k.equals(entry.key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    private Entry<K, V> getDuplicateKeyValue(Entry<K, V> currentElement, K k) {
        while (currentElement != null) {
            if (k.equals(currentElement.key)) {
                return currentElement;
            }
            currentElement = currentElement.next;
        }
        return null;
    }

    @AllArgsConstructor
    private class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;
    }
}
