// public class MyClass {
//     public static void main(String args[]) {
//         int mon = 4;
//         int day = 13;
//         int cols = 5;
//         int total = 30;
//         int [] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//         String formatPattern = "%02d";
//         int col = 0;
//         for (int i = 0; i < total; ++i) {
//             System.out.print(String.format(formatPattern, mon) + "/" + String.format(formatPattern, day) + " AM/PM |\t");
//             ++day;
//             ++col;
//             if (col == cols) {
//                 col = 0;
//                 System.out.println();
//             }
//             if (day > days[mon]) {
//                 day = 1;
//                 ++mon;
//                 if (mon >= days.length) {
//                     mon = 1;
//                 }
//             }
//         }
//     }
// }

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyClass {
    public static void main(String[] args) {
        // Set the start date
        LocalDate startDate = LocalDate.of(2024, 4, 13);

        // Print the calendar
        printCalendar(startDate);
    }

    public static void printCalendar(LocalDate startDate) {
        // Define the date formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");

        // Print the calendar header
        System.out.println("       Mon       Tue       Wed       Thu       Fri       Sat       Sun");

        // Determine the day of the week for the start date
        int dayOfWeek = startDate.getDayOfWeek().getValue();

        // Print the leading spaces for the start date
        for (int i = 1; i <= dayOfWeek; i++) {
            System.out.print("        ");
        }
        System.out.print("  ");

        // Print the calendar days
        for (int i = 0; i < 30; i++) {
            System.out.printf("%4s AM/PM", startDate.format(formatter));
            if (dayOfWeek % 7 == 0) {
                System.out.println();
            }
            startDate = startDate.plusDays(1);
            dayOfWeek++;
        }
    }
}
