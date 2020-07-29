package sample.test;

import java.text.*;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class Main {

    public static void main(String[] args) {
        GregorianCalendar calendar = new GregorianCalendar(Locale.FRANCE);
        DateFormat formatter = DateFormat.getDateTimeInstance(
                DateFormat.FULL, DateFormat.FULL, Locale.GERMANY);
        TimeZone timeZone = TimeZone.getDefault();
        formatter.setTimeZone(timeZone);
        System.out.println("The local time is " +
                formatter.format(calendar.getTime()));

        SimpleDateFormat formatter2
                = new SimpleDateFormat("yyyy.MM.dd G 'at' hh:mm:ss z");
        Date currentTime = new Date();
        String dateString = formatter2.format(currentTime);
        System.out.println("Current time is " + dateString);

        DateFormatSymbols symbols = new DateFormatSymbols();
        String[] monthNames = symbols.getMonths();
        for (String monthName : monthNames) {
            System.out.println(monthName); // Display January, ...
        }
        String[] weekdayNames = symbols.getWeekdays();
        for (String weekdayName : weekdayNames) {
            System.out.println(weekdayName); // Display Sunday, Monday, ...
        }

        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        System.out.println(numberFormat.format(5_000.56));

        NumberFormat currencyFormat =
                NumberFormat.getNumberInstance();
        try {
            Number number = currencyFormat.parse("5000,56");
            System.out.println(number.doubleValue());
        } catch (java.text.ParseException ex) {
            System.out.println("Parse failed");
        }

        NumberFormat uk = NumberFormat.getNumberInstance(Locale.US);
        DecimalFormat decimalFormat = (DecimalFormat) uk;
        decimalFormat.applyPattern("0.0000#");
        System.out.println(decimalFormat.format(12345.678));
        try {
            System.out.println(uk.parse("3,456.78"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
