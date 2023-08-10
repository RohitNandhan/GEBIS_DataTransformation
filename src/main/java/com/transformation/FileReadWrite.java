package com.transformation;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReadWrite {

   static List<String> readList;

    public static List<String> readFile(File file){
        String dataRow;
        List<String> list=new LinkedList<>();
        String pattern = "\\d{5}+[\\s\\S\\p{P}]+Outbound";
        Pattern p=Pattern.compile(pattern);
        try{
            BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            while((dataRow= bufferedReader.readLine())!=null){
               // String record=dataRow.
                Matcher m=p.matcher(dataRow);
                m.find();
                String record=m.group().replace("/Outbound","");
                list.add(record);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            readList=list;
        }

        return list;
    }

    public static void writeFile(File file,List<String> objectList){

        try {
            FileWriter fileWriter=new FileWriter(file);
            for(String obj:objectList){
                fileWriter.append(obj+"\n");

            }  fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeFileJson(File file,List<String> objectList ){
        try {
            List<Entity> entityList = new LinkedList<>();
            entityList = mapDataToEntity(objectList, entityList);

            ObjectMapper om=new ObjectMapper();
            om.writeValue(file,entityList);
                    }
            catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static  List<Entity> mapDataToEntity(List<String> lst,List<Entity> entityList) {


        for (String s : lst) {

            String idRegx = "[\\d]+";
            String nameRegx = "[^\\d][\\s\\S]+";
            Pattern idPattern = Pattern.compile(idRegx);
            Pattern namePattern = Pattern.compile(nameRegx);
            Matcher idMatcher = idPattern.matcher(s);
            Matcher nameMatcher = namePattern.matcher(s);
            idMatcher.find();
            String ID = idMatcher.group().trim();
            nameMatcher.find();
            String Name = nameMatcher.group().trim();

            entityList.add(new Entity(ID, Name));

        }
        return entityList;



    }
}
