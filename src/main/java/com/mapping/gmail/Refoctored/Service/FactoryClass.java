package com.mapping.gmail.Refoctored.Service;

import com.mapping.gmail.Refoctored.Mapping.DataInteface;
import com.mapping.gmail.Refoctored.Mapping.MappingBuyer;
import com.mapping.gmail.Refoctored.Mapping.MappingData;
import com.mapping.gmail.Refoctored.Mapping.MappingSupplierContact;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FactoryClass {
    public  static DataInteface getInstance(String classname, File file) throws IOException, InvalidFormatException {

        if (classname.equals(MappingBuyer.class.toString()))
            return new MappingBuyer(file);

        else if (classname.equals(MappingSupplierContact.class.toString()))
        return new MappingSupplierContact(file);

        else
            throw new FileNotFoundException();


    }

}
