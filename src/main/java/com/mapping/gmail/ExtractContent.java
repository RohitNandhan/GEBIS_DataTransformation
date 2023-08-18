package com.mapping.gmail;

import com.mapping.gmail.CustomException.ParmaNotFoundException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ExtractContent  {

     List<Integer> parmaList=new LinkedList<>();
     Map<Integer, List<String>> mappedResult;

     File inputFile;
     File outputFile;

    public  void readExcel(File file, List<Integer> ParmaNumber) throws IOException, InvalidFormatException, ParmaNotFoundException {
         ExcelReader excelReaderUp=new ExcelReader();
        mappedResult=excelReaderUp.readExcel(file,ParmaNumber);
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
        String[] arr=values.split("[\\s,]+");
        for(String a:arr){
            parmaList.add(Integer.parseInt(a.trim()));
        }
        return parmaList;
    }

    public void mapToText(String fname) throws IOException {
        File outputFile=new File("src/main/out/"+fname+".txt");
        DTO.toText(outputFile,mappedResult);
    }

    public void mapToTextMultipleParmas(String fname) throws IOException {
        File outputFile=new File("src/main/out/"+fname+".txt");
        DTO.toTextMutipleParmas(outputFile,mappedResult);
    }
}
