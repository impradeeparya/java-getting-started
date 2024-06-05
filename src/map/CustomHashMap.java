package map;

class Node{
    private int key;
    private int value;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }

    public int getKey(){
        return this.key;
    }

    public int getValue(){
        return this.value;
    }

    public void setKey(int key){
        this.key = key;
    }

    public void setValue(int value){
        this.value = value;
    }
}

class MyHashMap {

    private Node[][] table;
    private int rows;
    private int columns;
    private int maxElement = 1000000;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.rows = 20000;
        this.columns = this.maxElement/this.rows;
        table = new Node[this.rows][this.columns];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int row = key%rows;
        Node[] nodes = table[row];
        boolean isFound = false;
        int nullIndex = -1;
        for(int index = 0; index < this.columns; index++){
            Node node = nodes[index];
            if(node == null){
                if(nullIndex == -1){
                    nullIndex = index;
                }
                continue;
            }
            if(node.getKey() == key){
                node.setValue(value);
                isFound = true;
                break;
            }
        }

        if(!isFound){
            nodes[nullIndex] = new Node(key, value);
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int value = -1;
        int row = key%rows;
        Node[] nodes = table[row];
        for(int index = 0; index < this.columns; index++){
            Node node = nodes[index];
            if(node != null && node.getKey() == key){
                value = node.getValue();
                break;
            }
        }
        return value;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int row = key%rows;
        Node[] nodes = table[row];
        for(int index = 0; index < this.columns; index++){
            Node node = nodes[index];
            if(node != null && node.getKey() == key){
                nodes[index] = null;
                break;
            }
        }
    }
}

public class CustomHashMap {
}
