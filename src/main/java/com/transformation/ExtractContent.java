package com.transformation;

import java.io.File;
import java.util.List;

public class ExtractContent {

        public static List Extract(File file){

           List<String> list= FileReadWrite.readFile(file);
                System.out.println("Size "+list.size());
            File outputFile=new File("src/main/resources/output.txt");
            File outputJson=new File("src/main/resources/output.json");
            FileReadWrite.writeFile(outputFile,list);
            FileReadWrite.writeFileJson(outputJson,list);


            return list;
        }

        public static void toOutputFile(){

//                File outputFile=new File("src/main/resources/output.txt");
//                FileReadWrite.writeFile(file,list);
        }
}
