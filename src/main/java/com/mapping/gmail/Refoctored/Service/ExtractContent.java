package com.mapping.gmail.Refoctored.Service;

import com.mapping.gmail.Refoctored.Bean.ParmaExcel;
import com.mapping.gmail.Refoctored.Bean.SupplierContactsExcel;

import java.util.List;
import java.util.Map;

public interface ExtractContent {
    Map<Integer, ParmaExcel> getSupplierData(List<Integer> ParmaNumber);
    Map<Integer,ParmaExcel> getSupplierData(Integer ParmaNumber) ;
    Map<Integer,ParmaExcel> getSupplierData() ;

    Map<Integer,ParmaExcel> getBuyerData() ;
    Map<Integer,ParmaExcel> getSupplierAndBuyerData(Integer ParmaNumber);
    Map<Integer,ParmaExcel> getSupplierAndBuyerData(List<Integer> ParmaNumber);

    Map<Integer,SupplierContactsExcel> getSupplierDataTo();

    Map<Integer,SupplierContactsExcel> getSupplierDataTo(Integer ParmaNumber);

    Map<Integer,SupplierContactsExcel> getSupplierDataTo(List<Integer> ParmaNumber);


    Map<Integer,SupplierContactsExcel> getSupplierDataCC();
    Map<Integer,SupplierContactsExcel> getSupplierDataCC(Integer ParmaNumber);
    Map<Integer,SupplierContactsExcel> getSupplierDataCC(List<Integer> ParmaNumber);


}
