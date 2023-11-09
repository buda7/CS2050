//Name: Manoj Budathoki
//Assignment: Program4


import java.io.*;

public class Program4 {

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
                "42 / 9.2 / 3.1 * 6"
        };

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

    public static String infixToPostfix(String s) {
        StringBuilder postfix = new StringBuilder();
        MyLinkedStack stack = new MyLinkedStack(s.length());

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                postfix.append(c).append(" ");
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }
        return postfix.toString().trim();
    }
    public static int precedence(char opp) {
        if (opp == '+' || opp == '-') {
            return 1;
        } else if (opp == '*' || opp == '/') {
            return 2;
        }
        return 0;
    }

}
