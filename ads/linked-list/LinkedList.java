/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode prox = head;
        // calcular o tamanho da lista
        int size = 0;
        while (prox != null) {
            size++;
            prox = prox.next;
        }
        // contar até o meio da lista
        int count = 0;
        
        prox = head;
        while (prox != null && count < size/2) {
            count++;
            prox = prox.next;
        }

        return prox;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prox = head;

        ListNode temp = null;
        while (prox != null) {
            temp = prox.next;
            prox.next = prox;
            prox = temp;
        }

        if (prox != null && prox.next == null) {
            prox.next = temp;
        }

        return prox;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prox = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prox;
            prox = current;
            current = next;
        }

        return prox;
    }
}
