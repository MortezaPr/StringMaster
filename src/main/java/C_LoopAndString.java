import java.util.ArrayList;

public class C_LoopAndString {
    /**
     * <p>Returns true if the string contains two consecutive character of
     * specified type.</p>
     *
     * <p>Example: "abbc" has two consecutive 'b'</p>
     *
     * @param s the given string
     * @param ch the given character
     * @return whether the string contains at least one consecutive pair of
     * the given character
     */
    public static boolean containsDoubleChar(String s, char ch) {
        int length = s.length();
        boolean answer = false;
        for (int i = 0; i < length; i++ ) {
            if (s.charAt(i) == ch) {
                if ( i+1 < length && s.charAt(i+1) == ch ) {
                        answer = true;
                }
            }
            if (answer) {
                break;
            }
        }
        return answer;
    }

    /**
     * <p>Implement Caesar cipher encryption algorithm (tag: cryptography)
     * Google it for more information</p>
     * <p>Only encrypt alphabetical characters:
     * <b>"ab c" shift=3 => "de f"</b></p>
     *
     * @param s text
     * @param offset shift amount
     */
    public static String caesarEncrypt(String s, int offset) {
        char ch;
        StringBuilder encryptedMessage = new StringBuilder();
       for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                ch = (char)(ch + offset);
                
                while(ch > 'z'){
                    ch = (char)(ch - 'z' + 'a' - 1);
                }

                while(ch < 'a') {
                    ch = (char)( ch - 'a' + 'z' + 1);
                }
                
                encryptedMessage.append(ch);
            }
            else if(ch >= 'A' && ch <= 'Z'){
                ch = (char)(ch + offset);
                
                while(ch > 'Z'){
                    ch = (char)(ch - 'Z' + 'A' - 1);
                }

                while(ch < 'A') {
                    ch = (char)( ch - 'A' + 'Z' + 1);
                }
                
                encryptedMessage.append(ch);
            }
            else {
             encryptedMessage.append(ch);
            }
    }
       return encryptedMessage.toString();
    }

    /**
     * <p>Implement Caesar cipher decryption algorithm (tag: cryptography)</p>
     * Google it for more information.</p>
     * <p>Ignore space: <b>"de f" shift=3 => "ab c"</b></p>
     * <p>You can use encryption method here.</p>
     *
     * @param s text
     * @param c shift amount
     */
    public static String caesarDecrypt(String s, int c) {
        return caesarEncrypt(s, -c);
    }
    /*
    If you have implemented all the previous parts completely and correctly
    feel free and add other methods as much as you want. Each extra method
    can add up to 5 points.
    Each method must come with its own unit-test.
     */

    /**
     * <p>Returns morse code</p>
     * <p>Example: java ==> .--- .- ...- .- </p>
     * @param code morse code of each word
     * @param englishLang the given english text
     * @param letter all english alphabets
     */
    public static String englishToMorse(String[] code, String englishLang, char[] letter) {
        StringBuilder morse = new StringBuilder();
        for (int i = 0; i < englishLang.length(); i++) {
            for (int j = 0; j < letter.length; j++) {
                if (englishLang.charAt(i) == letter[j]) {
                    morse.append(code[j]);
                    if (i != englishLang.length()-1) {
                        morse.append(" ");
                    }
                    break;
                }
            }
        }
        return morse.toString();
    }


    /**
     * <p>Returns reversed version of the given text ( word by word )</p>
     * <p>Example: I love programming ==> programming love I</p>
     * @param str the given text
     */
    public static String reverser(String str) {
        String[] words = str.split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if ( i!= 0 ) {
                reversed.append(" ");
            }
        }
        return reversed.toString();
    }

    /**
     * <p>Returns true if the two given strings are equal</p>
     * <p>Example: eqefgsfzfcvhdfafadkkfd,eqefgsfzfcvhdfafadkkfd ==> true</p>
     * @param str1 the given string
     * @param str2 the given string
     */
    public static boolean equal(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        if (length1 != length2) {
            return false;
        }
        else {
            for (int i = 0; i < length1; i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * <p>Returns a secret code, the last letter of the word goes to first then for each letter ascii code
     * increases one unit</p>
     * <p>Example: abz ==> (last letter goes to first)zab ==> (plus one) abc</p>
     * @param str the given text
     * @param alphabet all english alphabets
     */
    public static String secretCode(String str, char[] alphabet) {
        int n = str.length();
        char[] words = str.toCharArray();
        char[] lastToFirst = new char[n];
        lastToFirst[0] = words[n-1];
            System.arraycopy(words, 0, lastToFirst, 1, n - 1);
            StringBuilder secretCode = new StringBuilder();
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < 26; i++) {
                    if (lastToFirst[j] == alphabet[i]) {
                        i++;
                        if (i > 25) {
                            i = 0;
                        }
                        secretCode.append(alphabet[i]);
                        break;
                    }
                }
            }
        return secretCode.toString();
    }

    /**
     * <p>Returns a number that represent the quantity of the characters that exist in both strings</p>
     * <p>Example: home,hello ==> 2</p>
     * @param str1 the given text
     * @param str2 the given text
     */
    public static int charInCommon(String str1, String str2) {
        str1 = str1.replaceAll("\\s+", "");
        str2 = str2.replaceAll("\\s+", "");
        int length1 = str1.length();
        int length2 = str2.length();
        ArrayList<Character> chars = new ArrayList<>();
        int inCommon = 0;
        for (int i = 0; i < length1; i++) {
            boolean again = false;
            char upper1 = Character.toUpperCase(str1.charAt(i));
            char lower1 = Character.toLowerCase(str1.charAt(i));
            for (Character aChar : chars) {
                if (aChar == upper1 || aChar == lower1) {
                    again = true;
                    break;
                }
            }
            if (again) {
                continue;
            }
            for (int j = 0; j < length2; j++) {
                char upper2 = Character.toUpperCase(str2.charAt(j));
                char lower2 = Character.toLowerCase(str2.charAt(j));
                if (upper1 == upper2 || lower1 == lower2 ) {
                    inCommon++;
                    chars.add(upper1);
                    chars.add(lower1);
                    break;
                }
            }
        }
        return inCommon;
    }
}





