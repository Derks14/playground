package dsa;

public class Recursion {

    public static void usingRecursion() {
//        System.out.println("sum of all numbers: " + sum(89));
        System.out.println("power " + power(2, 4));

        System.out.println("factorial " + factorial(0));
    }

    public static int sum(int number) {
        // base case
        if (number == 0) return 0;

        //recursive case
        return sum(number - 1 ) + number;
    }

    public static int gridPath(int rows, int columns) {
        // base case
        if (rows <= 1 || columns <= 1) return 1;

        // recursive case
        return gridPath(rows, columns - 1) + gridPath(columns - 1, rows);
    }


    public static int factorial(int n) {
        if (n < 1) return  1;
        return n * factorial(n -1 );
    }


    public static int power(int base, int exponent) {
        if (exponent < 1 ) return 1;
        return power(base, exponent - 1) * base;
    }

}
