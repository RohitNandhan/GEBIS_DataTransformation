package com.mapping.gmail.Refoctored.DTO;

import com.mapping.gmail.Refoctored.Bean.ParmaExcel;
import com.mapping.gmail.Refoctored.Bean.SupplierContactsExcel;
import com.mapping.gmail.Refoctored.Service.ExtractContent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MapToText {
    public void maptoTextFile(File output){

    }
//    public static void toText(File file, Map<Integer, Map<Integer,ParmaExcel> map)throws IOException {
//        FileWriter fileWriter=new FileWriter(file);
//        for (List<String> innerList : map.values()) {
//            for (String value : innerList) {
//                //System.out.println(innerList);
//                fileWriter.append(value).append(";");
//            }
//        }fileWriter.close();
//    }
//    public static void toText(File file, Map<Integer,ParmaExcel> map)throws IOException{
//        FileWriter fileWriter=new FileWriter(getOutputFile());
//        for (Integer parma : map.keySet()) {
//            fileWriter.write(parma+": \t"+ map.get(parma).getParmaname() +"\n");
//            for (String mail : map.get(parma).getEmailID()) {
//                //System.out.println(innerList);
//                fileWriter.append(mail).append(";");
//            } fileWriter.write("\n \n");
//        }fileWriter.close();
//    }

//    public static void toText(File file, Map<Integer,ParmaExcel> supplierMap, Map<Integer,ParmaExcel> buyerMap)throws IOException{
//        FileWriter fileWriter=new FileWriter(file);
//        for (Integer parma : supplierMap.keySet()) {
//            fileWriter.write(parma+": \t"+ supplierMap.get(parma).getParmaname() +"\n");
//            for (String mail : supplierMap.get(parma).getEmailID()) {
//                //System.out.println(innerList);
//                fileWriter.append(mail).append(";");
//            } fileWriter.write("\n");
//                fileWriter.append(buyerMap.get(parma).getEmailID().get(0)).append(";");
//        }fileWriter.close();
//    }


    public static void toText(File file, Integer parmas, ExtractContent extractContent)throws IOException{
        FileWriter fileWriter=new FileWriter(file);
        Integer parma=parmas;
        Map<Integer,ParmaExcel> parmaExcelMap=extractContent.getSupplierData(parma);
        fileWriter.write(parmas+"  : \t"+ parmaExcelMap.get(parma).getParmaname() +"\n");
            fileWriter.append("To : \n");
        if((extractContent.getSupplierDataTo().get(parma))!=null) {
            for (String mail : extractContent.getSupplierDataTo().get(parma).getEmailID()) {
                //System.out.println(innerList);
                fileWriter.append(mail).append(";");
            }} fileWriter.write("\n");
            fileWriter.append("CC : \n");
        if((extractContent.getSupplierDataCC().get(parma))!=null) {
            for (String mail : extractContent.getSupplierDataCC().get(parma).getEmailID()) {
                //System.out.println(innerList);
                fileWriter.append(mail).append(";");
            }} fileWriter.write("\n");
        fileWriter.append("Buyer : \n");
        if((extractContent.getBuyerData().get(parma))!=null) {
            fileWriter.append(extractContent.getBuyerData().get(parma).getEmailID().get(0)).append(";");
        }  fileWriter.close();
    }

    public static void toTextAllMails(File file, List<Integer> parmas, ExtractContent extractContent)throws IOException{
        FileWriter fileWriter=new FileWriter(file);
        Map<Integer,ParmaExcel> parmaExcelMap=extractContent.getSupplierAndBuyerData(parmas);
        fileWriter.write("All Emails: \n");
        for (Integer parma : parmaExcelMap.keySet()) {
            for (String mail : parmaExcelMap.get(parma).getEmailID()) {
                //System.out.println(innerList);
                fileWriter.append(mail).append(";");
            }}


//            fileWriter.write(parma+": \t"+ parmaExcelMap.get(parma).getParmaname() +"\n");
//            fileWriter.append("To : \n");
//            if((extractContent.getSupplierDataTo().get(parma))!=null) {

//            fileWriter.write("\n");
//            fileWriter.append("CC : \n");
//            if((extractContent.getSupplierDataCC().get(parma))!=null) {
//                for (String mail : extractContent.getSupplierDataCC().get(parma).getEmailID()) {
//                    //System.out.println(innerList);
//                    fileWriter.append(mail).append(";");

        fileWriter.write("\n--------------------------------------------\n");
        fileWriter.close();
             }




    public static void toText(File file, List<Integer> parmas, ExtractContent extractContent)throws IOException{
        FileWriter fileWriter=new FileWriter(file);
        Map<Integer,ParmaExcel> parmaExcelMap=extractContent.getSupplierData(parmas);
        //Collections.sort(parmaExcelMap);
        for (Integer parma : parmaExcelMap.keySet()) {
            fileWriter.write(parma+": \t"+ parmaExcelMap.get(parma).getParmaname() +"\n");
            fileWriter.append("To : \n");
            if((extractContent.getSupplierDataTo().get(parma))!=null) {
            for (String mail : extractContent.getSupplierDataTo().get(parma).getEmailID()) {
                //System.out.println(innerList);
                fileWriter.append(mail).append(";");
            }}
            fileWriter.write("\n");
            fileWriter.append("CC : \n");
            if((extractContent.getSupplierDataCC().get(parma))!=null) {
            for (String mail : extractContent.getSupplierDataCC().get(parma).getEmailID()) {
                //System.out.println(innerList);
                fileWriter.append(mail).append(";");
            } }
            fileWriter.write("\n");
            if((extractContent.getBuyerData().get(parma))!=null) {
                fileWriter.append("Buyer : \n");
                fileWriter.append(extractContent.getBuyerData().get(parma).getEmailID().get(0)).append(";");
            }
            fileWriter.write("\n--------------------------------------------\n");
        }fileWriter.close();
    }
//    public static File getOutputFile(String fname) throws IOException {
//        File outputFile=new File("src/main/out/"+fname+".txt");
//        return outputFile;
//    }
}
