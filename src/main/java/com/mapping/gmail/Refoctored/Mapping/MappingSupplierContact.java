package com.mapping.gmail.Refoctored.Mapping;

import com.mapping.gmail.Refoctored.Bean.ParmaExcel;
import com.mapping.gmail.Refoctored.Bean.SupplierContactsExcel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MappingSupplierContact extends MappingData implements DataInteface {

    int titleIndex;
    String mainContact="To";
    String subContact="CC";
    String title = "Title";

    String [] titleArray={"kam","manager","head" ,"leader","president","key",};
   // List<String> titleLists=Arrays.asList(titleArray.toW);
    ParmaExcel parmaExcel;
    SupplierContactsExcel supplierContactsExcel;
    Map<Integer, ParmaExcel> parmaMap;
    Map<Integer,SupplierContactsExcel> supplierMapTO;
    Map<Integer,SupplierContactsExcel> supplierMapCC;


    public MappingSupplierContact(File file) throws IOException, InvalidFormatException {
        super(file);
        //initialize Index for Parma and Email Cell
        setParmaIndex(sheet.getRow(contentIndex));
    }

    @Override
    public void mappingSupplierData() {
        parmaMap =new HashMap<>();
        supplierMapTO=new HashMap<>();
        supplierMapCC=new HashMap<>();
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
            Cell parmaCell = row.getCell(parmaIndex);
            Cell emailCell = row.getCell(emailIndex);
            Cell titleCell = row.getCell(titleIndex);
            Cell nameCell = row.getCell(nameIndex);
            String email = emailCell.toString();
            Integer parmaID = Integer.valueOf(parmaCell.toString());
            String parmaName= nameCell.toString().toUpperCase();
            String title = titleCell.toString();
            if (parmaCell != null) {
                mappingToParmaMap(parmaID,parmaName,email,parmaMap);
                if(containsTitle(title,titleArray)){
                   mappingToSupplierMap(parmaID,parmaName,email,title,supplierMapTO);
                }else {
                    mappingToSupplierMap(parmaID,parmaName,email,title,supplierMapCC);
                }
            }
        }
    }
  //  Map<key, value>
    // Map<Integer, Class parma>
    @Override
    public void mappingToParmaMap(Integer parmaID, String parmaName, String Email, Map<Integer, ParmaExcel> parmaMap) {
        if(parmaMap.containsKey(parmaID)){
            parmaMap.get(parmaID).setEmailID(Email);
        }else {
            List<String> lst=new ArrayList<>(Arrays.asList(Email));
            ParmaExcel parma=new ParmaExcel(parmaID,parmaName,lst);
            parmaMap.put(parmaID,parma);
            //parmaMap.put(parmaID,new ParmaExcel(parmaID,parmaName,new ArrayList<>(Arrays.asList(Email))));
        }
    }
    @Override
    public void mappingToSupplierMap(Integer parmaID, String parmaName, String Email, String title, Map<Integer, SupplierContactsExcel> supplierMap) {
        if(supplierMap.containsKey(parmaID)){
            supplierMap.get(parmaID).setEmailID(Email);
        }else {
            supplierMap.put(parmaID,new SupplierContactsExcel(parmaID,parmaName,new ArrayList<>(Arrays.asList(Email)),title));
        }
    }

    @Override
    public void setParmaIndex(Row row) {
        Iterator<Cell> cell = row.cellIterator();
        int i = 0;
        while (cell.hasNext()) {
            String val = cell.next().toString();

            if (val.equals(supplierTitle)) {
                this.parmaIndex = i;
            }
            if (val.equals(title)) {
                this.titleIndex = i;
            }
            if (val.equals(nameTitle)) {
                this.nameIndex = i;
            }
            if (val.equals(emailTitle)) {
                this.emailIndex = i;
            }
            i++;
        }
    }

    @Override
    public Map<Integer, ParmaExcel> getParmaMap() {

        return parmaMap;
    }

    public Map<Integer, SupplierContactsExcel> getSupplierMapTO() {
        return supplierMapTO;
    }

    public Map<Integer, SupplierContactsExcel> getSupplierMapCC() {
        return supplierMapCC;
    }

    public boolean containsTitle(String title, String arr[]){
        boolean containsAnyWord = false;

            for (String word : arr) {
                if (title.toLowerCase().contains(word)) {
                    return true;
                }
            } return false;
    }

}
