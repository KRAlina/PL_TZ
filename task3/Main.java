package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        File fileTests = new File (args[0]);
        File fileValues = new File (args[1]);
        File fileResult = new File (args[2]);

        Map<Long, String> valueById = new HashMap<>();
        StringBuilder resultString = new StringBuilder();

        long id = -1;
        String value = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileTests))) {
            String line = br.readLine();
            while (line != null) {

                if (line.contains("\"id\"")) {
                    int startIdIndex = line.lastIndexOf(":");
                    id = Long.parseLong(line.substring(startIdIndex + 1, line.length() - 1)
                            .strip());
                    if (value != null) {
                        valueById.put(id, value);
                        id = -1;
                        value = null;
                    }

                } else if (line.contains("\"value\"")) {
                    int startIdIndex = line.lastIndexOf(":");
                    value = line.substring(startIdIndex + 1, line.length() - 1)
                            .replace("\"", "")
                            .strip();
                    if (id != -1) {
                        valueById.put(id, value);
                        id = -1;
                        value = null;
                    }
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        id = -1;
        value = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileValues))) {
            String line = br.readLine();
            while (line != null) {

                if (line.contains("\"id\"")) {
                    int startIdIndex = line.lastIndexOf(":");
                    id = Long.parseLong(line.substring(startIdIndex + 1, line.length() - 1)
                            .strip());
                    if (value != null) {
                        resultString.append(value.replace("\"\"", "\""
                                + Optional.ofNullable(valueById.get(id)).orElse("")
                                + "\"")).append("\n");
                        value = null;
                        id = -1;
                    }
                    resultString.append(line).append("\n");

                } else if (line.contains("\"value\"")) {
                    if (id != -1) {
                        resultString.append(line.replace("\"\"", "\""
                                + Optional.ofNullable(valueById.get(id)).orElse("")
                                + "\"")).append("\n");
                        value = null;
                        id = -1;
                    } else {
                        value = String.copyValueOf(line.toCharArray());
                    }
                } else {
                    resultString.append(line).append("\n");
                }

                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileResult))) {
            bw.write(resultString.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}