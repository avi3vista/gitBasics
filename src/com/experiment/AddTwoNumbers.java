package com.experiment;

public class AddTwoNumbers {
  public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
   }
	
  public static void main(String[] args) {
    ListNode l1 = new ListNode(9);
    l1.next = new ListNode(9);
    l1.next.next = new ListNode(9);
    
    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);

    
    ListNode res = addTwoNumbers(l1, l2);
    
    while(res!=null) {
      System.out.print(res.val + "--> ");
      res=res.next;
    }

	}
  
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      
      ListNode res = null;
      ListNode head = null;
      ListNode prev = null;
      int carry = 0;
      int curSum = 0;
      
      while(l1!=null && l2!=null) {
        curSum = l1.val+l2.val + carry;
        if(curSum>=10) {
          curSum = curSum-10;
          carry=1;
        }
        else {
          carry=0;
        }
        res = new ListNode(curSum);
        if(head == null) {
          head = res;
        }
        if(prev!=null) {
          prev.next = res;
        }
        prev = res;
        l1=l1.next;
        l2=l2.next;
      }
      
      if(l1==null) {
        while(l2!=null) {
          curSum = carry + l2.val;
          if(curSum>=10) {
            curSum = curSum-10;
            carry=1;
          }
          else {
            carry=0;
          }
          res = new ListNode(curSum);
          if(head == null) {
            head = res;
          }
          if(prev!=null) {
            prev.next = res;
          }
          prev = res;
          l2=l2.next;
        }
      }
      
      if(l2==null) {
        while(l1!=null) {
          curSum = carry + l1.val;
          if(curSum>=10) {
            curSum = curSum-10;
            carry=1;
          }
          else {
            carry=0;
          }
          res = new ListNode(curSum);
          if(head == null) {
            head = res;
          }
          if(prev!=null) {
            prev.next = res;
          }
          prev = res;
          l1=l1.next;
        }
      }
      
      if(carry==1) {
        res = new ListNode(1);
        if(head == null) {
          head = res;
        }
        if(prev!=null) {
          prev.next = res;
        }
        prev = res;
      }
      
      
      return head;
    
  }

}
