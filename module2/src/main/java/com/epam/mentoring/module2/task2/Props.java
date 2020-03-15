package com.epam.mentoring.module2.task2;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class Props {

    private Map<Integer, String> properties = new HashMap<>();
    private Map<String, Integer> reverseProperties = new HashMap<>();
    private String resourceFolder;

    private void reverseProps() {
        for (Map.Entry<Integer, String> entry : properties.entrySet()) {
            if (reverseProperties.containsKey(entry.getValue())) {
                throw new DuplicateKeyException("A duplicate key was found. Check the initial properties file first");
            } else {
                reverseProperties.put(entry.getValue(), entry.getKey());
            }
        }
    }

    private List<String> sortKeys(Map<String, Integer> props) {
        return props.keySet().stream().sorted().collect(Collectors.toList());
    }

    private void readProps(String propertiesFileName) {
        try {
            Properties properties = new Properties();
            URL url = this.getClass().getClassLoader().getResource(propertiesFileName);
            File file = new File(url.getPath());
            System.out.println(file.getCanonicalPath());
            properties.load(this.getClass().getClassLoader().getResourceAsStream(propertiesFileName));
            properties.forEach((k, v) -> this.properties.put(Integer.valueOf((String) k), (String) v));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveNewSortedProperties() {
        try {
            FileWriter out = new FileWriter("test_out.properties");
            List<String> sortedKeys = sortKeys(reverseProperties);
            for (String key : sortedKeys) {
                out.write(key + "=" + reverseProperties.get(key) + "\n");
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Props props = new Props();
        props.readProps("test.properties");
        props.reverseProps();
        props.saveNewSortedProperties();
    }
}
