package gm.util;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlUtil {
  public URL getUrl(String file){

      // user.dir 获得用户当前工作目录
      String property = System.getProperty("user.dir");
      System.out.println(property);
      URL url = null;
      //截取路径
      String[] split = property.split("artifacts");
      String imagePath = "";
      try {
          //------------------------------------jar包获取url代码块 start--------------------
          if (property.contains("artifacts")){
              //获得绝对路径
               imagePath= split[0]+"production\\snake\\gm\\static\\images\\"+file;
              //转为file协议的URL对象
              url = new URL("file:\\"+imagePath);
          }
          //---------------------------------jar包获取url代码块 end--------------------------

          //---------------------------------IDEA直接运行代码块 start------------------------
          //如果有practiseproduction则可能是在IDEA直接运行，所以尝试相对路径获得URL对象
          if (imagePath.equals("")){
              url = UrlUtil.class.getResource("../static/images/" + file);
          }
          //---------------------------------IDEA直接运行代码块 end------------------------

          //--------------------------------如果是包含snake则认为是EXE运行 start-----------------
          if (split[0].contains("snake")){
              String exePath = "file:\\"+property+"\\data\\static\\images\\"+file;
              url = new URL(exePath);
          }
          //--------------------------------如果是包含snake则认为是EXE运行 end-----------------
      } catch (MalformedURLException e) {
          e.printStackTrace();
      }





      return url;
  }
}
