package xml;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        //准备一个对象
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File("C:\\Users\\zgq\\practise\\studyXML\\src\\student.xml"));
            //获取根元素
            Element rootElement = document.getRootElement();
            System.out.println(rootElement.getName());
            List<Element> elements = rootElement.elements();
            for (Element element : elements) {
                System.out.println(element.getName()+":"+element.attribute("id").getValue());
                List<Element> list = element.elements();
                for (Element child : list) {
                    System.out.println(child.getName()+":"+child.getText());
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
