import java.util.Scanner;

public class TimeNDate {
    public static void main ( String... args ) {
        // get user input for date
        Scanner sc = new Scanner( System.in );
        String in;
        do {
            System.out.print( "Enter a date (dd/mm/yyyy): " );
            in = sc.next( );
            if (isValidStr( in )) break;
            System.out.println( "Invalid format. Try again!" );
        } while (true);
        System.out.println( "You entered: " + in );

        System.out.println( "\n----\n" );

        // demonstrate addDays function
        String date = "15/03/2023";
        int N = 20;
        String newDate = addDays( date, N );
        System.out.println( "Original date: " + date );
        System.out.println( "After adding " + N + " days: " + newDate );

        System.out.println( "\n----\n" );

        // demonstrate month length functions
        int m = 2;
        int y = 2024;
        System.out.println( monthName( m ) + ", " + y + ": " + monthLen( m, y ) + " days" );
        System.out.println( monthName( m ) + ", " + y + ": " + monthLen2( m, y ) + " days" );
        System.out.println( monthName( m ) + ", " + y + ": " + monthLen3( m, y ) + " days" );

        System.out.println( "\n----\n" );

        // demonstrate isLeap function
        int leapYear = 2020;
        int nonLeapYear = 2021;
        System.out.println( "Is " + leapYear + " a leap year? " + isLeap( leapYear ) );
        System.out.println( "Is " + nonLeapYear + " a leap year? " + isLeap( nonLeapYear ) );

        System.out.println( "\n----\n" );

        // demonstrate daysBetween function
        String startDate = "15/03/2023";
        String endDate = "5/4/2023";
        int n = daysBetween( startDate, endDate );
        System.out.println( "Number of days between " + startDate + " and " + endDate + ": " + n );

        System.out.println( "\n----\n" );

        // demonstrate isValid function
        int day = 29;
        int invalidMonth = 13;
        int validMonth = 2;
        int validYear = 2024;
        int invalidDay = 32;
        System.out.println( "Is \"29/02/2024\" valid? " + isValid( day, validMonth, validYear ) );
        System.out.println( "Is \"32/01/2023\" valid? " + isValid( invalidDay, 1, 2023 ) );
        System.out.println( "Is \"15/13/2023\" valid? " + isValid( 15, invalidMonth, 2023 ) );
    }

    // add N days to a given date
    public static String addDays ( String date, int N ) {
        try {
            String[] p = date.split( "/" );
            int d = Integer.parseInt( p[0] ) + N;
            int m = Integer.parseInt( p[1] );
            int y = Integer.parseInt( p[2] );
            while (d > monthLen( m, y )) {
                d -= monthLen( m, y );
                m++;
                if (m > 12) {
                    m = 1;
                    y++;
                }
            }
            return d + "/" + m + "/" + y;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return "Invalid date format.";
        }
    }

    // get length of a month using switch
    public static int monthLen ( int m, int y ) {
        return switch (m) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)) ? 29 : 28;
            case 4, 6, 9, 11 -> 30;
            default -> -1;
        };
    }

    // get length of a month using conditional expressions
    public static int monthLen2 ( int m, int y ) {
        return (m == 2) ? (isLeap( y ) ? 29 : 28) : (m < 8 ? 30 + m % 2 : 31 - m % 2);
    }

    // get length of a month using array lookup
    public static int monthLen3 ( int m, int y ) {
        int[] monthLen = { 31, isLeap( y ) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        return monthLen[m - 1];
    }

    // check if a year is leap year
    public static boolean isLeap ( int y ) {
        return (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0));
    }

    // calculate number of days between two dates
    public static int daysBetween ( String sD, String eD ) {
        int n = 0;
        String curr;
        do {
            curr = addDays( sD, n++ );
        } while (!isEqual( curr, eD ));
        return n;
    }

    // check if a date is valid
    public static boolean isValid ( int d, int m, int y ) {
        if (y < 1 || m < 1 || m > 12 || d < 1)
            return false;

        int[] monthLen = { 31, isLeap( y ) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        return d <= monthLen[m - 1];
    }

    // validate a date string format
    public static boolean isValidStr ( String d ) {
        String[] p = d.split( "/" );
        try {
            return isValid(
                    Integer.parseInt( p[0] ),
                    Integer.parseInt( p[1] ),
                    Integer.parseInt( p[2] ) );
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    // get month name from number
    public static String monthName ( int m ) {
        String[] name = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JULY", "AUG", "SEP", "OCT", "NOV", "DEC" };
        return name[m - 1];
    }

    // compare two dates for equality
    public static boolean isEqual ( String d1, String d2 ) {
        String[] p1 = d1.split( "/" );
        String[] p2 = d2.split( "/" );

        if (p1.length != p2.length) return false;
        for (int i = 0; i < p1.length; i++)
            if (Integer.parseInt( p1[i] ) != Integer.parseInt( p2[i] ))
                return false;
        return true;
    }
}
