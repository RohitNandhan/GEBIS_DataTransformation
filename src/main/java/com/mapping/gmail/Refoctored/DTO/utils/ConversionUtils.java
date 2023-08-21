package com.mapping.gmail.Refoctored.DTO.utils;

import com.mapping.gmail.Refoctored.ExceptionHandling.FolderPresentException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConversionUtils {
    public static class CurrentDataFormatted{

        public static String  getDate() {
            LocalDate currentDate = LocalDate.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM");

            String formattedDate = currentDate.format(formatter);
           return formattedDate;
        }
    }
    public static class CreateDirectory{
        public static void newDirectory(String path){
            Path folderPath= Paths.get(path);
            try{
                if(Files.exists(folderPath)){
                    throw new FolderPresentException(" Folder already Present !");
                }
                Files.createDirectory(folderPath);

            }catch (FolderPresentException e){
                System.err.println(e.getMessage());
            }
            catch (IOException e){
                System.err.println("Error creating folder: " + e.getMessage());
            }
        }
    }
}
