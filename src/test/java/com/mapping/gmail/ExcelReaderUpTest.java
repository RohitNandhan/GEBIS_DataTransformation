package com.mapping.gmail;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ExcelReaderUpTest {
        final String fileSrc="src/test/resources/20230808_SupplierContactSearchTest.xlsx";
        File file;
        ExcelReaderUp excelReaderUp;
        int i=0;
    @BeforeEach
    void setUp() {
        file=new File(fileSrc);
        excelReaderUp=new ExcelReaderUp();
        i=i+1;
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test : Successfull\n------------------------");
    }

    @Test
    void readExcelForEmptyFile() {
        assertThrows(IOException.class,()->{
            excelReaderUp.readExcel(null);
        });

    }
    @Test
    void testReadExcelGetAllValue() throws IOException, InvalidFormatException {
        //Excel excel=new Excel(file);
        Map <Integer,List<String>>map = excelReaderUp.readExcel(file);
        List<String> lst=new ArrayList<>();
        for(List<String> ls:map.values()){
            lst.addAll(ls);
        }
        assertEquals(22367,lst.size());
        System.out.println(lst.size());
    }
    @Test
    void testReadExcelGetAllValueOfMainTitle() throws IOException, InvalidFormatException {
        SupplierContactsExcel supplierContactsExcel =new SupplierContactsExcel(file);
     //   Map <Integer,List<String>>map = excelReaderUp.readExcel(file);
        Map<Integer,Map<String,List<String>>> map= supplierContactsExcel.mappedDatatoRolesTo;
        List<String> lst=new ArrayList<>();
        for(Map<String,List<String>> ls:map.values()){
            for(List<String> ls1:ls.values()){
                lst.addAll(ls1);
            }

        }
        assertNotEquals(22367,lst.size());
       System.out.println(lst.size());
    }

    @Test
    //@ValueSource(int[](1,2,3,4))
    void testReadExcelNotNull() throws IOException, InvalidFormatException {
        Map mappedData=excelReaderUp.readExcel(file);
        assertNotNull(mappedData);
    }


    @ParameterizedTest
    @ValueSource(ints={20684,3494,0001,4856})
    void testReadExcelListOfValues(Integer arrays) throws IOException, InvalidFormatException, CustomException.ParmaNotFoundException {

        Map mappedData=excelReaderUp.readExcel(file, arrays);
        assertNotNull(mappedData);
    }

    @Test
    void testReadExcelForInteger() throws IOException, InvalidFormatException {
        int parmaNumber=7321;
        Map mappedData=excelReaderUp.readExcel(file,parmaNumber);
        System.out.println(mappedData.values());
        assertTrue(mappedData.keySet().contains(parmaNumber));
        assertEquals(1,mappedData.keySet().size());
    }
    @Test
    void testReadExcelForIntegerNotExist() throws IOException, InvalidFormatException {
        int parmaNumber=206844;
        assertThrows(CustomException.ParmaNotFoundException.class,()->{
            excelReaderUp.readExcel(file,parmaNumber);
        });

    }

    @Ignore
    @Test
    //Testing for Method : ExcelReader.getParmaIndex(row);
    void getParmaIndex() throws IOException, InvalidFormatException {
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        Row row=sheet.getRow(0);
        //int[] actual=excelReaderUp.getParmaIndex(row);
//        assertArrayEquals(new int[]{0,6},actual);
//
//        assertEquals(2,actual.length);
    }

    @Test
    //Testing for Method : ExcelReader.getParmaIndex(row);
    void getMappedIntoTitleTest() throws IOException, InvalidFormatException {
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        SupplierContactsExcel supplierContactsExcel =new SupplierContactsExcel(file);
        Map map= supplierContactsExcel.mappedDatatoRolesTo;
        System.out.println(map);
    }//{To=[ozgur.topac@maxionwheels.com, ozgur.topac@maxionwheels.com]},
    @Ignore
    @Test
    // Invalid index for Method :ExcelReader.getParmaIndex(row);
    void getParmaIndexThrowException() throws IOException, InvalidFormatException {
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        Row row=sheet.getRow(-1);
        assertThrows(NullPointerException.class,()->{
           // excelReaderUp.getParmaIndex(row);
        });
    }

}