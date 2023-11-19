package org.example.search;

import java.io.File;
import java.util.List;

public class FileDir {

    public static void searchFile (File file,List<File> fileList){
        if(file.isDirectory()){
            File[] directoryFile = file.listFiles();
            for (File f: directoryFile){
                if(f.isDirectory()){
                    searchFile(f,fileList);
                }else{
                    if(file.getName().toLowerCase().endsWith(".jpg")) fileList.add(f);
                }
            }
        }
    }
}
