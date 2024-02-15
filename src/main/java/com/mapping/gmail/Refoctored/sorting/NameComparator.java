package com.mapping.gmail.Refoctored.sorting;

import com.mapping.gmail.Refoctored.Bean.ParmaExcel;

import java.util.Comparator;

public class NameComparator implements Comparator<String> {

    public NameComparator(){}


    @Override
    public int compare(String o1, String o2) {

        return o1.compareTo(o2);
    }
}
