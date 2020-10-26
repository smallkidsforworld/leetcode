
public class d234 {
    public static boolean isPalindrome(ListNode head) {
        // 首先找到中值指针，然后反转后半部分，然后从头部开始比较
        ListNode quick = head, slow = head;
        if (head == null || head.next == null)
            return true;
        if (head.next.next == null)
            return head.next.val == head.val;
        // slow为中间节点
        while (quick.next != null) {
            if (quick.next.next == null) {
                quick = quick.next;
                break;
            }
            quick = quick.next.next;
            slow = slow.next;
        }
        // 反转slow后面的ListNode
        ListNode tail = quick;
        while (slow.next != tail) {
            quick.next = slow.next;
            slow.next = slow.next.next;
            quick = quick.next;
            quick.next = null;
        }

        slow = slow.next;
        while (slow != null) {
            if (head.val != slow.val)
                return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        // head.next.next.next= new ListNode(1);
        System.out.println(isPalindrome(head));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}