package DateAndTime;

import java.beans.PropertyDescriptor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

// Go to next wave java miscellaneous section
public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2023, Month.APRIL, 15);
        System.out.println(localDate);

        System.out.println(localDate.getYear());
        System.out.println(localDate.getDayOfWeek().getValue());


        // Parsing string to any formatted date
        String dateStr = "28 November 2018";
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        LocalDate date = LocalDate.parse(dateStr, format1);
        System.out.println(date);

        // local date to localDateTime
        LocalDateTime s = localDate.atStartOfDay();

        //Parsing Date to String
        LocalDate localDate1 = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM YYYY");

//        System.out.println("localDate1 : "+ localDate1);
//        System.out.println("localDate1.format(formatter) : "+localDate1.format(formatter));
//        LocalDate parseDate = LocalDate.parse("28 November 2018", formatter);
//        System.out.println("parsed date is : "+parseDate);

        LocalDate now = LocalDate.now();
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        String formattedDate = now.format(format2);
        System.out.println(formattedDate);
    }
}
