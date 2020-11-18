
import java.util.NoSuchElementException;

public class LinkedStringList {

    private Node first;
    private Node currentNode;
    private int length;

    class Node {
        private String data;
        private Node next;

        public void printNodeData() {
            System.out.println("Node data: " + this.data);
        }

        public Node getNext() {
            return this.next;
        }
    }

    public LinkedStringList() {
        first = null;
        currentNode = null;
        length = 0;
    }

    public void addFirst(String value) {
        
        // Create the node & set its value
        Node newNode = new Node();
        newNode.data = value;

        // if newNode is the first node, this will be null
        // else, it will point to the former "first" now
        newNode.next = first;

        // update "first" to point to node we just created
        first = newNode;

        currentNode = newNode;
        length++;
    }

    public void setFirstValue(String value) {
        first.data = value;
    }

    public void setCurrentValue(String value) {
        currentNode.data = value;
    }

    public void moveNext() {
        if (currentNode.next == null) {
            throw new NoSuchElementException();
        } else {
            currentNode = currentNode.next;
        }
    }

    public void moveFirst() {
        currentNode = first;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public int getLength() {
        return length;
    }

    public String getFirstValue() {
        if (first == null) {
            throw new NoSuchElementException();
        } else {
            return (first.data);
        }
    }

    public String getCurrentValue() {
        if (currentNode == null) {
            throw new NoSuchElementException();
        } else {
            return (currentNode.data);
        }
    }

    public void displayList() {
        Node tempNode = first;
        System.out.println("List contents:");
        while (tempNode != null) {
            tempNode.printNodeData();
            tempNode = tempNode.getNext();
        }
    }

    public void add(String value) {
        if (first == null) {
            addFirst(value);
            return;
        }
        Node newNode = new Node();
        newNode.data = value;
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        currentNode = newNode;
        length++;

    }

    public void removeFirst() {
        first = first.next;
        if(first!=currentNode)
            currentNode =first;   
    }

    public void remove() {
        System.out.println("currentNode "+currentNode.data);
        if (currentNode == first)
            removeFirst();
        else {
            Node head = first;
            while (head.next != currentNode)
                head = head.next;
            head.next = currentNode.next;
            currentNode = head.next;
        }
    }

    public String indexOf(int index) {
        Node head = first;
        while (index >= 0 && head != null) {
            head = head.next;
            index--;
        }
        if (index >= 0)
            throw new NoSuchElementException();
        return head.data;
    }

    public void sortAscending() {
        moveFirst();
        for (int i = 0; i < length - 1; ++i) {
            for (int j = i; j < length - 1; ++j) {
                if (compareTWoString(currentNode.data, currentNode.next.data) > 0) {
                    String temp = currentNode.data;
                    currentNode.data = currentNode.next.data;
                    currentNode.next.data = temp;
                }
                moveNext();
            }
            moveFirst();
        }
        moveFirst();
    }

    // positive one > two ; negative one < two;
    public static int compareTWoString(String str_one, String str_two) {
        int i = 0;
        while (i < str_one.length() && i < str_two.length()) {
            if (str_one.charAt(i) != str_two.charAt(i))
                break;
            i++;
        }
        if (str_one.charAt(i) == str_two.charAt(i))
            return str_one.length() - str_two.length();
        else
            return str_one.charAt(i) - str_two.charAt(i);
    }

    public static void main(String[] args) {
        System.out.println(compareTWoString("Red", "Green"));
    }

}