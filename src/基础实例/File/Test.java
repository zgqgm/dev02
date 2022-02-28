package 基础实例.File;

import java.io.File;
import java.io.FilenameFilter;

public class Test {
    public static void main(String[] args) {
        //File file = new File("./src/a.txt");//相对路径（src文件夹下的a.txt文件（若没有则运行后自动创建（若没有显示刷新即可）））
        /**
         * *****************不 要 随 意 运 行*************************
         */
        // 创建新的文件：createNewFile()
        // 创建文件夹： mkdir()
        // 创建多级文件夹：mkdirs()
        // 重命名或者移动、 重命名并移动：renameTo(File dest)
        //删除指定File对象对应的文件或者文件夹、 不经过回收站，没有办法撤销：delete()
        //退出时删除：deleteOnExit()
        /*System.out.println("获取路径：" + file.getPath());
        System.out.println("获取名称：" + file.getName());
        System.out.println("获取上级路径：" + file.getParent());
        System.out.println("获取绝对路径：" + file.getAbsolutePath());
        System.out.println("获取路径：" + file.length());
        System.out.println("获取路径：" + file.lastModified());
        System.out.println("是否是文件：" + file.isFile());
        System.out.println("是否是文件夹：" + file.isDirectory());
        System.out.println("是否存在：" + file.exists());
        System.out.println("是否是绝对路径：" + file.isAbsolute());
        System.out.println("是否是隐藏文件或文件夹：" + file.isHidden());*/

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//格式模板

       // String format = sdf.format(file.lastModified());//将时间戳转为上述格式。（最后修改时间）

       // System.out.println(format);

        /*File[] listRoots = File.listRoots();//获取盘符（咱的电脑只有c盘）

        for (File file : listRoots) {
            System.out.println(file);
        }*/
        /**下面的代码可在桌面创建 测试文件夹 后自行选择执行*/
        File file=new File("C:/Users/zgq/Desktop/测试文件夹");//桌面上的"测试文件夹"这个文件夹已删，运行需要自己在创建一个（里面要有文档，文件夹）
        String[] list= file.list();//将获取到file中的文档，文件夹名存起来（string类型）
        /*for (String name: list){//遍历
            System.out.println(name);
        }*/
        File[] listFiles = file.listFiles();//将获取到file中的文档，文件夹名的绝对地址存起来（File类型）
        /*for (File temp : listFiles) {
            System.out.println(temp);
            String absolutePath = temp.getAbsolutePath();//拿到绝对地址
            int lastIndexOf = absolutePath.lastIndexOf('\\');//查找字符串中出现字符的最后一次的下标
            String substring = absolutePath.substring(lastIndexOf + 1);//从lastIndexOf + 1向后截取
            System.out.println(substring);
        }*/
        //deleteAll(file);//执行后，将测试文件夹内的所有文件删除

        for (File temp : listFiles){//输出文件夹中所有已指定后缀结尾的文件名
            if (temp.isFile()){//是否是文件
                String name=temp.getName();//获得文件名
                if (name.endsWith(".txt")){//是否已“.txt”为后缀
                    System.out.println(name);
                }
            }
        }

        /**文件名过滤器的用法*///与57行效果（应该）一样
        FilenameFilter filter = new FilenameFilter() {
            /**
             * @param dir 父级路径
             * @param name 子级文件名或者文件夹名
             */
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir,name).isFile()&&name.endsWith(".txt");//是否是文件和是否已“.txt”为后缀
            }
        };
        String[] listFilter= file.list(filter);
        for (String temp : listFilter){
            System.out.println(temp);
        }
    }
    public static void deleteAll(File file){
        if (file.isFile()){//是否是文件
            file.delete();//删除文件（不经回收站，不可复原（删除一定要慎重））
        }else if (file.isDirectory()){//是否是文件夹
            File[] listFiles=file.listFiles();// 获取文件夹中的所有子文件和文件夹(绝对路径)
            for (File temp : listFiles){
                deleteAll(temp);//递归（找到最内层文件夹）
                temp.delete();//删除空文件夹
            }
        }
    }
}
