package Palindrome;
import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

public class Palindrome {
    private static final Logger logger = Logger.getLogger(Palindrome.class);

    private String input;
    private Set<String> result;

    public Palindrome(String input) {
        this.input = input;
        result = new HashSet<>();
    }

    public Set<String> palindromes() {  //Find palindromes and adds them into collection Set<String> result
        for (int i = 0; i < input.length(); i++) {
            expandPalindromes(i, i + 1);    // expanding even length palindromes:
            expandPalindromes(i, i);           // expanding odd length palindromes:
        }
        return result;
    }

    private void expandPalindromes(int i, int j) {      // Adding parts of number to collection
        while (i >= 0 && j < input.length() && input.charAt(i) == input.charAt(j)) {
            result.add(input.substring(i, j + 1));
            i--;
            j++;
        }
    }

    public void printPalindromesMoreThenTen(Set<String> result) {
        this.result = result;
        for (String palindrome : result) {
            if (palindrome.length() > 1) {
                logger.info(palindrome);
            }
        }
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

}
