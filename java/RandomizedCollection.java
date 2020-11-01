import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

class RandomizedCollection {
    Map<Integer, Set<Integer>> map;
    List<Integer> store;

    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        store = new ArrayList<>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not
     * already contain the specified element.
     */
    public boolean insert(int val) {
        store.add(val);
        if (!map.containsKey(val))
            map.put(val, new HashSet<>());
        map.get(val).add(store.size() - 1);
        return map.get(val).size() <= 1;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained
     * the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).size() <= 0)
            return false;
        int dd = map.get(val).iterator().next();
        store.remove(dd);
        map.get(val).remove(dd);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return store.get(rand.nextInt(store.size()));
    }

    public void test() {
        int flag1, flag2;
        this.insert(1);
        this.insert(1);
        this.insert(2);
        flag1 = getRandom();
        this.remove(1);
        flag2 = getRandom();
        System.out.println("(num1,num2)  "+" ");
    }

    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        for(int i=0;i<)
    }

}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection(); boolean param_1 =
 * obj.insert(val); boolean param_2 = obj.remove(val); int param_3 =
 * obj.getRandom();
 */