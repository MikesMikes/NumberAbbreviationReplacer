import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> ordinals = new ArrayList<>(Arrays.asList("12th", "9th", "23rd", "25th", "1st", "18th"));
        String string = "13th";
        for (String i : ordinals) {
            System.out.println(CenturyReplacer.getComplete(i));

        }
        System.out.println(CenturyReplacer.getComplete(string));
        System.out.println(CenturyReplacer.isOrdinal("8rd"));


    }
}

