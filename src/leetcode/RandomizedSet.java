//Implement the RandomizedSet class:
//
//RandomizedSet() Initializes the RandomizedSet object.
//bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
//bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
//int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
//You must implement the functions of the class such that each function works in average O(1) time complexity.

package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author Pradeep Arya
 */
public class RandomizedSet {

    private Map<Integer, Boolean> randomizedSet;
    private List<Integer> elements;
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        randomizedSet = new HashMap<>();
        elements = new ArrayList<Integer>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean isInserted = randomizedSet.getOrDefault(val, false);
        if(!isInserted){
            elements.add(val);
            randomizedSet.put(val, true);
        }
        return !isInserted;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(randomizedSet.remove(val) != null){
            elements.remove((Integer)val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randIdx = random.nextInt(elements.size());
        return elements.get(randIdx);
    }
}
