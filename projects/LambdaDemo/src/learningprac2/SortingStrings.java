package learningprac2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingStrings {

    public static void main(String[] args) {
        String[] words = {"hoppy","sad","fish","pop","fresh","cat","happy"};
        List<String> wordList = new ArrayList<>();
        Collections.addAll(wordList,words);

        System.out.println("Before Sort: "+wordList);
        simpleSort(wordList);
        System.out.println("After Sort: "+wordList);

        System.out.println("Before Sort: "+wordList);
        complexSort(wordList);
        System.out.println("After Sort: "+wordList);

    }

    /**
     * This method uses Collections.sort() with a simple Lambda Expression to sort the words by shortest to longest
     * @param wordList - words to be sorted
     */
    public static void simpleSort(List<String> wordList){
        // one line of code collections.sort(wordlist, come up with simple lambda expression
        wordList.sort(() -> );
    }

    /**
     * This method uses Collections.sort() with a complex Lambda Expression to sort the words by shortest to longest
     *  if the word lengths are equals, sort alphabetically
     * @param wordList - words to be sorted
     */
    public static void complexSort(List<String> wordList){
        // one line of code, Collections.sort(wordList, come up with complex lambda expression
        // use curly braces for logic
    }
}
