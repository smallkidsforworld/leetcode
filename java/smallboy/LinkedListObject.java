
public class LinkedListObject {
    public static void main(String[] args) {
        LinkedStringList list = new LinkedStringList();
        list.add("First");
        list.add("Second");
        list.add("Third");
        list.moveFirst();
        list.setCurrentValue("Red");
        list.moveNext();
        list.setCurrentValue("Green");
        list.moveNext();
        list.setCurrentValue("Blue");
        list.sortAscending();
        list.displayList();
        list.remove();
        list.remove();
        list.displayList();
    }
}