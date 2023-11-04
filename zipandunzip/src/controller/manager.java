package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class manager {

    validation vali = new validation();

    public boolean compressTo(String pathSrc, String fileZipName, String pathCompress) throws IOException {
        String sourceFile = pathSrc;
        String nameFos = pathCompress + File.separator + fileZipName + ".zip";

        try (FileOutputStream fos = new FileOutputStream(nameFos);
                ZipOutputStream zipOut = new ZipOutputStream(fos);
                FileInputStream fis = new FileInputStream(sourceFile)) {

            File fileToZip = new File(sourceFile);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            final byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }

            return true;
        }
    }

    public boolean extractTo(String pathZipFile, String pathExtract) throws IOException {
        String fileZip = pathZipFile;
        byte[] buffer = new byte[1024];

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip))) {
            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                String fileName = zipEntry.getName();
                File newFile = new File(pathExtract, fileName);

                try (FileOutputStream fos = new FileOutputStream(newFile)) {
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                }
            }
        }

        return true;
    }
}
