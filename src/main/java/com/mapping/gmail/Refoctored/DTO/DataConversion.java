package com.mapping.gmail.Refoctored.DTO;

import com.mapping.gmail.Refoctored.Bean.ParmaExcel;
import com.mapping.gmail.Refoctored.Bean.SupplierContactsExcel;
import com.mapping.gmail.Refoctored.DTO.utils.ConversionUtils;
import com.mapping.gmail.Refoctored.Service.ExtractContent;
import com.mapping.gmail.Refoctored.Service.ExtractContentImpl;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataConversion {
    static File outputFile;
    ExtractContent extractContent;

    //DataConversion Object Initilize object for ExtractContent
    //sFile -> supplierContactDetails
    //bFile -> BuyerContactDetails
    DataConversion(File sFile,File bFile) throws IOException, InvalidFormatException {
        extractContent=new ExtractContentImpl(sFile, bFile);
    }

    //Converting Data to Text for Single Parma
        public void convertData(File file,Integer parma) throws IOException {
            MapToText.toText(file,parma,extractContent);
        }
    //Converting Data to Text for List of Parmas
        public void convertData(File file,List<Integer> parma) throws IOException {

            MapToText.toText(file,parma,extractContent);
    }
    //Converting Data to Text for List of Parma , for consolidated mails
        public void convertData(File file,List<Integer> parma,Boolean b) throws IOException {

        MapToText.toTextAllMails(file,parma,extractContent);
    }

    //
    private void setOutputFile(String in,int action){
        String date= ConversionUtils.CurrentDataFormatted.getDate();
        String path="src/main/out/"+date+"/";
        ConversionUtils.CreateDirectory.newDirectory(path);

        switch(action){
            case 1:
                outputFile=new File(path+in);
                break;
            case 2:
                outputFile=new File(path+"CM:"+in);
                break;
        }

    }

    public void mapToText(File inputFile,String action) throws IOException {
        if(action.equalsIgnoreCase("all")){
            List<Integer>parma =extractParma(inputFile);
            //File outputFile = new File("src/main/out/Mails-" + inputFile.getName() );
            setOutputFile(inputFile.getName(),2);
            convertData(outputFile, parma, true);
        }}
    public void mapToText(File inputFile) throws IOException {
        List<Integer>parma =extractParma(inputFile);
      //  File outputFile = new File("src/main/out/" + inputFile.getName() + ".txt");
        setOutputFile(inputFile.getName(),1);
        convertData(outputFile, parma);
    }
    public void mapToText(String input) throws IOException {
        //  File outputFile=new File("src/main/out/"+input+".txt");
        setOutputFile(input,1);
        if(input.split("[\\s,]+").length>1){
            List<Integer> parma= new ArrayList<>();
            parma=stringToIntegerList(input, parma);
            convertData(outputFile,parma);
        }else {
            Integer parma=stringToIntegerList(input);
            convertData(outputFile,parma);
        }}

    public List<Integer> extractParma(File inputFile) throws IOException {
        Scanner sc = new Scanner(inputFile);
        List<Integer> parma = new ArrayList<>();
        while (sc.hasNext()) {
            String line=sc.nextLine();
            Pattern pattern = Pattern.compile("\\d{5}");
            Matcher matcher = pattern.matcher(line);
            matcher.find();
            String input=matcher.group();
            parma = stringToIntegerList(input, parma);
        }
        return parma;
    }

    public List<Integer> stringToIntegerList(String values, List<Integer> parmaList){
        String[] arr=values.split("[\\s,]+");
        for(String a:arr){
            parmaList.add(Integer.parseInt(a.trim()));
        }
        return parmaList;
    }
    public Integer stringToIntegerList(String values){
        Integer parmaList=Integer.parseInt(values.trim());
        return parmaList;
    }

}
