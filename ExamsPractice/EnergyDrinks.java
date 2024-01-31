package ExamsPracticeP1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Read Input
        int[] caffeineInput = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] energyInput = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        //Fill structures
        Deque<Integer> caffeineStack = new ArrayDeque<>();
        for (int i : caffeineInput) {
            caffeineStack.push(i);
        }
        Deque<Integer> energyQueue = new ArrayDeque<>();
        for (int i : energyInput) {
            energyQueue.offer(i);
        }

        //Logic
        int received = 0;
        while (!caffeineStack.isEmpty() && !energyQueue.isEmpty()) {
            int caffeine = caffeineStack.pop();
            int energy = energyQueue.poll();
            int result = caffeine * energy;

            if (result + received <= 300) {
                received += result;
            } else {
                energyQueue.offer(energy);
                received -= 30;
                if (received < 0) {
                    received = 0;
                }
            }
        }

        //Printing
        if (!energyQueue.isEmpty()) {
            String energyLeft = String.join(", ", energyQueue.toString()
                    .replace("[", "")
                    .replace("]", ""));
            System.out.println("Drinks left: " + energyLeft);
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.", received);
    }
}
