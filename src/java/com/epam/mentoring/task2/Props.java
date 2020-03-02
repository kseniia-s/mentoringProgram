package com.epam.mentoring.task2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Props {

    private Map<Integer, String> properties = new HashMap<>();
    private Map<String, Integer> reverseProperties = new HashMap<>();

    private void reverseProps() {
        for (Map.Entry<Integer, String> entry : properties.entrySet()) {
            if (reverseProperties.containsKey(entry.getValue())) {
                throw new RuntimeException("A duplicate key was found. Check the initial properties file first");
            } else {
                reverseProperties.put(entry.getValue(), entry.getKey());
            }
        }
    }

    private void printSortedMap(Map<String, Integer> props) {
        props.keySet().stream().sorted().forEach(System.out::println);
    }

    private void readProps(String propertiesFileName) {
        try {
            Properties properties = new Properties();
            properties.load(this.getClass().getClassLoader().getResourceAsStream(propertiesFileName));
            properties.forEach((k, v) -> this.properties.put(Integer.valueOf((String) k), (String) v));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Props props = new Props();
        props.readProps("test.properties");
        props.reverseProps();
        props.printSortedMap(props.reverseProperties);
    }
}
