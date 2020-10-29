package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

/**
 * Complete the hasFiveDistinctVowels method below which is used
 * by fiveUniqueDistinctVowels
 *
 * The fiveUniqueDistinctVowels method will
 * read all of the words in filename and return a list of
 * all words which contain all five vowels, aeiou, where each vowel
 * occurs only once. You may assume that the file will have
 * one word per line.
 */
public class Words {
    /**
     * This method creates and returns a list of all words which contain a,e,i,o,u only once
     *
     * @param filename name of the file containing the words
     * @return a list of words that has vowels a e i o u only once
     */
    public static List<String> fiveUniqueDistinctVowels(String filename) {

        try (Stream<String> lines = Files.lines(Paths.get(filename))) {

            return lines
                    .filter(w -> hasFiveDistinctVowels(w))
                    .collect(Collectors.toList());


        } catch (IOException e) {

            System.err.println(e);

        }

        // return an empty list if there is an IO Exception
        return new ArrayList<String>();

    }



    /**
     * TODO: You will complete this method which is passed a word and returns whether this word
     * has five vowels only once
     * @param word the word to check
     * @return true if word has a,e,i,o,u only once, false otherwise
     */
    public static boolean hasFiveDistinctVowels(String word) {
        // TODO complete this method
        return false;
    }

}
