package hashtableUtil;

public class test {
    public static void main(String[] args) {
        HashtableUtil<Object, Object> hashtable = new HashtableUtil<>();
        hashtable.put(1, 1);
        hashtable.put(2, 2);
        hashtable.put(11, 3);
        hashtable.put(11, 4);
        hashtable.put("3", "4");
        hashtable.put(12, 5);
        hashtable.put("小敏", 6);
        hashtable.remove(12);
        System.out.println(hashtable.get("小敏"));
        System.out.println(hashtable.size());
    }
}
