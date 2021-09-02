//Implement the RandomizedCollection class:
//
//RandomizedCollection() Initializes the RandomizedCollection object.
//bool insert(int val) Inserts an item val into the multiset if not present. Returns true if the item was not present, false otherwise.
//bool remove(int val) Removes an item val from the multiset if present. Returns true if the item was present, false otherwise. Note that if val has multiple occurrences in the multiset, we only remove one of them.
//int getRandom() Returns a random element from the current multiset of elements (it's guaranteed that at least one element exists when this method is called). The probability of each element being returned is linearly related to the number of same values the multiset contains.
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
public class RandomizedCollection {

    private Map<Integer, Integer> randomizedSet;
    private Random random;
    private List<Integer> elements;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        randomizedSet = new HashMap<>();
        random = new Random();
        elements = new ArrayList<>();

    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean isInserted = false;
        Integer frequency = randomizedSet.getOrDefault(val, null);
        if (frequency == null) {
            frequency = 1;
            isInserted = true;
        } else {
            frequency++;
        }
        elements.add(val);
        randomizedSet.put(val, frequency);
        return isInserted;

    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        Integer frequency = randomizedSet.remove(val);
        if (frequency != null) {
            frequency--;
            elements.remove((Integer) val);
            if (frequency > 0) {
                randomizedSet.put(val, frequency);
            }
        }
        return frequency != null;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        int randIdx = random.nextInt(elements.size());
        return elements.get(randIdx);

    }

    private static void process(String[] line1, int[][] line2) {
        RandomizedCollection randomizedCollection = null;
        int index = 0;
        for (String input : line1) {


            switch (input) {
                case "RandomizedCollection":
                    randomizedCollection = new RandomizedCollection();
                    break;
                case "insert":
                    System.out.print(randomizedCollection.insert(line2[index][0]) + " ");
                    break;
                case "remove":
                    System.out.print(randomizedCollection.remove(line2[index][0]) + " ");
                    break;
                case "getRandom":
                    System.out.print(randomizedCollection.getRandom() + " ");
                    break;

            }
            index++;

        }
        System.out.println();
    }
}
