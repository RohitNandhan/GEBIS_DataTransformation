//package com.mapping.gmail.Refoctored.Service;
//
//import com.mapping.gmail.Refoctored.DTO.MapToText;
//import com.mapping.gmail.Refoctored.Bean.ParmaExcel;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class DataConversion {
//
//    public  void printOutput(Map<Integer, ParmaExcel> mappedResult) throws IOException {
//        for(Map.Entry<Integer, ParmaExcel> mapEntry:mappedResult.entrySet()){
//            System.out.println(mapEntry.getKey());
//            for(String mail:mapEntry.getValue().getEmailID()){
//                System.out.print(mail+"; ");
//            }
//            System.out.println("\n\n-----------------------------------");
//        }
//    }
//
////    public   void printOutput(boolean flag){
////        for(Map.Entry<Integer,List<String>> mapEntry:mappedResult.entrySet()){
////            //System.out.println(mapEntry.getKey());
////            for(String mail:mapEntry.getValue()){
////                System.out.print(mail+"; ");
////            }
////            System.out.print(";");
////        }
////    }
//
////    public  void mapToJson(String fName,Map<Integer, ParmaExcel> mappedResult) throws IOException {
////        // String fileName=fName.replace(",","-");
////        File outputFile=new File("src/main/out/"+fName+".json");
////        DTO.toJson(outputFile,mappedResult);
////        //DTO.toJson();
////    }
//
//
//    public  List<Integer> stringToIntegerList(String values){
//        List<Integer> parmaList=new ArrayList<>();
//        String[] arr=values.split("[\\s,]+");
//        for(String a:arr){
//            parmaList.add(Integer.parseInt(a.trim()));
//        }
//        return parmaList;
//    }
//
//
////    public void mapToText(String fname, Map<Integer, ParmaExcel> sMap,Map<Integer,ParmaExcel> bMap ) throws IOException {
////        File outputFile=new File("src/main/out/"+fname+".txt");
////        MapToText.toText(outputFile,sMap,bMap);
////    }
////    public void mapToText(String fname, Map<Integer, ParmaExcel> sMap) throws IOException {
////        File outputFile=new File("src/main/out/"+fname+".txt");
////        MapToText.toText(outputFile,sMap);
//    }
//}
