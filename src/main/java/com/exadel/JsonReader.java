package com.exadel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.exadel.MainClass.log;

class JsonReader {

    public String readFileToString(String path) {
        StringBuilder result = new StringBuilder();
        File file = new File(path);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            log.error("Can not find file + " + file.getAbsolutePath());
        }
        while (sc.hasNextLine())
            result.append(sc.nextLine());

        log.info("Json read from file.");
        return result.toString();
    }

}
