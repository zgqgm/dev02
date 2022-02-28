package hashtableUtil;

public class HashtableUtil<k,v> {
    private Node<k,v>[] array = new Node[10];
    private int size;
    private int hash(Object key){
        return (key == null) ? 0 : Math.abs(key.hashCode())%array.length;
    }
    class Node<k,v>{
        int hashcode;
        k key;
        v value;
        Node<k,v> next;
        public Node(k key,v value ,Node<k,v> next){
            this.key=key;
            this.value = value;
            this.next = next;
            this.hashcode = hash(key);
        }
    }
    v put(k key,v value){
        int hash = hash(key);
        Node<k, v> newnode = new Node<k, v>(key, value, null);
        Node<k,v> node = array[hash];
        if (node == null){
            array[hash] = newnode;
            size++;
            return null;
        }
        if (node.key.equals(key)){
            v oldValue =node.value;
            node.value=value;
            return oldValue;
        }
        Node<k,v> parent = null;
        while (node !=null){

            if (node.key.equals(key)){
                v oldValue =node.value;
                node.value=value;
                return oldValue;
            }
            parent = node;
            node = node.next;
        }
        parent.next = newnode;
        size++;
        return null;
    }
    v remove(Object key){
        int hash = hash(key);
        Node<k,v> node = array[hash];
        if (node == null){
            return null;
        }
        if (node.key.equals(key)){
            if (node.next == null){
                array[hash] = null;
            }else {
                array[hash] = node.next;
            }
            size--;
            return node.value;
        }
        Node<k,v> parent = null;
        while (node.next !=null){
            parent = node;
            node = node.next;
            if (node.key.equals(key)){
                parent.next =node.next;
                size--;
                return node.value;
            }
        }
        return null;
    }
    v get(Object key){
        int hash = hash(key);
        Node<k,v> node = array[hash];
        if (node == null){
            return null;
        }
        while (node !=null){
            if (node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
    int size(){
        return size;
    }
}
