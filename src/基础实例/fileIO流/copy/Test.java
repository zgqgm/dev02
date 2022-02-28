package 基础实例.fileIO流.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        //准备源文件file和目标文件desktop；
        File file=new File("C:/Users/zgq/Desktop/测试文件");
        File desktop=new File("C:/Users/zgq/Desktop/copy测试文件");
        //准备输入流和输出流
        FileInputStream file1=new FileInputStream(file);
        FileOutputStream desktop1=new FileOutputStream(desktop);
        int content=-1;
        byte[] but=new byte[1024];
        while (-1!=(content=(file1.read(but)))){//读取
            desktop1.write(content);//写入
        }
        desktop1.close();//闭流（先进后出原则）
        file1.close();
    }
}
