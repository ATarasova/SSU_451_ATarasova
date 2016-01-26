import sun.util.resources.CalendarData_pt;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by TarasovaAA on 19.01.2016.
 */
public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your year:");
        int year = scanner.nextInt();
        if ((year >= 1800) && (year <= 2016)) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.DAY_OF_MONTH, 13);
            for (int i = 0; i < 12; i++) {
                calendar.set(Calendar.MONTH, i);
                String day = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US);
                if (day.equals("Fri")) {
                    String month = calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.US);
                    System.out.print(month + " ");
                }
            }
        }
        else {
            System.out.println("Wrong year.");
        }
        System.out.println(" ");
        System.out.println("Enter your month:");
        int month = scanner.nextInt();
        if ((month >= 1) && (month <= 12)) {
            calendar.set(Calendar.MONTH, month - 1);
            calendar.set(Calendar.DAY_OF_MONTH, 13);

            int cur = 0;
            for (int i = 1800; i < 2017; i++) {
                calendar.set(Calendar.YEAR, i);
                String day = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US);
                if (day.equals("Fri")) {
                    cur++;
                    System.out.println(i);
                }
            }
            System.out.println(cur);
        }
            else{
                System.out.println("Wrong month.");
            }

    }

}