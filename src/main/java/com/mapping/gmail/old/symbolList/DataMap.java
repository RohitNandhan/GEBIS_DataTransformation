package com.mapping.gmail.old.symbolList;

import com.mapping.gmail.Refoctored.Bean.ParmaExcel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class DataMap {

    final int sheetIndex=0;

    final int contentIndex=0;

    int nameIndex;
    int symbolIndex;

    String nameTitle="Name";
    String symbolTitle="Symbol";


    Map<String, String> map;

    Sheet sheet;
    Workbook workbook;



    public  DataMap(File file) throws IOException, InvalidFormatException {
        workbook= new XSSFWorkbook(file);
        if (file == null) {
            throw new IOException("file not found");
        }
        //Using Sheet 0
        this.sheet = workbook.getSheetAt(sheetIndex);
        setParmaIndex(sheet.getRow(0));
        mappingData();
        closeWorkbook();

    }
    public void mappingData() {
         map=new HashMap<>();
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
            Cell symbolCell = row.getCell(symbolIndex);
            Cell nameCell = row.getCell(nameIndex);
            if (symbolCell != null && nameCell!=null) {
                String name = nameCell.toString();
                String symbol=symbolCell.toString();

                mappingToMap(symbol,name);

            }
        }
    }

    private void mappingToMap(String symbol,String name) {
        if( map.containsKey(symbol)){
             return;
        }else {
             map.put(symbol,name);
        }
    }

    public void setParmaIndex(Row row) {
        Iterator<Cell> cell = row.cellIterator();
        int i = 0;
        while (cell.hasNext()) {
            String val = cell.next().toString();
            if (val.equals(symbolTitle)) {
                this.symbolIndex = i;
            }
            if (val.equals(nameTitle)) {
                this.nameIndex = i;
            }
            i++;
        }
    }




    public void closeWorkbook() throws IOException {
        this.workbook.close();
    }


}
