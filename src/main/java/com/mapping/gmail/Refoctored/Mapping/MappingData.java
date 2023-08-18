package com.mapping.gmail.Refoctored.Mapping;

import com.mapping.gmail.Refoctored.Bean.ParmaExcel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public abstract class MappingData {
    int sheetIndex=0;
    int contentIndex =0;
    int parmaIndex;
    int emailIndex;
    int nameIndex;
    Sheet sheet;
    String supplierTitle = "SupplierId";
    String emailTitle = "Email";

    String nameTitle = "Name";
    Workbook workbook;

    public  MappingData(File file) throws IOException, InvalidFormatException {
        workbook = new XSSFWorkbook(file);
        if (file == null) {
            throw new IOException("file not found");
        }
        //Using Sheet 0
        this.sheet = workbook.getSheetAt(sheetIndex);
    }
    public void setIndeices(String supplierTitle,String nameTitle,String emailTitle){
        this.supplierTitle=supplierTitle;
        this.nameTitle=nameTitle;
        this.emailTitle=emailTitle;
    }


    public abstract void mappingSupplierData();
    public abstract void mappingToParmaMap(Integer parmaID,String parmaName, String Email,Map<Integer,ParmaExcel> map);


    public static boolean isParmaExist(Map map) {
        if (map.size() != 0) {
            return true;
        }
        return false;
    }

    public void setParmaIndex(Row row) {
        Iterator<Cell> cell = row.cellIterator();
        int i = 0;
        while (cell.hasNext()) {
            String val = cell.next().toString();
            if (val.equals(supplierTitle)) {
                this.parmaIndex = i;
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

    public void closeWorkbook() throws IOException {
        this.workbook.close();
    }
}
