import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Matrices {
    public static void main ( String[] args ) {
        // display matrix input prompt
        System.out.println( "MxN MATRIX INPUT" );
        Scanner sc = new Scanner( System.in );
        System.out.println( "Enter the number of rows:" );
        int row = sc.nextInt( );
        System.out.println( "Enter the number of columns:" );
        int col = sc.nextInt( );

        // initialize matrix
        int[][] M = new int[row][col];

        System.out.println( "Enter elements:" );
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                M[i][j] = sc.nextInt( );

        print2D( M );

        System.out.println( "\n----\n" );

        // generate and sort random matrices
        System.out.println( "NxN MATRIX SORTING" );
        System.out.println( "Random Matrix (4x5):" );
        int[][] A = new int[4][5];
        randomize( A );
        print2D( A );
        System.out.println( "Sorted Matrix (with Selection Sort):" );
        selSort2D( A );
        print2D( A );

        System.out.println( "\n----\n" );

        System.out.println( "Random Matrix (4x5):" );
        randomize( A );
        print2D( A );
        System.out.println( "Sorted Matrix (with Bubble Sort):" );
        bubbleSort2D( A );
        print2D( A );

        System.out.println( "\n----\n" );

        System.out.println( "Random Matrix (4x5):" );
        randomize( A );
        print2D( A );
        System.out.println( "Sorted Matrix (Row-Wise)" );
        rowSort( A );
        print2D( A );

        System.out.println( "\n----\n" );

        // find saddle point of matrix
        System.out.println( "SADDLE POINT OF MATRIX" );
        System.out.println( "Sample Matrix (3x3)" );
        int[][] B = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        print2D( B );
        saddlePoint( B );

        System.out.println( "\n----\n" );

        // generate and display spiral matrices
        System.out.println( "NxN SPIRAL MATRICES" );
        int[][] Spyral = new int[5][4];
        int cols = Spyral[0].length, // number of columns
                rows = Spyral.length; // number of rows
        System.out.println( "Spiral Matrix (3x3)" );
        spiral( Spyral, 1, 0, 0, cols - 1, rows - 1, cols * rows );
        print2D( Spyral );

        System.out.println( "\n----\n" );

        System.out.println( "Reversed Spiral Matrix (5x4)" );
        Spyral = new int[5][4];
        revSpiral( Spyral, cols * rows, 0, 0, cols - 1, rows - 1 );
        print2D( Spyral );

        System.out.println( "\n----\n" );

        // generate and display magic square
        System.out.println( "MAGIC SQUARE" );
        int n = 5;
        int[][] magic = magicSquare( n );
        System.out.println( "Magic Square " + "(" + n + "x" + n + ")" );
        print2D( magic );
        int sum = n * (n * n + 1) / 2; // n * (n^2 + 1) / 2
        System.out.println( "Magic Sum: " + sum );

        System.out.println( "\n----\n" );

        // perform matrix transformations
        System.out.println( "MATRIX TRANSFORMATIONS" );
        int[][] C = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 } };
        System.out.println( "Sample Matrix (5x5):" );
        print2D( C );
        printBoundary( C );
        rotate( C );
        printMirror( C );
        swapDiagonal( C );
    }

    // swap the diagonals of the matrix
    public static void swapDiagonal ( int[][] A ) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int temp = A[i][i];
            A[i][i] = A[i][n - i - 1];
            A[i][n - i - 1] = temp;
        }
        System.out.println( "\nSwapped Diagonals:" );
        print2D( A );
    }

    // rotate a matrix by 90 degrees
    public static void rotate ( int[][] A ) {
        int[][] A_ = new int[A[0].length][A.length];
        for (int i = 0; i < A_.length; i++)
            for (int j = 0; j < A_[0].length; j++)
                A_[i][j] = A[A.length - j - 1][i];
        System.out.println( "\nRotated by 90°:" );
        print2D( A_ );
    }

    public static void print2D ( int[][] M ) {
        // print matrix in 2D format
        for (int[] arr : M) {
            for (int elem : arr) System.out.print( elem + "\t" );
            System.out.println( );
        }
    }

    // UTILITY method to fill matrix with random values
    private static void randomize ( int[][] M ) {
        Random rand = new Random( );

        for (int i = 0; i < M.length; i++)
            for (int j = 0; j < M[0].length; j++)
                M[i][j] = rand.nextInt( M.length * M[0].length ) + 1;
    }

    public static void selSort2D ( int[][] M ) {
        int row = M.length;
        int col = M[0].length;
        // loop through each element in the matrix
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int mR = i, mC = j;
                // find the minimum element in the remaining matrix
                for (int k = i; k < row; k++)
                    for (int l = (k == i ? j : 0); l < col; l++)
                        if (M[k][l] < M[mR][mC]) {
                            mR = k;
                            mC = l;
                        }

                // swap the found minimum element with the current element
                int temp = M[i][j];
                M[i][j] = M[mR][mC];
                M[mR][mC] = temp;
            }
        }
    }

    public static void bubbleSort2D ( int[][] A ) {
        int rows = A.length;
        int cols = A[0].length;
        boolean sw;
        do {
            sw = false;
            // loop through each element and bubble up the largest values
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    int nR = (c == cols - 1) ? r + 1 : r;
                    int nC = (c == cols - 1) ? 0 : c + 1;

                    if (nR < rows && A[r][c] > A[nR][nC]) {
                        // swap adjacent elements if they are in the wrong order
                        int temp = A[nR][nC];
                        A[nR][nC] = A[r][c];
                        A[r][c] = temp;
                        sw = true;
                    }
                }
            }
        } while (sw);
    }

    public static void rowSort ( int[][] M ) {
        // sort each row using built-in sort
        for (int[] ints : M) Arrays.sort( ints );
    }

    public static void revSpiral ( int[][] M, int i, int t, int l, int r, int b ) {
        if (i <= 0) return;

        // fill the top row from left to right
        for (int j = l; j <= r && i >= 0; j++) M[t][j] = i--;
        t++;
        // fill the right column from top to bottom
        for (int j = t; j <= b && i >= 0; j++) M[j][r] = i--;
        r--;
        // fill the bottom row from right to left
        for (int j = r; j >= l && i >= 0; j--) M[b][j] = i--;
        b--;
        // fill left column from bottom to top
        for (int j = b; j >= t && i >= 0; j--) M[j][l] = i--;
        l++;

        revSpiral( M, i, t, l, r, b );
    }

    public static void spiral ( int[][] M, int i, int t, int l, int r, int b, int n ) {
        if (i > n) return;

        // fill the top row from left to right
        for (int j = l; j <= r && i <= n; j++) M[t][j] = i++;
        t++;
        // fill the right column from top to bottom
        for (int j = t; j <= b && i <= n; j++) M[j][r] = i++;
        r--;
        // fill the bottom row from right to left
        for (int j = r; j >= l && i <= n; j--) M[b][j] = i++;
        b--;
        // fill left column from bottom to top
        for (int j = b; j >= t && i <= n; j--) M[j][l] = i++;
        l++;

        spiral( M, i, t, l, r, b, n );
    }

    public static void saddlePoint ( int[][] A ) {
        int rows = A.length;
        int cols = A[0].length;
        for (int i = 0; i < rows; i++) {
            int minRow = A[i][0], colIndex = 0;

            // find the minimum element in the row
            for (int j = 1; j < cols; j++) {
                if (A[i][j] < minRow) {
                    minRow = A[i][j];
                    colIndex = j;
                }
            }

            boolean isSP = true;
            // check if it is the largest element in its column
            for (int[] ints : A) {
                if (ints[colIndex] > minRow) {
                    isSP = false;
                    break;
                }
            }
            // if saddle point has been found
            if (isSP)
                System.out.println( "Saddle Point @ (" + i + ", " + colIndex + "); Value: " + minRow );
        }
    }

    public static int[][] magicSquare ( int n ) {
        if (n % 2 == 0)
            throw new IllegalArgumentException( "Only odd values of n are supported." );

        int[][] M = new int[n][n];
        int num = 1, row = 0, col = n / 2;

        while (num <= n * n) {
            M[row][col] = num++;  // Place the current number and increment it

            // calculate the new row and column positions
            int nRow = (row - 1 + n) % n; // Move up one row (wrap around if necessary)
            int nCol = (col + 1) % n;     // Move right one column (wrap around if necessary)

            // if the cell is already filled, move down one row
            if (M[nRow][nCol] != 0)
                row = (row + 1) % n;
            else {
                row = nRow;
                col = nCol;
            }
        }

        return M;
    }

    public static void printBoundary ( int[][] A ) {
        int rows = A.length;
        int cols = A[0].length;

        System.out.println( "\nBoundary Elements:" );
        // print only the boundary elements
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1)
                    System.out.print( A[i][j] + "\t" );
                else
                    System.out.print( " \t" );
            System.out.println( );
        }
    }

    public static void printMirror ( int[][] M ) {
        int cols = M[0].length;

        System.out.println( "\nMirrored Matrix: " );
        // print the matrix in reverse column order
        for (int[] ints : M) {
            for (int j = 0; j < cols; j++)
                System.out.print( ints[cols - j - 1] + "\t" );
            System.out.println( );
        }
    }
}