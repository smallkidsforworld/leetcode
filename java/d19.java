package java;

public class d19{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow=head,quick=head;
        while(n>0){
            if(quick==null)
                return head;
            quick=quick.next;
            n--;
        }
        System.out.println(" "+quick.val+" "+slow.val);
        while(quick!=null){
            quick=quick.next;
            slow=slow.next;
        } 
        slow.next=slow.next.next;
        return head;
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