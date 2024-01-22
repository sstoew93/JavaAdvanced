package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Deque<String> stack = new ArrayDeque<>();
        Deque<String> forwardStack = new ArrayDeque<>();

        while (!"Home".equals(input)) {

            if ("forward".equals(input)) {

                if (forwardStack.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    stack.push(forwardStack.peek());
                    forwardStack.pop();
                    System.out.println(stack.peek());
                }
            } else if (!"back".equals(input)) {
                stack.push(input);
                System.out.println(input);
            } else if (stack.size() <= 1) {
                System.out.println("no previous URLs");
            } else {
                forwardStack.push(stack.peek());
                stack.pop();
                System.out.println(stack.peek());
            }


            input = scan.nextLine();
        }


    }
}
