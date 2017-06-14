package FancyDataStructrue;

/**
 * Created by z001ktb on 5/27/17.
 */
public class MyHashTable<V,K> {

    static class LinkedHashEntry<V,K> {
        V value;
        K key;
        LinkedHashEntry<V,K> next;

        LinkedHashEntry(V value, K key) {
            this.value = value;
            this.key = key;
            this.next = null;
        }
    }

    private int TABLE_SIZE;
    private LinkedHashEntry[] entries;
    private int size;
    public MyHashTable(int tableSize) {
        this.TABLE_SIZE = tableSize;
        this.entries = new LinkedHashEntry[tableSize];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void put(K key, V value) {
        int hash = myhash(key);
        LinkedHashEntry<V,K> entry = new LinkedHashEntry(value, key);
        if(entries[hash] != null) {
            LinkedHashEntry existingEntry = entries[hash];
            while(existingEntry.next != null && !existingEntry.key.equals(key)) {
                existingEntry = existingEntry.next;
            }
            if(existingEntry.next == null){
                existingEntry.next = entry;
            }
            if(existingEntry.key.equals(key)) existingEntry.value = value;
        }else{
            entries[hash] = entry;
        }
        size++;
    }

    public V get(K key) {
        int hash = myhash(key);
        if(entries[hash] != null){
            LinkedHashEntry<V,K> existingEntry = entries[hash];
            while(existingEntry != null && !existingEntry.key.equals(key)) {
                existingEntry = existingEntry.next;
            }

            if(existingEntry == null) return null;
            if(existingEntry.key.equals(key)) return existingEntry.value;
        }
        return null;
    }

    public void remove(K key) {
        int hash = myhash(key);
        if(entries[hash] != null){
            LinkedHashEntry<V,K> existingEntry = entries[hash];
            LinkedHashEntry<V,K> preEntry = null;
            while(existingEntry != null && !existingEntry.key.equals(key)) {
                preEntry = existingEntry;
                existingEntry = existingEntry.next;
            }
            if(existingEntry != null){
                if(preEntry == null) entries[hash] = existingEntry.next;
                else preEntry.next = existingEntry.next;
            }
        }
    }

    private int myhash(K key) {
        int hash = key.hashCode();
        hash = hash % TABLE_SIZE;
        if(hash < 0){
            hash += TABLE_SIZE;
        }
        return hash;
    }
}
