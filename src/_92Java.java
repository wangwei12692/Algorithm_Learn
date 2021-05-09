import java.util.Arrays;

public class _92Java {
    public static void main(String[] args) {
        ListNode head = UtilsKt.toListNode(new int[]{1, 2, 3, 4, 5});
        head = new _92Java().reverseBetween(head, 2, 4);
        System.out.println(Arrays.toString(UtilsKt.toIntArray(head)));
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0, null);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        head = pre.next;
        for (int i = m; i < n; i++) {
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
    }
}
