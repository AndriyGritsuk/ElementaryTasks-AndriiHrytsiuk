import Palindrome.Palindrome;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TestPalindrome {

    @DataProvider(name = "dataForPalindrome")
    public static Object[][] data() {
        return new Object[][]{
                {"12344321", new HashSet<>(Arrays.asList("1", "2", "3", "4", "44", "3443", "234432", "12344321"))},
                {"1234321", new HashSet<>(Arrays.asList("1", "2", "3", "4", "343", "23432", "1234321"))},
                {"0", new HashSet<>(Arrays.asList("0"))},
                {"", new HashSet<>(Collections.emptyList() )},
                {"123456789", new HashSet<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"))},
                {"123454", new HashSet<>(Arrays.asList("1", "2", "3", "4", "5", "454"))},
                {"121454", new HashSet<>(Arrays.asList("1", "2", "4", "5", "121", "454"))},
                {"111111", new HashSet<>(Arrays.asList("1", "11", "111", "1111", "11111", "111111"))}
        };
    }

    @Test(dataProvider = "dataForPalindrome")
    public void testPalindromes(String input, Set<String> expectedResult){

        Palindrome pal = new Palindrome(input);

        Set<String> actualResult = pal.palindromes();
        Assert.assertEquals(expectedResult, actualResult, "Oops! It's doesn't work.");
    }
}
