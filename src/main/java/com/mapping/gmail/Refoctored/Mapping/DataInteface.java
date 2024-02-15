package com.mapping.gmail.Refoctored.Mapping;

import com.mapping.gmail.Refoctored.Bean.ParmaExcel;
import com.mapping.gmail.Refoctored.Bean.SupplierContactsExcel;
import org.apache.poi.ss.usermodel.Row;

import java.util.Map;

public interface DataInteface {
    void mappingSupplierData();

    //  Map<key, value>
    // Map<Integer, Class parma>
    void mappingToParmaMap(Integer parmaID, String parmaName, String Email, Map<Integer, ParmaExcel> parmaMap);

    void mappingToSupplierMap(Integer parmaID, String parmaName, String Email, String title, Map<Integer, SupplierContactsExcel> supplierMap);

    void setParmaIndex(Row row);

    Map<Integer, ParmaExcel> getParmaMap();

}
