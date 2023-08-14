package com.mapping.gmail;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ExcelReaderUp {
    SupplierContactsExcel supplierContactsExcel;

    //This is to Read the Excel File
    public Map<Integer, List<String>> readExcel(File file) throws IOException, InvalidFormatException {

        supplierContactsExcel = new SupplierContactsExcel(file);
        Map<Integer, List<String>> dataMap = new HashMap<>();
        Sheet sheet = supplierContactsExcel.sheet;
        dataMap = supplierContactsExcel.mappedDataEmails;
        supplierContactsExcel.closeWorkbook();
        return dataMap;
    }

    public Map<Integer, List<String>> readExcel(File file, Integer ParmaNumber) throws IOException, InvalidFormatException {
        supplierContactsExcel = new SupplierContactsExcel(file);
        Map<Integer, List<String>> dataMap = new HashMap<>();
        if (supplierContactsExcel.mappedDataEmails.keySet().contains(ParmaNumber)) {
                dataMap.put(ParmaNumber, supplierContactsExcel.mappedDataEmails.get(ParmaNumber));
            }
        return dataMap;
    }

    public Map<Integer, List<String>> readExcel(File file, List<Integer> ParmaNumber) throws IOException, InvalidFormatException, CustomException.ParmaNotFoundException {
        supplierContactsExcel = new SupplierContactsExcel(file);
        Map<Integer, List<String>> dataMap = new HashMap<>();
        for (Integer parma : supplierContactsExcel.mappedDataEmails.keySet()) {
            if (ParmaNumber.contains(parma)) {
                dataMap.put(parma, supplierContactsExcel.mappedDataEmails.get(parma));
            } }
        return dataMap;

    }

}
