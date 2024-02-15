package com.mapping.gmail.old.symbolList;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class MaptoJson {
    static ObjectMapper objectMapper=new ObjectMapper();

     public static void toJson( Map map) throws IOException {
         File file=new File(setOutputFile());
         objectMapper.writeValue(file,map);

    }

    private static String setOutputFile() {
        String fName="SymbolList.json";
        String path = "";
       return (path+fName);
    }

}
