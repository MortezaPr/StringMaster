import java.util.Objects;

public class B_StringMethods {
    /**
     * <p>Makes the full name with specified the first and the last name. If a
     * field is not provided only use the provided one. If neither of fields
     * provided return an empty string.</p>
     *
     * @param firstName the given first name
     * @param lastName the given last name
     * @return the full name
     */
    public static String fullName(String firstName, String lastName) {
        if (Objects.equals(lastName, "")) {
            return firstName + lastName;
        } else {
            return firstName + " " + lastName;
        }
    }

    /**
     * <p>Checks هf the number of repetitions of the specified character in a
     * string is a certain number</p>
     *
     * @param text the given text
     * @param ch the given character
     * @param cnt the given number
     * @return whether the number of repetitions of the character is equal to
     * the given number
     */
    public static boolean certainNumberOfChar(String text, char ch, int cnt) {
        int length = text.length();
        int repeat = 0; 
        for (int i = 0; i < length; i++ ) {
            if ( text.charAt(i) == ch ) {
                repeat++;
            }
        }
        return repeat == cnt;
    }

    /**
     * <p>Returns the first word alphabetically (According to the dictionary
     * order)</p>
     *
     * @param wordA the first word
     * @param wordB the second word
     * @return the smaller word
     */
    public static String firstWord(String wordA, String wordB) {
        String answer = " ";
        if ( wordA.compareTo(wordB) > 0 ) {
            answer = wordB;
        } else if ( wordA.compareTo(wordB) < 0) {
            answer = wordA;
          }
         return answer;
    }
}
