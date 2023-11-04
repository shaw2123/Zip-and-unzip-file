package model;

import controller.manager;
import controller.validation;
import java.io.IOException;

public class File {

    validation vali = new validation();
    manager mn = new manager();

    public void zipFile() throws IOException {
        System.out.print("Enter Source Folder: ");
        String pathSrc = vali.checkString();
        System.out.print("Enter Destination Folder: ");
        String pathCompress = vali.checkString();
        System.out.print("Enter Name: ");
        String fileZipName = vali.checkString();

        boolean check = mn.compressTo(pathSrc, fileZipName, pathCompress);
        if (check) {
            System.out.println("Successfully compressed.");
        } else {
            System.out.println("Compression failed.");
        }
    }

    public void unzipFile() throws IOException {
        System.out.print("Enter Source file: ");
        String pathZipFile = vali.checkString();
        System.out.print("Enter Destination Folder: ");
        String pathExtract = vali.checkString();
        boolean check = mn.extractTo(pathZipFile, pathExtract);
        if (check) {
            System.out.println("Successfully extracted.");
        } else {
            System.out.println("Extraction failed.");
        }
    }
}
