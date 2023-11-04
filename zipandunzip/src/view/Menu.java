package view;

import controller.validation;
import java.io.IOException;
import model.File;

public class Menu {

    public void printMain() throws IOException {
        File file = new File();
        validation vali = new validation();
        while (true) {
            System.out.println("1. Compression");
            System.out.println("2. Extraction");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = vali.checkIntLimit(1, 3);

            switch (choice) {
                case 1:
                    file.zipFile();
                    break;
                case 2:
                    file.unzipFile();
                    break;
                case 3:
                    return;
            }
        }
    }
}
