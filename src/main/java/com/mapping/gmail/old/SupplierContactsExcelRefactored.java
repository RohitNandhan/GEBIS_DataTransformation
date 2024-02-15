package com.mapping.gmail.old;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class SupplierContactsExcelRefactored {
    int sheetIndex=0;
    int contentIndex =0;
    Sheet sheet;
    int parmaIndex;
    int titleIndex;
    int emailIndex;
    int nameIndex;

    String supplierId="SupplierId";
    String email="Email";

    String mainContact="To";
    String subContact="CC";
    String title="Title";
    String name="Name";

    Workbook workbook;
    String [] titleArray={"kam","manager","head" ,"leader","president","key",};
   // List<String> titleLists=Arrays.asList(titleArray.toW);
    Map<Integer,List<String>> mappedDataEmails;
    Map<Integer,Map<String,List<String>>> mappedDatatoRolesTo;
    Map<Integer,Map<String,List<String>>> mappedDatatoRolesCC;
    Map<Integer,String> mappedDataNames;
    SupplierContactsExcelRefactored(File file) throws IOException, InvalidFormatException {
        if (file == null) {
            throw new IOException("file not found");
        }
        workbook = new XSSFWorkbook(file);
        //Using Sheet 0
        this.sheet = workbook.getSheetAt(sheetIndex);
        //initialize Index for Parma and Email Cell
        getParmaIndex(sheet.getRow(contentIndex));
        //Mapping cell to Map
       // mappingWithDataEmails(sheet);

        mappingData(sheet);
    }



    public void getParmaIndex(Row row){
        Iterator<Cell> cell=row.cellIterator();
        int i=0;
        while(cell.hasNext()){
            String val=cell.next().toString();
            if(val.equals(supplierId)){
                this.parmaIndex=i;
            }if(val.equals(title)){
                this.titleIndex=i;
            }if(val.equals(name)){
                this.nameIndex=i;
            }if(val.equals(email)){
                this.emailIndex=i;
            }i++;
            }
    }

    public void mappingWithEmail(Integer parmaID, String Email,Map<Integer,List<String>> mappedData) {
        mappedData = new HashMap<>();
        if (mappedData.containsKey(parmaID)) {
            mappedData.get(parmaID).add(Email);
            mappedData.put(parmaID, mappedData.get(parmaID));
        } else {
            mappedData.put(parmaID, new ArrayList<String>(Arrays.asList(Email)));
        }
    }
    public void mappingWithName(Integer parmaID, String name, Map<Integer,String> mappedData) {
        mappedData =new HashMap<>();
        if (mappedData.containsKey(parmaID)) {
            return;
        } else {
            mappedData.put(parmaID,name);
        }
    }



    private void mappingData(Sheet sheet) {
        mappedDatatoRolesTo = new HashMap<>();
        mappedDatatoRolesCC= new HashMap<>();
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
            Cell parmaCell = row.getCell(parmaIndex);
            Cell emailCell = row.getCell(emailIndex);
            Cell titleCell = row.getCell(titleIndex);
            Cell nameCell = row.getCell(nameIndex);
            String Email = emailCell.toString();
            Integer parmaID = Integer.valueOf(parmaCell.toString());
            String parmaName= nameCell.toString();
            String title = titleCell.toString();
            if (parmaCell != null && emailCell != null) {
                mappingWithEmail(parmaID,Email,mappedDataEmails);
                mappingWithName(parmaID,parmaName,mappedDataNames);
                if (containsTitle(title, titleArray)) {
                    mappingWithRoles(parmaID,mainContact,Email,mappedDatatoRolesTo);
                }else{
                    mappingWithRoles(parmaID,subContact,Email,mappedDatatoRolesCC);
                }
            }
        }
    }

    public void mappingWithRoles(Integer parmaID, String title, String Email, Map<Integer,Map<String,List<String>>> mappedDatatoRoles){
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
        }}

    public static boolean isParmaExist(Map map){
        if(map.size()!=0){
            return true;
        }return false;}



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
