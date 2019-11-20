import Palindrome.Palindrome;
import java.util.Scanner;
import java.util.Set;
import org.apache.log4j.Logger;

public class RunTaskPalindrome implements RunTask {
    private static final Logger logger = Logger.getLogger(RunTaskPalindrome.class);

    public void runTask(){
        ServiceClass printMassage = new ServiceClass();
        Palindrome pal = new Palindrome("");
        do {
            String input = printMassage.messageEnterTheNumber();
            try {
                Long.parseLong(input);  //Validation input data if user enter not a number
                pal.setInput(input);
            } catch (IllegalArgumentException ex) {
                logger.info("You've entered not a number");
            }
        } while (pal.getInput().equals(""));
        Set<String> palindromes = pal.palindromes();    //Create collection Set with parts of the palindrome number
        pal.printPalindromesMoreThenTen(palindromes);   //Show result if length of the number more then 10
    }
}
