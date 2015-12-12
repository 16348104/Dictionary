package test;


import model.Word;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.enterprise.inject.New;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/12/12.
 */
public class JsonTest {
    public static void main(String[] args) {
        String jsonstring="{\"k1\":\"v1\",\"k2\":2,\"k3\":null}";
        JSONObject jsonObject = new JSONObject(jsonstring);
//        System.out.println(jsonObject.get("k3"));
//        System.out.println(jsonObject.toString(2));
        Word w = new Word(1,"eng","中");
        JSONObject jsonObject1 = new JSONObject(w);
//        System.out.println(jsonObject1);
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(123);
        jsonArray.put(false);
        jsonArray.put(jsonObject);
        jsonArray.put(jsonObject1);
        System.out.println("");
//        System.out.println(jsonArray.toString(3));//数组
        Map<String, Object> map = new HashMap<>();
        map.put("k1", jsonArray);
        map.put("k2",jsonObject);
        map.put("k3", jsonObject1);
//        System.out.println(new JSONObject(map).toString(3));//对象

        List<Object> list = new ArrayList<>();
        list.add(456);
        list.add("string");
        list.add(w);
        list.add(jsonObject);
        list.add(jsonObject1);
        System.out.println(new JSONArray(list).toString(3));//数组

    }
}
