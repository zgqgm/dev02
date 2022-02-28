package homework;

public class m11d29 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        head.next=l1;
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        head= deleteDuplicates(head);
        while (head.next!=null){
            head=head.next;
            System.out.print(head.val+" ");

        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
       /* 解题思路
        通过递归对当前节点与当前节点的下一节点进行比较，将判断后的最终地址返回给当前节点的上一节点*/
        if(head == null || head.next == null){
            return head;
        }
        //通过递归逐层深入，找到最后一个节点并返回位上一层的head.next;
        head.next = deleteDuplicates(head.next);
        //比较本层的head对应的值与下一层head.next的值之间的关系。如果想等则将下一层的地址值赋给本层
        if(head.val == head.next.val) head = head.next;
        return head;
    }
}

