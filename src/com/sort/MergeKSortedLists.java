package com.sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(1);
		//ListNode l2 = new ListNode(4);
		//ListNode l3 = new ListNode(5);
		ListNode m1 = new ListNode(0);
		//ListNode m2 = new ListNode(3);
		//ListNode m3 = new ListNode(4);
		//ListNode n1 = new ListNode(2);
		//ListNode n2 = new ListNode(6);

		/*l1.next = l2;
		l2.next = l3;

		m1.next = m2;
		m2.next = m3;

		n1.next = n2;*/

		ListNode[] lists = { l1, m1 };

		ListNode newNode = mergeKLists(lists);
		
		while(newNode!=null) {
			System.out.print(newNode.val + " --> ");
			newNode=newNode.next;
		}
		

	}

	private static ListNode mergeKLists(ListNode[] lists) {
		
		Comparator<ListNode> customComparator = new Comparator<ListNode>()
				{
					public int compare(ListNode l1, ListNode l2) {
						return l1.val >l2.val ? 1 : -1;
						
					}
				};
		
		Queue<ListNode> q = new PriorityQueue<ListNode>(lists.length,customComparator);

		for(ListNode l: lists) {
			q.offer(l);
		}
		ListNode head = null;
		ListNode tail = null;
		while(!q.isEmpty()) {
			ListNode tempNode = q.poll();
			ListNode currentNode = new ListNode(tempNode.val);
			if(tempNode.next!=null) {
				q.offer(tempNode.next);
			}
			if(currentNode.next!=null){
				q.offer(currentNode.next);
			}
			if(head==null) {
				head=currentNode;
			}
			if(tail==null) {
				tail=currentNode;
			}
			else {
				tail.next=currentNode;
				tail = tail.next;
			}
			
		}
		
		return head;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
