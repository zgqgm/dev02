package homework;
import java.util.Scanner;
public class m11d20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode l1= new ListNode();
        ListNode l2= new ListNode();
        ListNode li=l1;
       // ListNode ls=l2;
        ListNode l11=new ListNode(9);
        ListNode l12=new ListNode(8);
        ListNode l13=new ListNode(3);
        ListNode l14=new ListNode(5);
        ListNode l21=new ListNode(2);
        ListNode l22=new ListNode(5);
        ListNode l23=new ListNode(1);
        ListNode l24=new ListNode(9);
        l2.next=l21;
        l21.next=l22;
        l22.next=l23;
        l23.next=l24;
        l1.next=l11;
        l11.next=l12;
        l12.next=l13;
        l13.next=l14;

        ListNode pl=mergeTwoLists(l1,l2);


        while (pl.next!=null){
            pl=pl.next;
            System.out.print(pl.val+" ");
        }
        sc.close();
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode LL=l1;//拿到l1的副本（为了保护l1不被修改）
        while (LL.next!=null){
            LL=LL.next;
            if (LL.next==null){//找到最后一个节点并指向l2
                LL.next=l2.next;
                break;
            }
        }
        ListNode ji=l1;
        int num;
        while (ji.next!=null){
            ListNode nu=l1;
            while (nu.next!=null){
                if (nu.val>nu.next.val){//换位
                    num=nu.val;
                    nu.val=nu.next.val;
                    nu.next.val=num;
                }
                nu=nu.next;
            }
            ji=ji.next;
        }
        return l1;
    }
}
class ListNode {
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
