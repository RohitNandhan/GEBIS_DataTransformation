package com.mapping.gmail.Refoctored.DTO;

import com.mapping.gmail.Refoctored.Bean.ParmaExcel;
import com.mapping.gmail.Refoctored.Service.ExtractContent;
import com.mapping.gmail.Refoctored.Service.ExtractContentImpl;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapToTextTest {
    private static final String SupplierURI= "src/test/resources/20230808_SupplierContactSearchTest.xlsx";
    private static final String BuyerURI= "src/test/resources/Buyer_20230808.xlsx";
    File Sfile;
    File Bfile;

    ExtractContent extractContent;

    @BeforeEach
    void setUp() throws IOException, InvalidFormatException {
        Sfile=new File(SupplierURI);
        Bfile=new File(BuyerURI);
        extractContent=new ExtractContentImpl(Sfile,Bfile);
    }

    @Test
    @DisplayName(" Get Single Parma ")
    void maptoTextSingleParma() throws IOException, InvalidFormatException {
        DataConversion dataConversion=new DataConversion(Sfile,Bfile);
        String parma="14475";
        dataConversion.mapToText(parma);

    }

    @Test
    @DisplayName("GetAll emails consoliadted for parma from file ")
    void getAllEmails() throws IOException, InvalidFormatException {
        DataConversion dataConversion = new DataConversion(Sfile, Bfile);
        String filePath = "src/main/resources/52773 - (OFTP2) - O0013005499AXWCLOUD.txt";
        File inputFile = new File(filePath);
        List<Integer> lst = dataConversion.extractParma(inputFile);
        Map<Integer, ParmaExcel> map = extractContent.getSupplierAndBuyerData(lst);
        System.out.println(map);
        dataConversion.mapToText(inputFile,"ALL");      


    }

    @Test
    @DisplayName("Mapping parma with Input File")
    void maptoTextFiles() throws IOException, InvalidFormatException {
        DataConversion dataConversion=new DataConversion(Sfile,Bfile);
        String filePath="src/main/resources/Mahle.txt";
        File inputFile=new File(filePath);
        dataConversion.mapToText(inputFile);

    }

    @Test
    void maptoTextFileMultipleParma() throws IOException, InvalidFormatException {
        DataConversion dataConversion=new DataConversion(Sfile,Bfile);
        String parma="14756 20337 22209 25333 ";
        dataConversion.mapToText(parma);

    }

    @Test
    void toText() {
    }

    @Test
    void testToText() {
    }
}