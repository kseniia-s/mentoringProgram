package module3.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static String getFormattedCurrentDate(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd");
        return date.format(formatter);
    }

    public static String getTomorrowDate(){
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        return tomorrow.format(formatter);
    }
}
