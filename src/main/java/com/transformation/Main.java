package com.transformation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import com.fasterxml.jackson.core.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println(" -------------");

        File fr=new File("src/main/resources/Input.txt");

        List<String> extractList=ExtractContent.Extract(fr);

           // List<Entity> lst=MappingData.mapDataToEntity(extractList);



    }
}