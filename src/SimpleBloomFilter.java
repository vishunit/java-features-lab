import java.util.BitSet;

public class SimpleBloomFilter {
    private BitSet bitset;
    private int size;
    private int hashFunctions;

    public SimpleBloomFilter(int size, int hashFunctions) {
        this.size = size;
        this.hashFunctions = hashFunctions;
        this.bitset = new BitSet(size);
    }

    public void add(String item) {
        for (int i = 0; i < hashFunctions; i++) {
            int hash = getHash(item, i);
            bitset.set(hash);
        }
    }

    public boolean mightContain(String item) {
        for (int i = 0; i < hashFunctions; i++) {
            int hash = getHash(item, i);
            if (!bitset.get(hash)) {
                return false; // definitely not in set
            }
        }
        return true; // might be in set
    }

    // Simple hash variation using item.hashCode()
    private int getHash(String item, int seed) {
        int hash = item.hashCode() ^ (seed * 0x5f5e100); // XOR with different seed
        return Math.abs(hash % size);
    }

    public static void main(String[] args) {
        SimpleBloomFilter filter = new SimpleBloomFilter(32, 3); // small filter

        filter.add("apple");
        filter.add("banana");

        System.out.println("apple? " + filter.mightContain("apple"));     // true
        System.out.println("banana? " + filter.mightContain("banana"));   // true
        System.out.println("grape? " + filter.mightContain("grape"));     // false (most likely)
    }
}
