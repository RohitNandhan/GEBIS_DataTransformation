package com.mapping.gmail.Refoctored.Mapping;

import com.mapping.gmail.Refoctored.Bean.ParmaExcel;
import com.mapping.gmail.Refoctored.Bean.SupplierContactsExcel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MappingBuyer extends MappingData {

    String supplierTitle="Parma";
    String nameTitle="Name";
    String emaiemailTitlel="Buyer email";
    Map<Integer, ParmaExcel> buyerMap;

    public MappingBuyer(File file) throws IOException, InvalidFormatException {
        super(file);
        setIndeices(supplierTitle,nameTitle,emailTitle);
        setParmaIndex(sheet.getRow(contentIndex));
    }

    @Override
    public void mappingSupplierData() {
             buyerMap =new HashMap<>();
            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue;
                }
                Cell parmaCell = row.getCell(0);

                Cell emailCell = row.getCell(3);
                Cell nameCell = row.getCell(1);
                if (parmaCell != null && emailCell!=null) {
                String email = emailCell.toString();
                Integer parmaID= Double.valueOf(parmaCell.toString()).intValue();
             //   Integer parmaID =  Integer.valueOf(parmaCell.toString()).;
            //    Integer parmaID =  12345;
                String parmaName= nameCell.toString();

                    mappingToParmaMap(parmaID,parmaName,email,buyerMap);

                }
            }
    }

    @Override
    public void mappingToParmaMap(Integer parmaID, String parmaName, String Email, Map<Integer, ParmaExcel> parmaMap) {
        if(parmaMap.containsKey(parmaID)){
            parmaMap.get(parmaID).setEmailID(Email);
        }else {

            parmaMap.put(parmaID,new ParmaExcel(parmaID,parmaName,new ArrayList<>(Arrays.asList(Email))));
        }

    }

    @Override
    public void mappingToSupplierMap(Integer parmaID, String parmaName, String Email, String title, Map<Integer, SupplierContactsExcel> supplierMap) {

    }

    @Override
    public Map<Integer, ParmaExcel> getParmaMap() {
        return buyerMap;
    }
}
