package 基础实例.fileIO流.buffer;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        //缓冲字节输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("./src/ccc.txt")));
        int content = -1;
        byte[] buf = new byte[1024 * 8];
        while (-1 != (content = bis.read(buf))) {
            System.out.println(new String(buf, 0, content));
        }
        //缓冲字符输入流
        BufferedReader br = new BufferedReader(new FileReader(new File("./src/ccc.txt")));
        content = -1;
        char[] bu = new char[1024 * 8];
        while (-1 != (content = br.read(bu))) {
            System.out.println(new String(bu, 0, content));
        }
        //缓冲字节输出流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("./src/ddd.txt")));
        bos.write("男同学越来越帅，不要女同学了".getBytes());
        //缓冲字符输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("./src/ddd.txt"), true));
        bw.write(20320);
        bis.close();
    }
}
