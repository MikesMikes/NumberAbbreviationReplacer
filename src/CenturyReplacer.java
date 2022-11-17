import java.util.HashMap;

/**
 * @author MikesMikes
 */

public final class CenturyReplacer {

    private final static HashMap<String, String> oneToTwentyAbbreviations = initOneToTwentyMap();
    private final static HashMap<String, String> tensSingularAbbreviations = initTensMap();

    public CenturyReplacer() {
    }

    /**
     * Ordinal numbers at least 1 number and 2 alphabetical characters. i.e. 1st = 1 + st.
     * @param string the word to be checked
     * @return boolean check if word is a valid ordinal number
     */
    public static Boolean isOrdinal(String string) {
        if (string.length() < 3) {
            return false;
        }
        String suffix = string.substring(string.length() - 3).trim();
        if (Character.isDigit(string.charAt(0))) {
            if (oneToTwentyAbbreviations.containsKey(string)) {
                return true;
            } else if (suffix.equals("1st")) {
                return true;
            } else if (suffix.equals("2nd")) {
                return true;
            } else if (suffix.equals("3rd")) {
                return true;
            } else if (suffix.substring(1).equals("th")) {
                return true;
            }
        }

        return false;
    }

    /**
     * @param ordinalWord single word as string
     * @return full alphabetic word of the ordinal string
     */
    public static String getComplete(String ordinalWord) {
        char[] charArr = ordinalWord.toCharArray();
        String numberStr = "";
        String result = "";
        String suffix = ordinalWord.substring(ordinalWord.length() - 2);

        for (int i = 0; i < charArr.length; i++) {
            if (Character.isDigit(charArr[i])) {
                numberStr += charArr[i];
            } else {
                break;
            }
        }

        if (numberStr.length() == 1) {
            result += oneToTwentyAbbreviations.get(ordinalWord);
        } else if (numberStr.length() == 2) {
            if (Integer.parseInt(numberStr) <= 20) {
                result += oneToTwentyAbbreviations.get(ordinalWord);
            } else {
                String tens = numberStr.substring(0, 1) + 0;
                String ones = numberStr.substring(1) + suffix;
                result += tensSingularAbbreviations.get(tens);
                result += "-";
                result += oneToTwentyAbbreviations.get(ones);
            }
        }

        return result;
    }

    private static final HashMap<String, String> initOneToTwentyMap() {
        HashMap<String, String> oneToTwenty = new HashMap<>();
        for (int i = 1; i < 21; i++) {
            String centuryAbv = "";
            String centuryFull = "";

            if (i == 1) {
                centuryAbv += "1st";
                centuryFull += "first";
            } else if (i == 2) {
                centuryAbv += "2nd";
                centuryFull += "second";
            } else if (i == 3) {
                centuryAbv += "3rd";
                centuryFull += "third";
            } else if (i == 4) {
                centuryAbv += "4th";
                centuryFull += "fourth";
            } else if (i == 5) {
                centuryAbv += "5th";
                centuryFull += "fifth";
            } else if (i == 6) {
                centuryAbv += "6th";
                centuryFull += "sixth";
            } else if (i == 7) {
                centuryAbv += "7th";
                centuryFull += "seventh";
            } else if (i == 8) {
                centuryAbv += "8th";
                centuryFull += "eighth";
            } else if (i == 9) {
                centuryAbv += "9th";
                centuryFull += "ninth";
            } else if (i == 10) {
                centuryFull += "10th";
                centuryFull += "tenth";
            } else if (i == 11) {
                centuryAbv += "11th";
                centuryFull += "eleventh";
            } else if (i == 12) {
                centuryAbv += "12th";
                centuryFull += "twelfth";
            } else if (i == 13) {
                centuryAbv += "13th";
                centuryFull += "thirteenth";
            } else if (i == 14) {
                centuryAbv += "14th";
                centuryFull += "fourteenth";
            } else if (i == 15) {
                centuryAbv += "15th";
                centuryFull += "fifteenth";
            } else if (i == 16) {
                centuryAbv += "16th";
                centuryFull += "sixteenth";
            } else if (i == 17) {
                centuryAbv += "17th";
                centuryFull += "seventeenth";
            } else if (i == 18) {
                centuryAbv += "18th";
                centuryFull += "eighteenth";
            } else if (i == 19) {
                centuryAbv += "19th";
                centuryFull += "nineteenth";
            } else if (i == 20) {
                centuryAbv += "20th";
                centuryFull += "twentieth";
            }

            oneToTwenty.put(centuryAbv, centuryFull);
        }

        return oneToTwenty;
    }

    private static final HashMap<String, String> initTensMap() {
        HashMap<String, String> tensCardinalToFull = new HashMap<>();

        for (int i = 0; i < 21; i = i + 10) {
            String singularTensAbv = "";
            String singularTensFull = "";

            if (i == 10) {
                singularTensAbv += "10";
                singularTensFull += "ten";
            } else if (i == 20) {
                singularTensAbv += "20";
                singularTensFull += "twenty";
            }

            tensCardinalToFull.put(singularTensAbv, singularTensFull);
        }

        return tensCardinalToFull;
    }
}
