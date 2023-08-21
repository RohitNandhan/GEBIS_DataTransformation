package com.mapping.gmail.Refoctored.DTO;

import com.mapping.gmail.Refoctored.DTO.utils.ConversionUtils;
import org.junit.Test;

public class ConversionUtilsTest {
    @Test
   public void getDateTest(){
        ConversionUtils.CurrentDataFormatted date=new ConversionUtils.CurrentDataFormatted();
        date.getDate();
    }
    @Test
    public void createDirTest(){
        ConversionUtils.CreateDirectory.newDirectory("src/main/out/MyFolder");
    }
}
