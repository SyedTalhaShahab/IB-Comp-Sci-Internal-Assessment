package views;

import java.util.Comparator;

public class IgnoreCase implements Comparator<String> {// Implemented from Comparator interface. Public method's
                                                       // parameter needs 2 String arguments and returns an int;
                                                       // contrasts the incoming Strings.
    public int compare(String o1, String o2) {
        return o1.compareToIgnoreCase(o2);
    }
}