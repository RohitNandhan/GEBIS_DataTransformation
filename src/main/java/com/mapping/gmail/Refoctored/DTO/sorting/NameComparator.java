package com.mapping.gmail.Refoctored.DTO.sorting;

import com.mapping.gmail.Refoctored.Bean.ParmaExcel;

import java.util.Comparator;

public class NameComparator implements Comparator<ParmaExcel> {


    @Override
    public int compare(ParmaExcel o1, ParmaExcel o2) {
        return o1.getParmaname().compareTo(o2.getParmaname());
    }
}
