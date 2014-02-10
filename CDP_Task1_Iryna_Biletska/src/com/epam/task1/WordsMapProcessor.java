package com.epam.task1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by Iryna Biletska on 09.02.14.
 */
public class WordsMapProcessor {
    private WordsMapProcessor() {}

    public static int countWordMatches(Map<String, Integer> wordsMap, String word) {
        return wordsMap.get(word) != null ? wordsMap.get(word) : 0;
    }

    public static int countUniqueWords(Map<String, Integer> wordsMap) {
        int uniqueWordsCounter = 0;
        for (Entry<String,Integer> entry : wordsMap.entrySet()) {
            if (entry.getValue() == 1)
                ++uniqueWordsCounter;
        }
        return uniqueWordsCounter;
    }

    public static void fillMapFromFile(Map<String, Integer> map, String fileName) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "Windows-1251"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("[^А-Яа-яA-Za-z]+");
                for (String word : words) {
                    int newCounter = map.get(word.toLowerCase()) != null ? map.get(word.toLowerCase()) + 1 : 0;
                    map.put(word.toLowerCase(), newCounter);
                }
            }
        } finally {
            if (br != null)
                br.close();
        }
    }
}
