import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class d143 {
    public static void reorderList(ListNode head) {
        List<ListNode> node_list = new ArrayList<>();
        if (head == null || head.next == null)
            return;
        while (head != null) {
            node_list.add(head);
            head = head.next;
        }
        int i = 0, j = node_list.size() - 1;
        while (i < node_list.size() / 2) {
            node_list.get(j).next = node_list.get(i).next;
            node_list.get(i).next = node_list.get(j);
            i++;
            j--;
        }
        node_list.get(i).next = null;
        // ListNode second=node_list.get(0);
        // while(second!=null){
        // System.out.println(second.val);
        // second=second.next;
        // }
    }

    

    public static ListNode reorderList(ListNode head, int root) {
        if (head == null || head.next == null)
            return null;
        ListNode quick = head, slow = head;
        while (quick != null) {
            slow = head.next;
            if (quick.next == null )
                break;
            quick = quick.next.next;
        }
        System.out.println("quick "+quick.val+" slow "+slow.val);
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = head;
        for (int i : Arrays.asList(2, 3, 4, 5, 6)) {
            head.next = new ListNode(i);
            head = head.next;
        }
        System.out.println(reorderList(second, 1).val);
    }
}