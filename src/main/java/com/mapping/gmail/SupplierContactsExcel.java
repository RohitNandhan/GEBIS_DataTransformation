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

public class SupplierContactsExcel {
    int sheetIndex=0;
    int contentIndex =0;
    Sheet sheet;
    int parmaIndex;
    int titleIndex;
    int emailIndex;

    String title1="SupplierId";
    String title2="Email";

    String mainContact="To";
    String subContact="CC";
    String title3="Title";

    Workbook workbook;
    String [] titleArray={"kam","manager","head" ,"leader","president"};
   // List<String> titleLists=Arrays.asList(titleArray.toW);
    Map<Integer,List<String>> mappedDataEmails;
    Map<Integer,Map<String,List<String>>> mappedDatatoRolesTo;
    Map<Integer,Map<String,List<String>>> mappedDatatoRolesCC;
    Map<Integer,Map<String,List<String>>> mappedDataParmaNames;
    SupplierContactsExcel(File file) throws IOException, InvalidFormatException {
        if (file == null) {
            throw new IOException("file not found");
        }
        workbook = new XSSFWorkbook(file);
        //Using Sheet 0
        this.sheet = workbook.getSheetAt(sheetIndex);
        //initialize Index for Parma and Email Cell
        getParmaIndex(sheet.getRow(contentIndex));
        //Mapping cell to Map
        mappingData(sheet);

        mappingDataToRoles(sheet);
    }



    public void getParmaIndex(Row row){
        Iterator<Cell> cell=row.cellIterator();
        int i=0;
        while(cell.hasNext()){
            String val=cell.next().toString();
            if(val.equals(title1)){
                this.parmaIndex=i;
            }if(val.equals(title3)){
                this.titleIndex=i;
            }
            if(val.equals(title2)){
                this.emailIndex=i;
            }i++;
            }
    }

    public void mappingData(Sheet sheet) {
        mappedDataEmails =new HashMap<>();
        for (Row row : sheet) {
            if(row.getRowNum()==0){ continue;}
            Cell parmaCell = row.getCell(parmaIndex);
            Cell emailCell = row.getCell(emailIndex);
            String Email = emailCell.toString();
            Integer parmaID = Integer.valueOf(parmaCell.toString());
            if (parmaCell != null && emailCell != null) {
                if (mappedDataEmails.containsKey(parmaID)) {
                    mappedDataEmails.get(parmaID).add(Email);
                    mappedDataEmails.put(parmaID, mappedDataEmails.get(parmaID));
                } else {
                    mappedDataEmails.put(parmaID, new ArrayList<String>(Arrays.asList(Email)));
                }
            }
        }
    }

    private void mappingDataToRoles(Sheet sheet) {
        mappedDatatoRolesTo = new HashMap<>();
        mappedDatatoRolesCC= new HashMap<>();
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
            Cell parmaCell = row.getCell(parmaIndex);
            Cell emailCell = row.getCell(emailIndex);
            Cell titleCell = row.getCell(titleIndex);
            String Email = emailCell.toString();
            Integer parmaID = Integer.valueOf(parmaCell.toString());
            String title = titleCell.toString();
            if (parmaCell != null && emailCell != null) {

                if (containsTitle(title, titleArray)) {
                    mapDataUpdate(parmaID,mainContact,Email,mappedDatatoRolesTo);
                }else{
                    mapDataUpdate(parmaID,subContact,Email,mappedDatatoRolesCC);
                }
            }
        }
    }

    public void mapDataUpdate(Integer parmaID, String title, String Email,Map<Integer,Map<String,List<String>>> mappedDatatoRoles){
        if (mappedDatatoRoles.containsKey(parmaID)) {
            if(mappedDatatoRoles.get(parmaID).containsKey(title)){
                mappedDatatoRoles.get(parmaID).get(title).add(Email);
            }
            mappedDatatoRoles.get(parmaID).put(title,mappedDatatoRoles.get(parmaID).get(title) );
            mappedDatatoRoles.put(parmaID, mappedDatatoRoles.get(parmaID));
        } else {
            mappedDatatoRoles.put(parmaID, new HashMap<String,List<String>>() {{
                {  put(title,new ArrayList<String>(Arrays.asList(Email)) );
                }};
            });
        }


    }



    public boolean containsTitle(String title,String arr[]){
        boolean containsAnyWord = false;

            for (String word : arr) {
                if (title.toLowerCase().contains(word)) {
                    return true;
                }
            } return false;
    }

    public void closeWorkbook() throws IOException {
        this.workbook.close();
    }

}
