package linkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainClass {

	
	public static void main(String[] args) {
		MyLinkedList myLinkedList = new MyLinkedList();
		
		myLinkedList.addToEnd(10);
		myLinkedList.addToEnd(20);
		myLinkedList.addToEnd(30);
		myLinkedList.addToEnd(40);

		myLinkedList.addToEnd(50);

		
		myLinkedList.printList();
		//System.out.println(myLinkedList.findMiddleNode().getData());
		
		myLinkedList.head = reverseList(myLinkedList.head);
		myLinkedList.printList();
		 String[] list1 = new String[] {"Shogun","Tapioca Express","Burger King","KFC"};
		 String[] list2 = new String[]{"KNN","KFC","Burger King","Tapioca Express","Shogun"};
		
		 System.out.println(findRestaurant(list1, list2).length);
		
	}
	public static String[] findRestaurant(String[] list1, String[] list2) {
		List resultList = new ArrayList<String>();
		
        int sum = list1.length+list2.length;
        int index = 0;
        HashMap listMap = new HashMap<String,Integer>();
        for(int i=0;i<list2.length;i++) {
        	listMap.put(list2[i], i);
        }
        for(int i=0; i<list1.length;i++) {
        	if(listMap.containsKey(list1[i])) {
        		if (i+(Integer)listMap.get(list1[i]) <sum) {
        			resultList.removeAll(resultList);
        			index=0;
        			resultList.add(list1[i]);
            		index++;
            		sum = i+(Integer)listMap.get(list1[i]);
        	}
        		else if (i+(Integer)listMap.get(list1[i]) ==sum) {
        			resultList.add(list1[i]);
            		index++;
            		sum = i+(Integer)listMap.get(list1[i]);
        	}
        		
        	}
        }
        return (String[]) resultList.toArray(new String[0]);
        
    }
	
	 public static  Node reverseList(Node head) {
	        List arrayList = new ArrayList<Node>();
	        while(head!=null) {
	            arrayList.add(head);
	            head = head.getNextNode();
	        }
	        System.out.println("arrayList " + arrayList.size());
	        for(int i=arrayList.size()-1; i>=1; i--) {
	        	Node node = (Node) arrayList.get(i);
	        	node.setNextNode((Node) arrayList.get(i-1));
	        }
	        ((Node)arrayList.get(0)).setNextNode(null);
	        head = (Node) arrayList.get(arrayList.size()-1);
	        
	        return head;
	        
	    }

	
	
}
