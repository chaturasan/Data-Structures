/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

/*  https://www.geeksforgeeks.org/given-a-linked-list-which-is-sorted-how-will-you-insert-in-sorted-way */
public class SortedListNodeInsertion {

    public static Node sortedInsert(Node head1, int key) {
        Node node = new Node(key);
        if(head1 == null) {
            head1 = node;
        }
        Node temp = head1;
        if(head1.data >= key) {
            node.next = head1;
            head1 = node;
            return head1;
        }

        while(temp.next != null) {
            if(temp.next.data >= key) {
                node.next = temp.next;
                temp.next = node;
                return head1;
            } else {
                temp = temp.next;
            }
        }

        temp.next = node;
        return head1;
    }

    private SortedListNodeInsertion() {
    }
}