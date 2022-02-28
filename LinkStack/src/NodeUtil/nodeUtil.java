package NodeUtil;

import com.sun.jdi.event.ExceptionEvent;

public class nodeUtil {
    //有效节点数。
    public int size = 0;
    //头结点
    public Node head;
    //尾节点
    public Node tail;
    //节点
    static class Node{
        int value;
        Node next;
        Node prev;
    }
    public void AddLast(int value){
        //创建一个新节点
        Node nodeNew = new Node();
        //node存储尾节点
        Node node = tail;
        //新节点前指针指向尾节点
        nodeNew.prev = node;
        //给新节点赋值
        nodeNew.value = value;
        //新节点后指针为空
        nodeNew.next = null;
        //尾节点为新节点
        tail = nodeNew;
        //如果没有尾节点
        if (node == null){
            //头结点是新节点
            head = nodeNew;
            //如果有尾节点
        }else {
            //尾节点后指针指向新节点
            node.next = nodeNew;
        }
        //有效节点个数加1
        size++;
    }
    public void AddFirst(int value){
        //创建一个新节点
        Node nodeNew = new Node();
        //node存储头结点
        Node node = head;
        //新节点的前指针为空
        nodeNew.prev = null;
        //给新节点赋值
        nodeNew.value = value;
        //新节点的后指针指向头结点
        nodeNew.next = node;
        //头结点指向新节点
        head = nodeNew;
        //如果头结点为空
        if (node == null){
            //尾节点指向新节点
            tail = nodeNew;
        //若不为空
        }else{
            //头结点的前指针指向新指针
            node.prev = nodeNew;
        }
        //有效节点个数加1
        size++;
    }
    public void AddIndex(int index,int value){
        //如果下标等于0，则为头插
        if (index == 0){
            AddFirst(value);
        //如果下标等于有效节点个数减1，则为尾插
        }else if (index == size-1){
            AddLast(value);
        //如果下标大于等于有效节点个数，则为错误插入指令
        }else if (index > size-1 || index < 0){
            System.out.println("错误插入指令");
        }else {
            //拿到指定下标对应节点的上一个节点
            Node first = nodeIndex(index);
            //拿到下标对应的节点
            Node node = first.next;
            //创建一个新节点
            Node nodeNew = new Node();
            //新节点的前指针指向下标节点的上一个节点
            nodeNew.prev = first;
            //给新节点赋值
            nodeNew.value = value;
            //新节点的后指针指向下标对应的节点
            nodeNew.next = node;
            //下标对应节点的上一个节点的后指针指向新节点
            first.next = nodeNew;
            //如果下标对应的节点为空，则新节点为尾节点
            if (node == null){
                tail = nodeNew;
            }else {
                //下标对应的节点的前指针指向新节点
                node.prev = nodeNew;
            }
        }
        //有效节点个数加1
        size++;
    }
    public boolean removerLast(){
        //拿到尾节点
        Node node = tail;
        if (node != null){
            //拿到尾节点的上一个节点
            Node prev = node.prev;
            if (prev == null){
                head = null;
            }else {
                //尾节点为尾节点的上一个节点
                tail = prev;
                //尾节点的上一个节点的后指针为null
                prev.next = null;
            }
            //尾节点的前指针为null
            node.prev = null;
            return true;
        }
        return false;
    }
    public boolean removerFirst(){
        //获得头结点
        Node node = head;
        if (node != null){
            //拿到头结点的下一个节点
            Node next = head.next;
            if (next == null){
                tail = null;
            }else {
                //头结点的下一个节点的前指针为空
                next.prev = null;
                //头结点为头结点的下一个节点
                head = next;
            }
            //头结点的后指针为null
            node.next = null;
            return true;
        }
        return false;
    }
    public boolean removerIndex(int index){
        if (index == 0){
            return removerFirst();
        }else if (index == size-1){
            return removerLast();
        }else if (index > 0 && index < size){
            //拿到指定下标对应节点的上一个节点
            Node prev = nodeIndex(index);
            //拿到指定下标对应的节点
            Node node = prev.next;
            //拿到指定下标对应节点的下一个节点
            Node next = node.next;
            if (next == null){
                //尾节点为指定下标对应节点的上一个节点
                tail = prev;
            }else {
                //指定下标对应节点的下一个节点的后指针指向指定下标对应节点的上一个节点
                next.prev = prev;
            }
            //指定下标对应节点的上一个节点的后指针指向指定下标对应节点的下一个节点
            prev.next = next;
            //指定下标对应节点的前后指针为空
            node.prev = null;
            node.next = null;
            return true;
        }
        return false;
    }
    public boolean removerValue(int value){
        //拿到下标对应的节点
        Node index = nodeValue(value);
        if(index != null){
            //拿到下标对应的节点的上一个节点
            Node prev = index.prev;
            //拿到下标对应的节点的下一个节点
            Node next = index.next;
            if (prev == null){
                head = next;
            }else {
                prev.next = next;
            }
            if (next == null){
                tail = prev;
            }else {
                next.prev = prev;
            }
            index.prev = null;
            index.next = null;
            return true;
        }
        return false;
    }
    public int replaceIndex(int index,int value){
        Node node;
        if (index == 0){
            node = head;
        }else if (index == size-1){
            node = tail;
        }else {
            Node perv = nodeIndex(index);
            node = perv.next;
        }
        if (node != null){
            int num = node.value;
            node.value = value;
            return num;
        }
        return -1;
    }
    public int selectValue(int index){
        if (index == 0){
            return head.value;
        }
        if (index == size-1){
            return tail.value;
        }
        Node node = nodeIndex(index);
        Node next = node.next;
        return next.value;
    }
    public int selectIndex(int value){
        Node node = head;
        for (int i = 0;i < size;i++){
            if (node.value == value){
                return i;
            }else {
                node = node.next;
            }
        }
        return -1;
    }
    private Node nodeValue(int value){
        Node node = head;
        for (int i = 0;i < size;i++){
            if (node.value == value){
               return node;
            }else {
                node = node.next;
            }
        }
        return node;
    }
    private Node nodeIndex(int index){
        //获得头结点
        Node node = head;
        //拿到指定下标对应节点的上一个节点
        for (int i = 0;i < index-1; i++){
            node = node.next;
        }
        return node;
    }
    public void ForNode(){
        for (Node node = head;node.next != null;node = node.next){
            System.out.println(node.value);
        }
        System.out.println(tail.value);
    }
}
