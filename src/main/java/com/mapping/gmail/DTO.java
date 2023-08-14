package com.mapping.gmail;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class DTO {

   static ObjectMapper objectMapper=new ObjectMapper();

    public static void toJson(File file, Map map) throws IOException {
        objectMapper.writeValue(file,map);
    }

    public static void toText(File file, Map<Integer, List<String>> map)throws IOException{
        FileWriter fileWriter=new FileWriter(file);
        for (List<String> innerList : map.values()) {
            for (String value : innerList) {
                //System.out.println(innerList);
               fileWriter.append(value).append(";");
            }
        }fileWriter.close();
    }
    public static void toTextMutipleParmas(File file, Map<Integer, List<String>> map)throws IOException{
        FileWriter fileWriter=new FileWriter(file);
        for (Integer parma : map.keySet()) {
            fileWriter.write(parma+": \n");
            for (String value : map.get(parma)) {
                //System.out.println(innerList);
                fileWriter.append(value).append(";");
            } fileWriter.write("\n \n");
        }fileWriter.close();
    }

}
