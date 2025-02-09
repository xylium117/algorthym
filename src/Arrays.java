import java.util.Random;
import java.util.Scanner;

public class Arrays {
    public static void main ( String[] args ) {
        System.out.println( "Enter the number of elements to store: " );
        int n = new Scanner( System.in ).nextInt( );

        System.out.println( "Enter " + n + " elements: " );
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = new Scanner( System.in ).nextInt( );

        print( a );

        int[] arr = new int[16];
        randomize( arr );
        System.out.println("SORTING AND ARRANGEMENTS");
        System.out.println( "SAMPLE ARRAY 1" );
        print( arr );

        pendulumSort( arr );
        System.out.println("SELECTION-Sorted Arrangement:");
        selSort( arr );
        print( arr );
        System.out.println("BUBBLE-Sorted Arrangement:");
        bubbleSort( arr );
        print( arr );
        System.out.println("SKEW-Sorted Arrangement:");
        skewSort( arr );
        print( arr );

        System.out.println("\nARRAY OPERATIONS");
        System.out.println("FREQUENCY of Each Unique Element:");
        uniqueFrequency( arr );

        System.out.println("REMVOING DUPLICATES from Array:");
        int len = removeDuplicates( arr );
        print( arr, len);

        int[] array = {6, 2, 4, 6, 3, 13, 1, 30, 2, 26, 0};
        System.out.println( "\nSAMPLE ARRAY 2" );
        print( array, 10);
        System.out.println( "\nInserting `29` at 5-th index..." );
        insertElement( array, 5, 29 );
        print( array, 11 );
        System.out.println( "\nDeleting `2` from the array..." );
        int size = deleteElement( array, 2 );
        print( array, size );
        System.out.println("\nMAXIMA/MINIMA:");
        System.out.println("Maxima = " + max( array ));
        System.out.println("Minima = " + min( array ));

        System.out.println("\nAll PERMUTATIONS of `TACO`: ");
        print(permute( "TACO" ));
    }

    public static void print(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++){
            if (i > 0) System.out.print(", ");
            System.out.print(arr[i]);
        }
        System.out.println("]");
    }

    // UTILITY
    private static void print(String[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++){
            if (i > 0) System.out.print(", ");
            System.out.print(arr[i]);
        }
        System.out.println("]");
    }

    public static void print(int[] arr, int len){
        System.out.print("[");
        for (int i = 0; i < len; i++){
            if (i > 0) System.out.print(", ");
            System.out.print(arr[i]);
        }
        System.out.println("]");
    }

    // UTILITY method to fill matrix with random values
    private static void randomize ( int[] arr ) {
        Random rand = new Random( );
        for (int i = 0; i < arr.length; i++)
                arr[i] = rand.nextInt( arr.length ) + 1;
    }

    public static void pendulumSort ( int[] arr ) {
        int n = arr.length;
        selSort( arr );

        int[] res = new int[n];
        int mid = (n - 1) / 2;

        int j = 1, i;
        res[mid] = arr[0];
        for (i = 1; i <= mid; i++) {
            res[mid + i] = arr[j++];
            res[mid - i] = arr[j++];
        }
        if (n % 2 == 0)
            res[mid + i] = arr[j];

        System.out.println( "PENDULUM-Sorted Arrangement:" );
        print( res );
    }

    public static void selSort ( int[] arr ) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i; j < n; j++)
                if (arr[minIdx] > arr[j])
                    minIdx = j;
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void bubbleSort ( int[] arr ) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
        }
    }

    public static void skewSort ( int[] arr ) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
            while (l < r && arr[l] % 2 != 0)
                l++;
            while (l < r && arr[r] % 2 == 0)
                r--;

            if (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }
    }

    public static int removeDuplicates ( int[] arr ) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; )
                if (arr[i] == arr[j]) {
                    for (int k = j; k < n - 1; k++)
                        arr[k] = arr[k + 1];
                    n--;
                } else
                    j++;
        return n; // new size
    }

    public static void uniqueFrequency ( int[] arr ) {
        boolean[] counted = new boolean[arr.length];

        System.out.printf( "%-10s %-10s%n", "Element", "Frequency" );
        System.out.println( "----------------------" );

        for (int i = 0; i < arr.length; i++) {
            if (!counted[i]) {
                int count = 1;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                        counted[j] = true; // mark duplicate as counted
                    }
                }
                System.out.printf( "%-10d %-10d%n", arr[i], count );
            }
        }
    }

    public static void insertElement ( int[] arr, int index, int element ) {
        int n = arr.length - 1;
        if (index < 0 || index > n)
            throw new ArrayIndexOutOfBoundsException( "Invalid index for insertion." );
        for (int i = n; i > index; i--)
            arr[i] = arr[i - 1]; // shift elements to the right
        arr[index] = element;
    }

    public static int deleteElement ( int[] arr, int element ) {
        int n = 0;

        // shift valid elements to the left
        for (int i = 0; i < arr.length; i++)
            if (arr[i] != element)
                arr[n++] = arr[i];

        // fill the remainder with removed element
        for (int i = n; i < arr.length; i++)
            arr[i] = element;
        return n;
    }

    public static int index = 0;
    private static void permute ( String prefix, String remaining, String[] perms ) {
        int n = remaining.length( );
        if (n == 0)
            perms[index++] = prefix;
        else
            for (int i = 0; i < n; i++)
                permute( prefix + remaining.charAt( i ),
                        remaining.substring( 0, i ) + remaining.substring( i + 1 ),
                        perms );


    }

    // HELPER method
    public static String[] permute ( String s ) {
        index = 0;
        String[] perms = new String[Arithmetic.factorial( s.length( ) )];
        permute( "", s, perms );
        return perms;
    }

    public static int max ( int[] arr ) {
        int max = arr[0];
        for (int element : arr) max = Math.max( element, max );
        return max;
    }

    public static int min ( int[] arr ) {
        int min = arr[0];
        for (int element : arr) min = Math.min( element, min );
        return min;
    }
}