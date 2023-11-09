//Name: Manoj Budathoki
//Assignment: Program5

import java.io.*;
import java.util.Stack;

import java.util.Scanner;

public class Program5 {
    public static String infixToPostfix(String s) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
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
    public static int precedence(char opp) {
        if (opp == '+' || opp == '-') {
            return 1;
        } else if (opp == '*' || opp == '/') {
            return 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        //using scanner
        try (Scanner ScanFile = new Scanner(new File("Program3"));
             BufferedWriter OutFile = new BufferedWriter(new FileWriter("Program5.out"))) {
            while (ScanFile.hasNextLine()) {
                String infix = ScanFile.nextLine();
                String postfix = infixToPostfix(infix);
                //System.out.println(infix + "   ->   " + postfix);
                OutFile.write(infix + "   ->   " + postfix);
                OutFile.newLine();

            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

}

