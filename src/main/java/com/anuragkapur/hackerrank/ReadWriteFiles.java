package com.anuragkapur.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author anuragkapur
 */
public class ReadWriteFiles {

    private static ClassLoader classLoader;
    private static String outputFileName = "src/main/resources/sample.out";

    static {
        classLoader = ReadWriteFiles.class.getClassLoader();
    }

    private static void writeOutputToFile(String str) {
        Path file = Paths.get(outputFileName);
        try {
            Files.write(file, str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // Read from file
        URL fileUrl = classLoader.getResource("sample.in");

        BufferedReader reader;
        try {
            if (fileUrl == null) {
                System.out.println("Could not read file sample.in from classpath");
            }
            reader = Files.newBufferedReader(Paths.get(fileUrl.getPath()), StandardCharsets.UTF_8);
            String strLine;
            while ((strLine = reader.readLine()) != null) {
                System.out.println(strLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // write to file
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("test to file output").append("\n").append("works!");
        writeOutputToFile(stringBuilder.toString());
    }
}
