package LinkedList;

import java.util.ListResourceBundle;

public class LeetCode_LinkedList_21 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preH = new ListNode(-1);
        ListNode pre = preH;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return preH.next;
    }

    public static ListNode mergeTwoLists_(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    public static void main(String[] args) {
        ListNode S = new ListNode(1,new ListNode(3));
        ListNode T = new ListNode(2, new ListNode(4));
        ListNode E = mergeTwoLists_(S, T);
        while(E != null){
            System.out.println(E.val);
            E = E.next;
        }
    }
}
