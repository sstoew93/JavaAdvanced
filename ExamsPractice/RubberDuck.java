package ExamsPracticeP1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class RubberDuck {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Read input
        int[] time = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] tasks = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        //Initialize stack and queue for data
        Deque<Integer> timeQueue = new ArrayDeque<>();
        Deque<Integer> taskStack = new ArrayDeque<>();

        //Fill structures
        for (int i : time) {
            timeQueue.offer(i);
        }
        for (int task : tasks) {
            taskStack.push(task);
        }

        //Logic
        int vaderDuck = 0;
        int thorDuck = 0;
        int blueDuck = 0;
        int yellow = 0;
        while (!timeQueue.isEmpty() && !taskStack.isEmpty()) {
            int timeElement = timeQueue.poll();
            int taskElement = taskStack.pop();
            int result = timeElement * taskElement;

            if (result >= 0 && result <= 60) {
                vaderDuck++;
            } else if (result >= 61 && result <= 120) {
                thorDuck++;
            } else if (result >= 121 && result <= 180) {
                blueDuck++;
            } else if (result >= 181 && result <= 240) {
                yellow++;
            } else {
                taskElement -= 2;
                taskStack.push(taskElement);
                timeQueue.offer(timeElement);
            }

        }

        //Printing results
        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        System.out.printf("Darth Vader Ducky: %d%n", vaderDuck);
        System.out.printf("Thor Ducky: %d%n", thorDuck);
        System.out.printf("Big Blue Rubber Ducky: %d%n", blueDuck);
        System.out.printf("Small Yellow Rubber Ducky: %d", yellow);

    }
}
