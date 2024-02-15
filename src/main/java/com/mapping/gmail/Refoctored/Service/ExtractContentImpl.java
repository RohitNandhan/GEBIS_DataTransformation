package com.mapping.gmail.Refoctored.Service;

import com.mapping.gmail.Refoctored.Bean.ParmaExcel;
import com.mapping.gmail.Refoctored.Bean.SupplierContactsExcel;
import com.mapping.gmail.Refoctored.Mapping.MappingBuyer;
import com.mapping.gmail.Refoctored.Mapping.MappingSupplierContact;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtractContentImpl implements ExtractContent{
    MappingSupplierContact mappingSupplierData;
    MappingBuyer mappingBuyerData;

    public ExtractContentImpl(File sFile, File bFile) throws IOException, InvalidFormatException {
        mappingSupplierData= (MappingSupplierContact) FactoryClass.getInstance(MappingSupplierContact.class.toString(), sFile);
        //mappingSupplierData =new MappingSupplierContact(sFile);
        mappingBuyerData= (MappingBuyer) FactoryClass.getInstance(MappingBuyer.class.toString(), bFile);
        //mappingBuyerData=new MappingBuyer(bFile);
        mappingSupplierData.mappingSupplierData();
        mappingBuyerData.mappingSupplierData();
    }

    @Override
    public Map<Integer,ParmaExcel> getSupplierData( List<Integer> ParmaNumber) {
        Map<Integer, ParmaExcel> dataMap=new HashMap<>();
        for (Integer parma : mappingSupplierData.getParmaMap().keySet()) {
            if (ParmaNumber.contains(parma)) {
                dataMap.put(parma, mappingSupplierData.getParmaMap().get(parma));
            } }

        return dataMap;
    }

    @Override
    public Map<Integer,ParmaExcel> getSupplierData( Integer ParmaNumber) {
        Map<Integer, ParmaExcel> dataMap=new HashMap<>();
        if (mappingSupplierData.getParmaMap().keySet().contains(ParmaNumber)) {
            dataMap.put(ParmaNumber, mappingSupplierData.getParmaMap().get(ParmaNumber));
        }

        return dataMap;

    }

    @Override
    public Map<Integer,ParmaExcel> getSupplierData()  {
        return mappingSupplierData.getParmaMap();

    }

    @Override
    public Map<Integer, ParmaExcel> getBuyerData()  {
        return mappingBuyerData.getParmaMap();
    }

    @Override
    public Map<Integer, ParmaExcel> getSupplierAndBuyerData(Integer ParmaNumber) {
        Map<Integer,ParmaExcel> dataMap=new HashMap<>();
        if (mappingSupplierData.getParmaMap().keySet().contains(ParmaNumber)) {
            dataMap.put(ParmaNumber, mappingSupplierData.getParmaMap().get(ParmaNumber));
        }if(mappingBuyerData.getParmaMap().containsKey(ParmaNumber)){
            mappingSupplierData.getParmaMap().get(ParmaNumber).setEmailID(mappingBuyerData.getParmaMap().get(ParmaNumber).getEmailID().get(0));
        }
        return dataMap;
    }
    public Map<Integer,ParmaExcel> getSupplierAndBuyerData(List<Integer> ParmaNumber){
        Map<Integer, ParmaExcel> dataMap=new HashMap<>();
        for (Integer parma : mappingSupplierData.getParmaMap().keySet()) {
            if (ParmaNumber.contains(parma)) {
                dataMap.put(parma, mappingSupplierData.getParmaMap().get(parma));
            } if(mappingBuyerData.getParmaMap().containsKey(ParmaNumber)){
                mappingSupplierData.getParmaMap().get(ParmaNumber).setEmailID(mappingBuyerData.getParmaMap().get(ParmaNumber).getEmailID().get(0));
            }}


        return dataMap;
    }

    @Override
    public Map<Integer, SupplierContactsExcel> getSupplierDataTo() {
        return mappingSupplierData.getSupplierMapTO();
    }

    @Override
    public Map<Integer, SupplierContactsExcel> getSupplierDataTo(Integer ParmaNumber) {
        Map<Integer, SupplierContactsExcel> dataMap=new HashMap<>();
        if (mappingSupplierData.getSupplierMapTO().keySet().contains(ParmaNumber)) {
            dataMap.put(ParmaNumber, mappingSupplierData.getSupplierMapTO().get(ParmaNumber));
        }

        return dataMap;


    }

    @Override
    public Map<Integer, SupplierContactsExcel> getSupplierDataTo(List<Integer> ParmaNumber) {
        Map<Integer, SupplierContactsExcel> dataMap=new HashMap<>();
        for (Integer parma : mappingSupplierData.getSupplierMapTO().keySet()) {
            if (ParmaNumber.contains(parma)) {
                dataMap.put(parma, mappingSupplierData.getSupplierMapTO().get(parma));
            } }
        return dataMap;
    }

    @Override
    public Map<Integer, SupplierContactsExcel> getSupplierDataCC() {
        return mappingSupplierData.getSupplierMapCC();
    }

    @Override
    public Map<Integer, SupplierContactsExcel> getSupplierDataCC(Integer ParmaNumber) {
        Map<Integer, SupplierContactsExcel> dataMap=new HashMap<>();
        if (mappingSupplierData.getSupplierMapCC().keySet().contains(ParmaNumber)) {
            dataMap.put(ParmaNumber, mappingSupplierData.getSupplierMapCC().get(ParmaNumber));
        }

        return dataMap;

    }

    @Override
    public Map<Integer, SupplierContactsExcel> getSupplierDataCC(List<Integer> ParmaNumber) {
        Map<Integer, SupplierContactsExcel> dataMap=new HashMap<>();
        for (Integer parma : mappingSupplierData.getSupplierMapCC().keySet()) {
            if (ParmaNumber.contains(parma)) {
                dataMap.put(parma, mappingSupplierData.getSupplierMapCC().get(parma));
            } }
        return dataMap;
    }
}
