package com.crocarneiro.utils;

import java.io.*;

public class FileHelper {
    public static String readFile(String fileName) {
        var file = new File(fileName);
        try (var inputStream = new FileInputStream(file)) {
            return readFromInputStream(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
