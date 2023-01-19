package com;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Task3 {

    public static JSONObject parsJson(JSONObject object, Map<Long, String> m){
        //ArrayList
        ArrayList<Object> keyFromObject = new ArrayList<>();
        Iterator iter = object.keySet().iterator();
        while(iter.hasNext()){
            keyFromObject.add(iter.next());
        }

        for (int i = 0; i < keyFromObject.size(); i++) { //Смотрим все ключи
            if(object.get(keyFromObject.get(i)) instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) object.get(keyFromObject.get(i));
                for (int j = 0; j < jsonArray.size(); j++) {
                    parsJson((JSONObject) jsonArray.get(j),m);
                }
            } else {
                if(object.get("value") != null){
                    object.put("value", m.get((Long) object.get("id") ));

                }
            }
        }
        return object;
    }



    public static void main(String[] args) throws Exception{
        String pathOne = args[0];
        String pathTwo = args[1];
        Reader readerOne = new FileReader((pathOne));
        Reader readerTwo = new FileReader(pathTwo);

        //parser readerTwo: put all id and value in map.
        JSONParser parser2 = new JSONParser();
        JSONObject object2 = (JSONObject) parser2.parse(readerTwo);
        JSONArray jsonArray2 = (JSONArray) object2.get("values");

        Map<Long, String> map = new HashMap<>();

        for (int i = 0; i < jsonArray2.size(); i++) {
            JSONObject object3 = (JSONObject) jsonArray2.get(i);
            map.put((Long) object3.get("id"),(String) object3.get("value"));
        }

        //parser two file
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(readerOne);
        JSONObject jsonObject = parsJson(object, map);

        //save to report.json
        FileWriter fw = new FileWriter("report.json");
        fw.write(jsonObject.toJSONString());
        fw.close();


    }

}
