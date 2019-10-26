package medium.lrucache;

class LRUCache {
    private int entries = 0;
    private final int capacity;
    private final int buckets;
    static private class Entry {
        Entry orderprev = null;
        Entry ordernext = null;
        Entry bucketprev = null;
        Entry bucketnext = null;
        int key;
        int val;
    }
    private final Entry[] map;
    private Entry accessFirst = null;
    private Entry accessLast = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        buckets = (1+capacity) * 4 / 3;
        map = new Entry[buckets];
    }

    private Entry access(int key, boolean create) {
        // FIND ENTRY
        Entry entry = map[key % buckets];
        while ( entry != null && entry.key != key)
            entry = entry.bucketnext;

        if (entry != null) {
            // MOVE TO MOST RECENT ACCESSED
            if (entry != accessFirst) {
                Entry prev = entry.orderprev;
                Entry next = entry.ordernext;
                prev.ordernext = next;
                if (next != null)
                    next.orderprev = prev;
                else
                    accessLast = prev;
                entry.orderprev = null;
                entry.ordernext = accessFirst;
                accessFirst.orderprev = entry;
                accessFirst = entry;
            }
        }
        else if (create) {
            entries++;
            entry = new Entry();
            entry.key = key;
            // ADD TO BUCKET LIST
            Entry oldHead = map[key % buckets];
            if (oldHead != null) {
                entry.bucketnext = oldHead;
                oldHead.bucketprev = entry;
            }
            map[key % buckets] = entry;

            // ADD TO ACCESS LIST
            if (accessFirst == null) {
                accessFirst = entry;
                accessLast = entry;
            }
            else {
                Entry oldFirst = accessFirst;
                accessFirst = entry;
                entry.ordernext = oldFirst;
                oldFirst.orderprev = entry;
            }

            // REMOVE LAST ACCESSED
            if (entries > capacity) {
                // REMOVE FROM ACCESS LIST
                Entry toRemove = accessLast;
                accessLast = accessLast.orderprev;
                accessLast.ordernext = null;
                // REMOVE FROM BUCKET LIST
                if (toRemove.bucketprev == null) {
                    map[toRemove.key % buckets] = toRemove.bucketnext;
                }
                else
                    toRemove.bucketprev.bucketnext = toRemove.bucketnext;
                if (toRemove.bucketnext != null)
                    toRemove.bucketnext.bucketprev = toRemove.bucketprev;
                entries--;
            }
        }
        return entry;
    }

    public int get(int key) {
        Entry entry = access(key, false);

        return entry == null ? -1 : entry.val;
    }
    // ADD TO BUCKET LIST

    public void put(int key, int value) {
        Entry entry = access(key, true);
        entry.val = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */