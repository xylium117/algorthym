import java.util.Random;

public class Arithmetic {

    public static void main ( String... args ) {
        System.out.println( "PRIME FACTORS of 258060:" );
        primeFactors( 258060 );
        System.out.println( );

        System.out.println( "FACTORIAL of 7 = " + factorial( 7 ) );
        System.out.println( );

        int a = 645;
        int b = 302;
        System.out.println( "For 2 numbers " + a + " and " + b + ", " );
        System.out.println( "GCD = " + findGCD( a, b ) );
        System.out.println( "LCM = " + findLCM( a, b ) );
        System.out.println( "\nUsing Recursion, " );
        System.out.println( "GCD = " + recurGCD( a, b ) );
        System.out.println( "LCM = " + recurLCM( a, b ) );

        int prime = 104729;
        int composite = 68616;
        System.out.println( "\nPRIME NUMBERS" );
        System.out.println( "Is " + prime + " a PRIME number? " + isPrime( prime ) );
        System.out.println( "Is " + composite + " a PRIME number? "
                + isPrime( composite ) );

        System.out.println( "\nFIBONACCI SERIES" );
        int n = 16;
        var i = new Random( ).nextInt( n ) + 1; // random integer between 1 and n
        System.out.print( "FIBONACCI SERIES of " + n + " elements: " );
        printFibonacci( n );
        System.out.print( "REVERSED FIBONACCI SERIES of " + n + " elements: " );
        reverseFibonacci( n, 0, 1 );
        System.out.println();
        System.out.println( i + "-th FIBONACCI ELEMENT = " + nThFibonacci( i ) );

        System.out.println( "\nTRIBONACCI SERIES" );
        System.out.print( "TRIBONACCI SERIES of " + n + " elements: " );
        printTribonacci( n );
        i = new Random( ).nextInt( n ) + 1; // random integer between 1 and n
        System.out.println( i + "-th TRIBONACCI ELEMENT = " + nThTribonacci( i ) );

        System.out.println( "\nNUMBER TO WORDS" );
        int num = 536857240;
        System.out.println( num + " is equal to\n" + toWords( num ) );

        System.out.println( "\nSIMPLE TRANSFORMS" );
        int m = 7830;
        System.out.println( "SUM OF DIGITS of " + m + " = " + sumOfDigits( num ) );
        System.out.println( "REVERSE of " + m + " = " + reverse( num ) );

        System.out.println( "\nGOLDBACH PAIRS for 58:" );
        GoldbachPairs( 58 );

        System.out.println( "\nHAPPY NUMBERS" );
        System.out.println( "Is 19 a HAPPY NUMBER? " + isHappy( 19 ) ); // true
        System.out.println( "Is 48 a HAPPY NUMBER? " + isHappy( 48 ) ); // false

        System.out.println( "\nLUCKY NUMBERS" );
        System.out.println( "Is 19 a LUCKY NUMBER? " + isLucky( 19, 2 ) ); // true
        System.out.println( "Is 15 a LUCKY NUMBER? " + isLucky( 15, 2 ) ); // false

        System.out.println( "\nSMITH NUMBERS" );
        System.out.println( "Is 4937775 a SMITH NUMBER? " + isSmith( 4937775 ) ); // true
        System.out.println( "Is 2128521 a SMITH NUMBER? " + isSmith( 2128521 ) ); // false

        System.out.println( "\nPRIME-ADAM NUMBERS" );
        System.out.println( "Is 13 a PRIME-ADAM NUMBER? " + isPrimeAdam( 13 ) ); // true
        System.out.println( "Is 29 a PRIME-ADAM NUMBER? " + isPrimeAdam( 29 ) ); // false

        System.out.println( "\nPRONIC NUMBERS" );
        System.out.println( "Is 20 a PRONIC NUMBER? " + isPronic( 20 ) ); // true
        System.out.println( "Is 23 a PRONIC NUMBER? " + isPronic( 23 ) ); // false

        System.out.println( "\nBOUNCY NUMBERS" );
        System.out.println( "Is 155349 a BOUNCY NUMBER? " + isBouncy( 155349 ) ); // true
        System.out.println( "Is 123456 a BOUNCY NUMBER? " + isBouncy( 123456 ) ); // false

        System.out.println( "\nMONOTONIC NUMBERS" );
        System.out.println( "Is 654321 a MONOTONIC NUMBER? " + isMonotonic( 654321 ) ); // true
        System.out.println( "Is 155349 a MONOTONIC NUMBER? " + isMonotonic( 155349 ) ); // false

        System.out.println( "\nPERFECT NUMBERS" );
        System.out.println( "Is 28 a PERFECT NUMBER? " + isPerfect( 28 ) ); // true
        System.out.println( "Is 13 a PERFECT NUMBER? " + isPerfect( 13 ) ); // false

        System.out.println( "\nARMSTRONG NUMBERS" );
        System.out.println( "Is 153 an ARMSTRONG NUMBER? " + isArmstrong( 153 ) ); // true
        System.out.println( "Is 165 an ARMSTRONG NUMBER? " + isArmstrong( 165 ) ); // false

        System.out.println( "\nMERSENNE PRIMES" );
        System.out.println( "Is 31 a MERSENNE PRIME? " + isMersennePrime( 31 ) ); // true
        System.out.println( "Is 64 a MERSENNE PRIME? " + isMersennePrime( 64 ) ); // false

        System.out.println( "\nFERMAT NUMBERS" );
        System.out.println( "Is 17 a FERMAT NUMBER? " + isFermat( 17 ) ); // true
        System.out.println( "Is 39 a FERMAT NUMBER? " + isFermat( 39 ) ); // false

        System.out.println( "\nCIRCULAR PRIMES" );
        System.out.println( "Is 197 a CIRCULAR PRIME? " + isCircularPrime( 197 ) ); // true
        System.out.println( "Is 289 a CIRCULAR PRIME? " + isCircularPrime( 289 ) ); // false

        System.out.println( "\nHAMMING NUMBERS" );
        System.out.println( "Is 60 a HAMMING NUMBER? " + isHamming( 60 ) ); // true
        System.out.println( "Is 49 a HAMMING NUMBER? " + isHamming( 49 ) ); // false

        double bin = 437.34;
        double hex = 6308.56;
        System.out.println("\nBASE-N CONVERSIONS");
        System.out.println(bin + " (base-10) is equal to " +
                toBaseN( bin, 2 ) + " (base-2)");
        System.out.println(hex + " (base-10) is equal to " +
                toBaseN( hex, 16 ) + " (base-16)");
        System.out.println(  );
        String binary = "1000110110101101.110101001";
        String hexa = "75F7B.14A";
        System.out.println(binary + " (base-2) is equal to " +
                toDecimal( binary, 2 ) + " (base-10)");
        System.out.println(hexa + " (base-16) is equal to " +
                toDecimal( hexa, 16 ) + " (base-10)");

        System.out.println("\nBINARY OPERATIONS");
        String b1 = "0111000011100011", b2 = "110000111010100";
        System.out.println("The BINARY SUM of\n" + b1 + " + " + b2
                + " = " + addBinary( b1, b2 ));
        System.out.println("The DECIMAL SUM of\n"
                + Integer.parseInt( b1, 2 ) + " + "
                + Integer.parseInt( b2, 2 )
                + " = " + (Integer.parseInt( b1, 2 ) + Integer.parseInt( b2, 2 )));
    }


    public static void primeFactors ( int n ) {
        while (n % 2 == 0) {
            System.out.print( 2 + " " );
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt( n ); i += 2) {
            while (n % i == 0) {
                System.out.print( i + " " );
                n /= i;
            }
        }

        if (n > 2)
            System.out.print( n );
        System.out.println( );
    }

    public static int factorial ( int n ) {
        if (n == 0) return 1;
        return n * factorial( n - 1 );
    }

    // CONDITION: a > b
    public static int recurGCD ( int a, int b ) {
        if (b == 0) return a;
        return recurGCD( b, a % b );
    }

    private static int _lcm ( int a, int b, int f ) {
        if (f % a == 0 && f % b == 0) return f;
        return _lcm( a, b, f + Math.max( a, b ) );
    }

    // Helper function
    public static int recurLCM ( int a, int b ) {
        return _lcm( a, b, Math.max( a, b ) );
    }

    public static int findGCD ( int a, int b ) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int findLCM ( int a, int b ) {
        return (a * b) / findGCD( a, b );
    }

    public static boolean isPrime ( int n ) {
        // Edge cases
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        // reduced search using 6k +/- 1 rule
        for (int i = 5; i * i <= n; i += 6)
            if (n % i == 0 || n % (i + 2) == 0) return false;

        return true;
    }

    public static void printFibonacci ( int len ) {
        int A = 0, B = 1, C;
        System.out.print( A + " " + B ); // print 0, 1

        for (int i = 2; i < len; ++i) {
            C = A + B;
            System.out.print( " " + C );
            A = B;
            B = C;
        }
        System.out.println( );
    }

    public static void reverseFibonacci(int n, int a, int b){
        if (n > 0){
            reverseFibonacci (n - 1, b, a + b);
            System.out.print(a + " ");
        }
    }

    public static int nThFibonacci ( int n ) {
        if (n <= 0) throw new IllegalArgumentException( "N must be greater than 0" );
        if (n == 1) return 0;
        if (n == 2) return 1;
        return nThFibonacci( n - 1 ) + nThFibonacci( n - 2 );
    }

    public static void printTribonacci ( int len ) {
        int A = 0, B = 1, C = 1, D;
        System.out.print( A + " " + B + " " + C ); // print 0, 1, 1

        for (int i = 3; i < len; ++i) {
            D = A + B + C;
            System.out.print( " " + D );
            A = B;
            B = C;
            C = D;
        }
        System.out.println( );
    }

    public static int nThTribonacci ( int n ) {
        if (n <= 0) throw new IllegalArgumentException( "N must be greater than 0" );
        if (n == 1) return 0;
        if (n == 2 || n == 3) return 1;
        return nThTribonacci( n - 1 ) + nThTribonacci( n - 2 ) + nThTribonacci( n - 3 );
    }

    public static int sumOfDigits ( int n ) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static int reverse ( int n ) {
        int rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }

    public static String toWords ( int n ) {
        if (n == 0)
            return "ZERO";

        // for numbers from 0 to 19
        String[] units = {
                "", "ONE", "TWO", "THREE",
                "FOUR", "FIVE", "SIX", "SEVEN",
                "EIGHT", "NINE", "TEN", "ELEVEN",
                "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN",
                "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN"
        };

        // for multiples of 10
        String[] tens = {
                "", "", "TWENTY", "THIRTY", "FORTY",
                "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY"
        };

        // for multiples of 100 of previous unit
        String[] multiplier =
                { "", "THOUSAND", "MILLION", "BILLION" };

        StringBuilder num = new StringBuilder( );
        int group = 0;

        // split number in groups of 1000s
        while (n > 0) {
            if (n % 1000 != 0) {
                int val = n % 1000;
                String temp = "";

                // for 3-digit numbers
                if (val >= 100) {
                    temp = units[val / 100] + " HUNDRED ";
                    val %= 100;
                }
                // for 2-digit numbers
                if (val >= 20) {
                    temp += tens[val / 10] + " ";
                    val %= 10;
                }
                if (val > 0) // for 1-digit numbers
                    temp += units[val] + " ";

                // concat group multiplier
                temp += multiplier[group] + " ";
                num.insert( 0, temp );
            }
            n /= 1000;
            group++;
        }
        return num.toString( ).trim( );
    }

    /**
     * A HAPPY NUMBER is a number that eventually reaches 1 on
     * evaluating the sum of the squares of its digits repeatedly.
     * <p>
     * For e.g., 19 is a HAPPY NUMBER.
     */
    public static boolean isHappy ( int n ) {
        int sum = n;
        do {
            sum = sum( sum );
        } while (sum % 10 != sum);
        return (sum == 1);
    }

    // UTILITY ONLY
    private static int sum ( int n ) {
        int s = 0;
        while (n != 0) {
            s += (int) Math.pow( n % 10, 2 );
            n /= 10;
        }
        return s;
    }

    /**
     * Every even number greater than 2 can be expressed
     * as the sum of two prime numbers, which is called
     * a GOLDBACH PAIR.
     * <p>
     * For e.g. 18 = 7 + 11 (7, 11) is a GOLDBACH PAIR
     */
    public static void GoldbachPairs ( int n ) {
        for (int i = 2; i < n - 1; i++) {
            int flag = 0, pair = 0;
            if (isPrime( i )) flag = i;
            for (int j = i; j < n; j++)
                if (isPrime( j ))
                    if (flag + j == n)
                        pair = j;
            if (flag + pair == n)
                System.out.print( flag + ", " + pair + "\n" );
        }
        System.out.println( );
    }

    /**
     * A SMITH NUMBER is a composite number for which
     * the sum of its digits is equal to the sum of the
     * digits of its prime factors (excluding 1).
     * <p>
     * For e.g., 4937775 is a SMITH NUMBER
     */
    public static boolean isSmith ( int n ) {
        int sum = 0, c = n;
        while (n % 2 == 0) {
            sum += 2;
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt( n ); i += 2)
            while (n % i == 0) {
                sum += sumOfDigits( i );
                n /= i;
            }
        if (n > 2) sum += sumOfDigits( n );
        return sum == sumOfDigits( c );
    }

    /**
     * A PRIME-ADAM NUMBER (often referred to as an EMIRP PRIME) is
     * a prime number that remains prime when its digits are reversed.
     * <p>
     * For e.g., 13 and 31 are PRIME-ADAM NUMBERS.
     */
    public static boolean isPrimeAdam ( int n ) {
        return isPrime( n ) && isPrime( reverse( n ) );
    }

    /**
     * A PRONIC NUMBER (also known as OBLONG NUMBER)
     * is a number that is the product of two consecutive integers.
     * <p>
     * For e.g., 20 = 4 x 5 is a PRONIC NUMBER
     */
    public static boolean isPronic ( int n ) {
        int sqrt = (int) Math.sqrt( n );
        return sqrt * (sqrt + 1) == n;
    }


    /**
     * A BOUNCY NUMBER is a positive integer that
     * does not form a strictly increasing or strictly decreasing sequence
     * when its digits are read from left to right.
     * <p>
     * For e.g., 155349 is a BOUNCY NUMBER.
     */
    public static boolean isBouncy ( int n ) {
        boolean inc = false;
        boolean dec = false;
        int prev = n % 10;
        n /= 10;

        while (n > 0) {
            int d = n % 10;
            if (d < prev)
                inc = true;
            else if (d > prev)
                dec = true;
            if (inc && dec)
                return true;

            prev = d;
            n /= 10;
        }
        return false;
    }

    /**
     * A MONOTONIC NUMBER is a positive integer that
     * forms a strictly increasing or strictly decreasing sequence
     * when its digits are read from left to right.
     * <p>
     * For e.g., 12345 is a MONOTONIC NUMBER.
     */
    public static boolean isMonotonic ( int n ) {
        return !isBouncy( n );
    }

    /**
     * A PERFECT NUMBER is a number that is equal
     * to the sum of its proper divisors (excluding itself).
     * <p>
     * For e.g., 6, 28 496 are PERFECT NUMBERS.
     */
    public static boolean isPerfect ( int n ) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0)
                sum += i;
        }
        return sum == n;
    }

    /**
     * An ARMSTRONG NUMBER is a number that is equal
     * to the sum of its own digits, each raised to the power of the number of digits.
     * <p>
     * For e.g., 153 is an ARMSTRONG NUMBER
     */
    public static boolean isArmstrong ( int n ) {
        int sum = 0, c = n;
        int len = String.valueOf( n ).length( );
        while (c != 0) {
            int d = c % 10;
            sum += (int) Math.pow( d, len );
            c /= 10;
        }
        return sum == n;
    }

    /**
     * A MERSENNE PRIME is a prime number that is 1 less than a power of 2.
     * <p>
     * For e.g., 31 is a MERSENNE PRIME
     */
    public static boolean isMersennePrime ( int n ) {
        int p = (int) (Math.log( n + 1 ) / Math.log( 2 ));
        return Math.pow( 2, p ) - 1 == n && isPrime( n );
    }

    /**
     * A FERMAT NUMBER is a number which is of
     * the form 2^(2^n) + 1, where n is any positive integer.
     * <p>
     * For e.g., 17 is a FERMAT NUMBER
     */
    public static boolean isFermat ( long n ) {
        if (n < 3) return false;

        long num;
        for (int i = 0; ; i++) {
            num = (long) Math.pow( 2, Math.pow( 2, i ) ) + 1;
            if (num == n)
                return true;
            if (num > n)
                return false;
        }
    }

    /**
     * A CIRCULAR PRIME is a prime number that
     * remains prime under all rotations of its digits.
     * <p>
     * For e.g., 197, 971 and 719 are CIRCULAR PRIMES.
     */
    public static boolean isCircularPrime ( int n ) {
        String N = Integer.toString( n );
        for (int i = 0; i < N.length( ); i++) {
            int _n = Integer.parseInt( N.substring( i )
                    + N.substring( 0, i ) );
            if (!isPrime( _n ))
                return false;
        }
        return true;
    }

    /**
     * A HAMMING NUMBER, also known as an UGLY NUMBER, is a positive integer
     * that has no prime factors other than 2, 3, or 5.
     * <p>
     * For e.g., 128 is a HAMMING NUMBER.
     */
    public static boolean isHamming ( int n ) {
        if (n <= 0) return false;

        int[] primes = { 2, 3, 5 };
        for (int p : primes)
            while (n % p == 0)
                n /= p;

        return n == 1;
    }

    /**
     * A LUCKY NUMBER is a natural number not eliminated
     * after a sieving process similar to the Sieve of Eratosthenes,
     * where numbers are eliminated based on their position on the
     * number line, rather than their value.
     * <p>
     * For e.g., 7 is a LUCKY NUMBER
     */
    public static boolean isLucky ( int n, int base ) {
        if (base > n)
            return true;
        if (n % base == 0)
            return false;

        int npos = n - (n / base);

        return isLucky( npos, base + 1 );
    }

    public static double toDecimal ( String bin, int base ) {
        String[] parts = bin.split( "\\." );
        int integer = Integer.parseInt( parts[0], base );
        double frac = 0;

        if (parts.length > 1) {
            String f = parts[1];
            for (int i = 0; i < f.length( ); i++)
                if (f.charAt( i ) == '1')
                    frac += Math.pow( base, -(i + 1) );
        }

        return integer + frac;
    }

    public static String toBaseN ( double dec, int base ) {
        if (base < 2 || base > 36) throw new IllegalArgumentException( "Illegal base!" );

        int integer = (int) dec;
        double frac = dec - integer;
        String inStr = Integer.toString( integer, base ).toUpperCase( );

        StringBuilder sb = new StringBuilder( );
        if (frac > 0) {
            sb.append( "." );
            for (int i = 0; i < 5 && frac > 0; i++) {  // precision of 5 places
                frac *= base;
                int digit = (int) frac;
                sb.append( digit < 10 ? digit : (char) ('A' + digit - 10) );
                frac -= digit;
            }
        }

        return inStr + sb;
    }
    public static String addBinary ( String bin1, String bin2 ) {
        StringBuilder result = new StringBuilder( );

        int i = bin1.length( ) - 1;
        int j = bin2.length( ) - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int bit1 = (i >= 0) ? bin1.charAt( i ) - '0' : 0;
            int bit2 = (j >= 0) ? bin2.charAt( j ) - '0' : 0;

            int sum = bit1 + bit2 + carry;
            result.append( sum % 2 );  // append the bit
            carry = sum / 2;         // carry
            i--;
            j--;
        }

        return result.reverse( ).toString( );
    }
}


