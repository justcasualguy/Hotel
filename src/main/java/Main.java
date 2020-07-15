import properties.GlobalProperties;
import properties.XPaths;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale locale = new Locale("en");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy",locale);
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.format(dateTimeFormatter));
    }
}
