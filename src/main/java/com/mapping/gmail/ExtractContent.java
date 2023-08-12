package com.mapping.gmail;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ExtractContent {

     List<Integer> parmaList=new LinkedList<>();
     Map<Integer, List<String>> mappedResult;

     File inputFile;
     File outputFile;
    public  void readExcel(File file,List<Integer> ParmaNumber) throws IOException, InvalidFormatException {
         mappedResult=ExcelReader.readExcel(file,ParmaNumber);
    }

    public  void printOutput() throws IOException {
        for(Map.Entry<Integer,List<String>> mapEntry:mappedResult.entrySet()){
            System.out.println(mapEntry.getKey());
            for(String mail:mapEntry.getValue()){
                System.out.print(mail+"; ");
            }
            System.out.println("\n\n-----------------------------------");
        }
    }

    public   void printOutput(boolean flag){
        for(Map.Entry<Integer,List<String>> mapEntry:mappedResult.entrySet()){
            //System.out.println(mapEntry.getKey());
            for(String mail:mapEntry.getValue()){
                System.out.print(mail+"; ");
            }
            System.out.print(";");
        }
    }

    public  void mapToJson(String fName) throws IOException {
       // String fileName=fName.replace(",","-");
        File outputFile=new File("src/main/out/"+fName+".json");
        DTO.toJson(outputFile,mappedResult);
        //DTO.toJson();
    }


    public  List<Integer> stringToIntegerList(String values){
        String[] arr=values.split(",");
        for(String a:arr){
            parmaList.add(Integer.parseInt(a.trim()));
        }
        return parmaList;
    }
}
