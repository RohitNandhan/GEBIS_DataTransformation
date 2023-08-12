package com.mapping.gmail;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ExcelReader {

    public static Map<Integer, List<String>> readExcel(File file) throws IOException, InvalidFormatException {

        Workbook workbook = new XSSFWorkbook(file);

        Sheet sheet = workbook.getSheetAt(0);
        List<String> arr = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
            Cell Kcell = row.getCell(0);
            Cell Ecell = row.getCell(6);
            String Email = Ecell.toString();
            Integer parmaID = Integer.valueOf(Kcell.toString());
            if (Kcell != null && Ecell != null) {
                if (map.containsKey(parmaID)) {
                    map.get(parmaID).add(Email);
                    map.put(parmaID, map.get(parmaID));
                } else {
                    map.put(parmaID, new ArrayList<String>(Arrays.asList(Email)));
                }
            }

        }
        workbook.close();
        return map;
    }

        public static Map<Integer, List<String>> readExcel(File file, Integer ParmaNumber) throws IOException, InvalidFormatException {

            Workbook workbook=new XSSFWorkbook(file);

            Sheet sheet=workbook.getSheetAt(0);
            List<String> arr=new ArrayList<>();
            Map<Integer, List<String>> map=new HashMap<>();
            int parmaIndex = -1,emailsIndex=-1;
            String Email;
            Integer parmaID;
            for(Row row:sheet){

                if(row.getRowNum()==0){

                    int[] indexs=getParmaIndex(row);
                    parmaIndex=indexs[0];
                    emailsIndex=indexs[1];
                    continue;
                }
                Cell cellPamraID=row.getCell(parmaIndex);
                Cell cellEmail=row.getCell(emailsIndex);
                 Email=  cellEmail.toString();
                 parmaID = Integer.valueOf(cellPamraID.toString());
                if(cellPamraID!=null && cellEmail!=null ) {
                   if (parmaID.equals(ParmaNumber)) {

                        if (map.containsKey(parmaID)) {
                            map.get(parmaID).add(Email);
                            map.put(parmaID, map.get(parmaID));
                        } else {
                            map.put(parmaID, new ArrayList<String>(Arrays.asList(Email)));
                        }
                    }
                }

            } workbook.close();

            return map;
    }

    public static Map<Integer, List<String>> readExcel(File file, List<Integer> ParmaNumber) throws IOException, InvalidFormatException {

        Workbook workbook=new XSSFWorkbook(file);

        Sheet sheet=workbook.getSheetAt(0);
        List<String> arr=new ArrayList<>();
        Map<Integer, List<String>> map=new HashMap<>();
        int parmaIndex = -1,emailsIndex=-1;
        String Email;
        Integer parmaID;
        for(Row row:sheet){

            if(row.getRowNum()==0){

                int[] indexs=getParmaIndex(row);
                parmaIndex=indexs[0];
                emailsIndex=indexs[1];
                continue;
            }
            Cell cellPamraID=row.getCell(parmaIndex);
            Cell cellEmail=row.getCell(emailsIndex);
            Email=  cellEmail.toString();
            parmaID = Integer.valueOf(cellPamraID.toString());
            if(cellPamraID!=null && cellEmail!=null ) {
                if (ParmaNumber.contains(parmaID)) {

                    if (map.containsKey(parmaID)) {
                        map.get(parmaID).add(Email);
                        map.put(parmaID, map.get(parmaID));
                    } else {
                        map.put(parmaID, new ArrayList<String>(Arrays.asList(Email)));
                    }
                }
            }

        } workbook.close();

        return map;
    }
            public static int[] getParmaIndex(Row row){
                    Iterator<Cell> cell=row.cellIterator();
                    int a=0,b=0;
                    int i=0;
                    while(cell.hasNext()){
                        String val=cell.next().toString();
                       // System.out.println(val+"valueee");

                        if(val.equals("SupplierId")){
                            a=i;
                        }
                        if(val.equals("Email")){
                            b=i;
                        }
                        i++;
                    }

                    return new int[]{a,b};
            }


}
