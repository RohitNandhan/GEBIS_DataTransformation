package com.mapping.gmail;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ExcelReaderTest {
        final String fileSrc="src/test/resources/20230808_SupplierContactSearchTest.xlsx";
        File file;
        int i=0;
    @BeforeEach
    void setUp() {
        file=new File(fileSrc);
        i=i+1;
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test : Successfull\n------------------------");
    }

    @Test
    void readExcelForEmptyFile() {
        assertThrows(IOException.class,()->{
            ExcelReader.readExcel(null);
        });

    }

    @Test
    //@ValueSource(int[](1,2,3,4))
    void testReadExcelNotNull() throws IOException, InvalidFormatException {
        Map map=ExcelReader.readExcel(file);
        assertNotNull(map);
    }
    @Test
        //@ValueSource(int[](1,2,3,4))
    void testReadExcelGetAllValue() throws IOException, InvalidFormatException {
        SupplierContactsExcel supplierContactsExcel =new SupplierContactsExcel(file);
        Map map = supplierContactsExcel.mappedDataEmails;
        System.out.println(map);
    }

    @Test
    @ParameterizedTest
    @ValueSource(ints={20684,3494,0001,4856})
    void testReadExcelListOfValues(Integer[] arrays) throws IOException, InvalidFormatException, CustomException.ParmaNotFoundException {

        Map map=ExcelReader.readExcel(file, Arrays.asList(arrays));
        assertNotNull(map);
    }

    @Test
    void testReadExcelForInteger() throws IOException, InvalidFormatException {
        int parmaNumber=20684;
        Map map=ExcelReader.readExcel(file,parmaNumber);
        assertTrue(map.keySet().contains(parmaNumber));
        assertEquals(1,map.keySet().size());
    }
    @Test
    void testReadExcelForIntegerNotExist() throws IOException, InvalidFormatException {
        int parmaNumber=206844;
        assertThrows(CustomException.ParmaNotFoundException.class,()->{
            ExcelReader.readExcel(file,parmaNumber);
        });

    }

    @Test
    //Testing for Method : ExcelReader.getParmaIndex(row);
    void getParmaIndex() throws IOException, InvalidFormatException {
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        Row row=sheet.getRow(0);
        int[] actual=ExcelReader.getParmaIndex(row);
        assertArrayEquals(new int[]{0,6},actual);

        assertEquals(2,actual.length);
    }
    @Test
    // Invalid index for Method :ExcelReader.getParmaIndex(row);
    void getParmaIndexThrowException() throws IOException, InvalidFormatException {
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        Row row=sheet.getRow(-1);
        assertThrows(NullPointerException.class,()->{
           ExcelReader.getParmaIndex(row);
        });
    }

}