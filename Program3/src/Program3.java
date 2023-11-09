//Name: Manoj Budathoki
//Assignment: Program3
import java.io.*;
//import java.util.Scanner;

public class Program3 {
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        ArrayStackClass stack = new ArrayStackClass(infix.length());

        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    private static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] expressions = {
                "4 + 6 * 3.1",
                "4 + (6 * 3.1)",
                "(4 + 6) * 3.1",
                "2 + 3 * 4",
                "2 & 3 @ 4",
                "2 + 3 % 4",
                "2.0 + 3 * 4",
                "(2.0 + 3 / 4",
                "3 + 4 * 2 / (1 - 5)",
                "3 + 4.0 * 2 / (1.0 - 5)",
                "42 / 9.2 / 3.1 * 6"};

        try (BufferedWriter OutFile = new BufferedWriter(new FileWriter("Program4.out"))) {
            for (String infix : expressions) {
                String postfix = infixToPostfix(infix);
                // System.out.println(infix + "   ->   " + postfix);
                OutFile.write(infix + "   ->   " + postfix);

                OutFile.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
