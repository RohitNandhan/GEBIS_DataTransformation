package com.mapping.gmail.Refoctored.DTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConversionUtils {
    static class CurrentDataFormatted{

        static void  getDate() {
            LocalDate currentDate = LocalDate.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM");

            String formattedDate = currentDate.format(formatter);
            System.out.println(formattedDate);
        }
    }
}
