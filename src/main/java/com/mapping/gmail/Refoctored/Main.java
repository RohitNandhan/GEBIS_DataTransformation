package com.mapping.gmail.Refoctored;

import com.mapping.gmail.Refoctored.Service.ExtractContent;
import com.mapping.gmail.Refoctored.Service.ExtractContentImpl;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String SupplierURI= "src/test/resources/20230808_SupplierContactSearchTest.xlsx";
    private static final String BuyerURI= "src/test/resources/Buyer_20230808.xlsx";



    public static void main(String[] args) throws IOException, InvalidFormatException {
        File Sfile=new File(SupplierURI);
        File Bfile=new File(BuyerURI);

//        ExtractContent extractContent=new ExtractContentImpl(Sfile,Bfile);
//        Map map=extractContent.getSupplierData();
        System.out.println("------------------------------------------------------------");




    }
}
