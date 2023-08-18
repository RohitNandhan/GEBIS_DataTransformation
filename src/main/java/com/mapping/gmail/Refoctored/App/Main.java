package com.mapping.gmail.Refoctored.App;

import com.mapping.gmail.Refoctored.Service.ExtractContent;
import com.mapping.gmail.Refoctored.Service.ExtractContentImpl;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Main {
    private static final String SupplierURI= "src/main/resources/20230808_SupplierContactSearch.xlsx";
    private static final String BuyerURI= "src/main/resources/Buyer_20230808.xlsx";

    public static void main(String[] args) throws IOException, InvalidFormatException {
        System.out.println("---------------------");
        File supplierFile=new File(SupplierURI);
        File buyerFile=new File(BuyerURI);
        ExtractContent extractContent=new ExtractContentImpl(supplierFile,buyerFile);
      //  Map map=extractContent.getSupplierAndBuyerData(20684);
        Map map=extractContent.getSupplierData(20684);

        System.out.println(map);
    }
}
