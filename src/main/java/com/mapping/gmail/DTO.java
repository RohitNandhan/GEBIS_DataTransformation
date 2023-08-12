package com.mapping.gmail;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class DTO {

   static ObjectMapper objectMapper=new ObjectMapper();

    public static void toJson(File file, Map map) throws IOException {
        objectMapper.writeValue(file,map);
    }

}
