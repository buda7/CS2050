/*
 * Your name: Manoj Budathoki
 * Description: Program #2 - jUnit
 */

public class Program2 {
    // TODO #1: finish the method's implementation
    public static double add(double a, double b) {
        return a + b;
    }
    // TODO #2: finish the method's implementation
    public static double subtract(double a, double b) {
        return a-b;
    }
    // TODO #3: finish the method's implementation
    public static double multiply(double a, double b) {

        double result = a * b;
        if (result == 0.0 && (a != 0.0 || b != 0.0)) {
            return 0.0;
        }
        return result;
    }
       // return a*b;

   // }
    // TODO #4: finish the method's implementation
    public static double divide(double a, double b) {

        if (b == 0.0) {
            throw new ArithmeticException();
        }
        return a / b;

    }
    // TODO #5: finish the method's implementation - assume right triangle
    public static double sinOfAngle(double oppSide, double hyp) {
        return oppSide / hyp;
    }
    // TODO #6: finish the method's implementation - assume right triangle
    public static double hypOfTriangle(double sideA, double sideB) {

        return Math.sqrt(sideA * sideA + sideB * sideB);

    }
    public static void main(String[] args) {





    }
}
