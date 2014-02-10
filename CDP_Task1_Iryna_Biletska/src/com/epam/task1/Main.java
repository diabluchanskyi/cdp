package com.epam.task1;

import java.io.IOException;
import java.util.*;

/**
 * Created by Iryna Biletska on 09.02.14.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter file name: ");
            String fileName = scanner.next();

            System.out.println("Enter keyword: ");
            String keyWord = scanner.next();

            printTestResults(new TreeMap<String, Integer>(), keyWord, fileName);
            printTestResults(new HashMap<String, Integer>(), keyWord, fileName);
        } catch (IOException e) {
            System.out.println("Something was wrong during working with the file.");
        }
    }

    private static void printTestResults(Map<String, Integer> map, String keyWord, String fileName) throws IOException{
        System.out.println("--------------" + map.getClass().getSimpleName() + "--------------");

        long startTime = System.nanoTime();
        WordsMapProcessor.fillMapFromFile(map, fileName);
        long duration = System.nanoTime() - startTime;
        System.out.println("Words added (" + duration + " nanoseconds)");

        startTime = System.nanoTime();
        int wordMatchesCounter = WordsMapProcessor.countWordMatches(map, keyWord);
        duration = System.nanoTime() - startTime;
        System.out.println("Matches \"" + keyWord + "\": " + wordMatchesCounter + " (" + duration + " nanoseconds)");

        startTime = System.nanoTime();
        int uniqueWordsCounter = WordsMapProcessor.countUniqueWords(map);
        duration = System.nanoTime() - startTime;
        System.out.println("Unique words: " + uniqueWordsCounter + " (" + duration + " nanoseconds)");
    }
}