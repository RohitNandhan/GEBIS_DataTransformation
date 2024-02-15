package com.mapping.gmail.old.symbolList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;

public class Main {

    static final File file=new File("src/main/java/com/mapping/gmail/old/symbolList/top-2000-valued-companies-with-ticker-symbols.xlsx");


    public static void main(String[] args) throws IOException, InvalidFormatException {
        DataMap dataMap=new DataMap(file);
        MaptoJson.toJson(dataMap.map);
    }
}
