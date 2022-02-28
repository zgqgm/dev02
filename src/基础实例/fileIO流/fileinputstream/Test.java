package 基础实例.fileIO流.fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        /**不要随意运行*/
        /*File file=new File("C:/Users/zgq/Desktop/测试文件夹/aaa.txt");// 准备文件
        FileInputStream fil=new FileInputStream(file);// 创建输入流，打开通道
        int content=fil.read();
        System.out.println((char)content);

        content=-1;
        while ((content= fil.read())!=-1){
            System.out.print((char) content);
        }

        // 缓冲数组
        byte[] buffer = new byte[1024];
        content=-1;
        // 读
        // 如果没有读到文件的末尾，就输出
        while (-1 != (content = fil.read(buffer))) {
            System.out.print(new String(buffer, 0, content, "UTF-8"));
        }
        fil.close();//闭流*/
    }
}
