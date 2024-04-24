package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbsDictionary {
    private Map<String,String> dictionary = new HashMap<String,String>();

    public AbsDictionary(String path) throws IOException {
        fill(path);
    }
    public abstract String getRagex();
    public boolean add(String key, String val){
        if(!key.matches(getRagex()) || dictionary.containsKey(key)){
            throw new IllegalArgumentException("Формат слова " + key + " не подходит для данного словаря" );
        }
        dictionary.put(key, val);
        return true;
    }

    public String dell(String key){
        if(!dictionary.containsKey(key)){
          throw new IllegalArgumentException("Слово не найдено!");
        }
        return key + " - " + dictionary.remove(key);
    }

    public String search(String key){
        if(!dictionary.containsKey(key)){
            throw new IllegalArgumentException("Слово не найдено!");
        }
        return dictionary.get(key);
    }

    public void fill(String path) throws IOException {
        try (FileReader reader = new FileReader(path)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(" - ");
                if (parts.length == 2) {
                    add(parts[0], parts[1]);
                } else {
                    System.err.println("Строка " + line + " не соответствует формату \"ключ - значение\"");
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            builder.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }
        return builder.toString();
    }
}
