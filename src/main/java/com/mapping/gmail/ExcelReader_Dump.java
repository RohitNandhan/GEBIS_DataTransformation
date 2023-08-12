//package com.mapping.gmail;
//
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.*;
//
//public class ExcelReadercopy {
//
//    public static void readExcel(File file) throws IOException, InvalidFormatException {
//
//        Workbook workbook=new XSSFWorkbook(file);
//
//        Sheet sheet=workbook.getSheetAt(0);
//       List<String> arr=new ArrayList<>();
//        Map<Integer, List<String>> map=new HashMap<>();
//        for(Row row:sheet){
//           // System.out.println(ro
//            //if(row.toString().equals("SupplierId")){
//            if(row.getRowNum()==0){
//                continue;
//            }
//            Cell Kcell=row.getCell(0);
//            Cell Ecell=row.getCell(6);
//            String Email=  Ecell.toString();
//            Integer parmaID= Integer.valueOf(Kcell.toString());
//            if(Kcell!=null && Ecell!=null ){
//                if(map.containsKey(parmaID)){
//                    map.get(parmaID).add(Email);
//                    map.put(parmaID,map.get(parmaID));
//                }else {
//
//                    map.put(parmaID,new ArrayList<String>(Arrays.asList(Email)));
//                }
//                //if(cell.toString().contains("h"))
////                System.out.print(Kcell.toString()+"\t");
////                System.out.print(Ecell.toString()+"\t");
//            }
//          //  System.out.println();
//        //}
//        }
//        workbook.close();
//
//        for(Map.Entry<Integer,List<String>> mapEntry:map.entrySet()){
//            System.out.println(mapEntry.getKey());
//            for(String mail:mapEntry.getValue()){
//                System.out.print(mail+"; ");
//            }
//            System.out.println("\n\n-----------------------------------");
//        }
//
//
////        for(Row row:sheet){
////            // System.out.println(ro
////            //if(row.toString().equals("SupplierId")){
////            Cell cell=row.getCell(2);
////            for(cell:row){
////                //if(cell.toString().contains("h"))
////                System.out.print(cell.toString()+"\t");
////            }
////            System.out.println();
////            //}
////        }
////        workbook.close();
//
//
//    }
//}
