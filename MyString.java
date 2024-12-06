/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "";
        System.out.println(spacedString(hello));
        System.out.println(subsetOf("runi", "running"));
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ch){
                count++;
            }
        }
        return count;

    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        String str3 = str1;
        String str4 = str2;
        boolean charInString;

        for (int i = 0; i < str3.length(); i++){
            charInString = false;
            for (int j = 0; j < str4.length(); j++){
                if (str3.charAt(i) == str4.charAt(j)){
                    charInString = true;
                    if (j != str4.length() - 1){
                    str4 = str4.substring(0, j) + str4.substring(j + 1);
                    }
                    else {
                        str4 = str4.substring(0, j);
                    }
                }
            }
            if (!charInString){
                return false;
            }
        }
        return true;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        if (str == ""){
            return "";
        }
        String str2 = "";
        str2 += str.charAt(0);
        for (int i = 1; i < str.length(); i++){
            str2 += " " + str.charAt(i);
        }
        return str2;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String str = "";
        for (int i = 0; i < n; i++){
            int rand = (int)(Math.random() * 26);
            char c = (char)(97 + rand);
            str += c;
        }
        return str;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        String str3 = str1;
        String str4 = str3;
        
        while (!str4.isEmpty()){
         for (int i = 0; i < str3.length(); i++){
             if (str3.charAt(i) == str4.charAt(0)){
                 if (i == 0){
                     str3 = str3.substring(1);
                 }
                 else{
                     str3 = str3.substring(0, i) + str3.substring(i + 1, str3.length());
                 }     
                 break;
             }
         }
         str4 = str4.substring(1);
        }
         return str3;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
