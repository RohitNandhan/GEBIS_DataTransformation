package com.mapping.gmail.Refoctored.Service;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ExtractContentImplTest {
    private static final String SupplierURI= "src/test/resources/20230808_SupplierContactSearchTest.xlsx";
    private static final String BuyerURI= "src/test/resources/Buyer_20230808.xlsx";
    File Sfil;
    File Bfile;
    public ExtractContent extractContent;

    @BeforeEach
    void initiliaze() throws IOException, InvalidFormatException {
        Sfil=new File(SupplierURI);
        Bfile=new File(BuyerURI);
        extractContent=new ExtractContentImpl(Sfil,Bfile);
    }

    @Test
    void getSupplierData() {

    }

    @Test
    void testGetSupplierData() {
        Map map=extractContent.getSupplierData();
        System.out.println(map);
    }

    @Test
    void testGetSupplierData1() {
    }

    @Test
    void testGetBuyerData() {
        Map map=extractContent.getBuyerData();
        System.out.println(map);
    }

    @Test
    void getSupplierAndBuyerData() {
        Map map=extractContent.getSupplierAndBuyerData(20684);
        System.out.println(map);
    }

    @Test
    void testGetSupplierAndBuyerData() {
    }

    @Test
    void getSupplierDataTo() {
    }

    @Test
    void getSupplierDataCC() {
    }
}