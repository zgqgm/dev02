package dean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class DemoA {
    @Test
    public void testBean() {
        Person person = new Person("易烊千玺",21,true);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonStr = mapper.writeValueAsString(person);
            System.out.println(jsonStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testList() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("迪丽热巴",22,false));
        list.add(new Person("古力娜扎",29,false));
        ObjectMapper mapper = new ObjectMapper();
        try {
            String JsonStr = mapper.writeValueAsString(list);
            System.out.println(JsonStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testMap() {
        HashMap<String,Person> hashMap = new HashMap<>();
        hashMap.put("person1",new Person("易烊千玺",21,true));
        hashMap.put("person2",new Person("欧阳娜娜",22,false));
        hashMap.put("person3",new Person("易烊千玺",21,false));
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonStr = objectMapper.writeValueAsString(hashMap);
            System.out.println(jsonStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testJson() {
        String str = "{\"name\":\"古力娜扎\",\"age\":25,\"gender\":false}";
        ObjectMapper mapper = new ObjectMapper();
        try {
            Person person = mapper.readValue(str,Person.class);
            System.out.println(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testJsonIgnore() {
        Person person = new Person("易烊千玺",21,true);
        person.setBirthday(new Date());
        ObjectMapper mapper = new ObjectMapper();
        try {
            String JsonStr = mapper.writeValueAsString(person);
            System.out.println(JsonStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
