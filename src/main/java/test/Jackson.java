package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.Word;
import sun.java2d.pipe.SpanIterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/12/12.
 */
public class Jackson {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        Word word = new Word(1, "EHG", "中");
        List<Object> li = new ArrayList<>();
        li.add(147);
        li.add("sss");
        li.add(word);
        System.out.println();
        Map<String, Object> map = new HashMap<>();
        map.put("k1", li);
        map.put("k2", true);
        try {
            String json = objectMapper.writeValueAsString(word);
            System.out.println(json);
//           Word word1 = objectMapper.readValues(json, Word.class);
//            System.out.println(json.getChinese());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
