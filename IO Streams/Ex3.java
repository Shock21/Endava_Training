package com.endava.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tvasile on 7/19/2016.
 */
public class Ex3 {

    public static void PrintDirectoryContents(String fileName) {
        File file = new File(fileName);
        System.out.println(file.getName());
        String tab = "\t";
        for(File directoryFile : file.listFiles()) {
            System.out.println(tab + directoryFile.getName());
            if(directoryFile.isDirectory()) {
                ExploreDirectory(directoryFile, tab);
            }
        }
    }

    public static void ExploreDirectory(File file, String tab) {
        tab += tab;
        for(File directoryFile : file.listFiles()) {
            if(directoryFile.isDirectory()) {
                ExploreDirectory(directoryFile, tab);
            }
            System.out.println(tab + directoryFile.getName());
        }
    }

    public static void main(String[] args) {
        String fileName = "D:/java-io-files";
        PrintDirectoryContents(fileName);
    }

}
