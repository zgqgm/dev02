package 基础实例.封装;

public class Other {
    public static void main(String[] args){
        My my=new My();//My类中的My构造方法不需要动手调用即可使用。
        my.setDiary("日记内容延续");
        String diary= my.getDiary();
        System.out.println(diary);
        my.setMarried(false);
        my.printf();
    }
}
