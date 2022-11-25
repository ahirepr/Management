package com.ness.org;

import java.io.FileOutputStream;
import java.io.IOException;

public class Testing {
    public static void main(String[] args) throws IOException {
    	FileOutputStream fos=new FileOutputStream("/home/pankaj/sampledemo.txt");
       // Files.writeString(Paths.get("D://output.txt"), "some text to write", StandardOpenOption.CREATE);
    System.out.println("fileadd :"+fos);
    }
}
