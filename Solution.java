package Bypass;

//Sort List Problem

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }
  }
public class Solution {
    ListNode node;
//    public  ListNode sortList(ListNode head) {
//        return mergeSort(head);
//    }
//    private ListNode mergeSort(ListNode head)
//    {
//        if (head==null||head.next==null)
//            return head;
//
//        var right=SplitNode(head);
//        head=mergeSort(head);
//        right=mergeSort(right);
//        head=merge(head,right);
//        return head;
//    }
//    private ListNode merge(ListNode left,ListNode right) {
//        ListNode temp = new ListNode(-1);
//        ListNode tail = temp;
//        while (left != null && right != null)
//        {
//            if (left.val<= right.val)
//            {
//                tail.next=left;
//                left=left.next;
//            }else {
//                right.next=right;
//                right=right.next;
//            }
//            //tail=tail.next;
//        }
//        if (left!=null)
//            tail.next=left;
//        if (right!=null)
//            tail.next=right;
//
//        return temp.next;
//    }
//    private ListNode SplitNode(ListNode head)
//    {
//        var slow=head;
//        var fast=head;
//        while (fast.next!=null && fast.next.next!=null)
//        {
//            slow=slow.next;
//            fast=fast.next.next;
//        }
//        fast=slow.next;
//        slow.next=null;
//        return fast;
//    }
public ListNode sortList(ListNode head) {
    return mergeSort(head);
}

    private ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode right = splitList(head);

        head = mergeSort(head);
        right = mergeSort(right);

        head = merge(head, right);
        return head;
    }

    private ListNode merge(ListNode left, ListNode right){
        var dum = new ListNode(-1);
                var tail = dum;

        while(left != null && right != null){
            if(left.val <= right.val){
                tail.next = left;
                left = left.next;
            }else{
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        if(left != null){
            tail.next = left;
        }

        if(right != null){
            tail.next = right;
        }

        return dum.next;
    }

    private ListNode splitList(ListNode head){
        var slow = head;
        var fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        slow.next = null;

        return fast;
    }

    public void setNode(ListNode nod) {
        if (node==null)
        {
            node=nod;
        }
        else {
            while(node.next != null) {
                //this.node = nod;
                //node = node.next;
                node.next = nod;
                nod=nod.next;
            }
        }
    }
    public void Print()
    {

        while (node.next!=null)
        {
            System.out.println(node.val);
            node=node.next;
        }
        System.out.println(node.val);
    }
    public static void main(String[] args) {
        var sol=new Solution();
        //sol.setNode(new ListNode(5,new ListNode(6,new ListNode(7,null))));
        //sol.Print();
        var list=new ListNode(6,new ListNode(2,new ListNode(9,new ListNode(4,null))));
        sol.setNode(list);
        sol.Print();
        System.out.println("------------------");
        sol.sortList(list);
        sol.Print();
    }
}
