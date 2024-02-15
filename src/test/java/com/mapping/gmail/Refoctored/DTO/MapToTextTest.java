package com.mapping.gmail.Refoctored.DTO;

import com.mapping.gmail.Refoctored.Bean.ParmaExcel;
import com.mapping.gmail.Refoctored.Mapping.MappingSupplierContact;
import com.mapping.gmail.Refoctored.Service.ExtractContent;
import com.mapping.gmail.Refoctored.Service.ExtractContentImpl;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import static com.sun.deploy.trace.Trace.print;
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
//        System.out.println(MappingSupplierContact.class);
//        System.out.println(MappingSupplierContact.class.toString());
        extractContent=new ExtractContentImpl(Sfile,Bfile);
    }

    @Test
    @DisplayName(" Get Single Parma ")
    void maptoTextSingleParma() throws IOException, InvalidFormatException {
        DataConversion dataConversion=new DataConversion(Sfile,Bfile);
        String parma="52870";
        //String parma2="32121";

        dataConversion.mapToText(parma);
     //   dataConversion.mapToText(parm2);
      //  16027
    }

    @Test
    @DisplayName("GetAll emails consoliadted for parma from file ")
    void getAllEmails() throws IOException, InvalidFormatException {
        DataConversion dataConversion = new DataConversion(Sfile, Bfile);
        String filePath = "src/main/resources/ContactDetails.txt";
        File inputFile = new File(filePath);
        List<Integer> lst = dataConversion.extractParma(inputFile);
        Map<Integer, ParmaExcel> map = extractContent.getSupplierAndBuyerData(lst);
        System.out.println(map);
        dataConversion.mapToText(inputFile);


    }

    @Test
    @DisplayName("Mapping parma with Input File")
    void maptoTextFiles() throws IOException, InvalidFormatException {
        DataConversion dataConversion=new DataConversion(Sfile,Bfile);
        String filePath="src/main/resources/connection.txt";
        File inputFile=new File(filePath);
        dataConversion.mapToText(inputFile);

    }

    @Test
    @DisplayName("Mapping of multiple parma")
    void maptoTextFileMultipleParma() throws IOException, InvalidFormatException {
        DataConversion dataConversion=new DataConversion(Sfile,Bfile);
        String parma="23822612 22723 24693 25288 25638";
        dataConversion.mapToText(parma);

    }

    @Test
    void dumb() {


       //  final PrintStream s = System.out;
         final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        System.out.println("Hello Baeldung Readers!!");
      //  s.print("fuk!");

        Assert.assertEquals("Hello Baeldung Readers!!", outputStreamCaptor.toString()
                .trim());
    }


    @Test
    void testToText() {
    }
}