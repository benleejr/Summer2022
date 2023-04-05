/*
 *
 *
 */
/**
 *
 * @author Hales
 */
public class ReverseAString {
    
    public static String reverseString(String string) {
        //check for base case
        if(string.length() == 1) {
            return string;
        }
        //make recursive call on reduced problem
        return reverseString(string.substring(1)) + string.charAt(0);
    }
    
    public static String reverseString_it(String string) {
        String reverseString = "";
        while(string.length() > 0) {
            reverseString = string.charAt(0) + reverseString;
            string = string.substring(1);
        }
        return reverseString;
    }
    
    public static boolean testForPalindrome(String testString) {
        if(testString.length() == 0 || testString.length() == 1) {
            return true;
        }
        if(testString.charAt(0) != testString.charAt(testString.length() - 1)) {
            return false;
        }
        return testForPalindrome(testString.substring(1, testString.length() - 1));
    }
    
    public static void main(String[] args) {
        String text = "Hello World!";
        System.out.println(text + reverseString_it(text));
        System.out.println(text + reverseString(text));
        
        String text2 = "RACECAR";
        System.out.println(text2 + testForPalindrome(text2));
    }
}
