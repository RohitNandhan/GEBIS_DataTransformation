package com.mapping.gmail;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String ExcelFile= "src/main/resources/20230808_SupplierContactSearch.xlsx";

    public static void main(String[] args) throws IOException, InvalidFormatException {

        File file = new File(ExcelFile);
        Scanner sc = new Scanner(System.in);

            System.out.println("Enter the Parma No. :");
            String input = sc.nextLine();//7321,7734,7784
            ExtractContent extractContent=new ExtractContent();

            List<Integer> parmaList = extractContent.stringToIntegerList(input);
            extractContent.readExcel(file, parmaList);
            //extractContent.printOutput();
            extractContent.printOutput(true);
            extractContent.mapToJson(input);
            System.out.println("\n");
            //ExcelReader.readExcel(file,parmaList);
        sc.close();
    }

}
