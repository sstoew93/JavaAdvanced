package ExamsPracticeP1;

import java.util.*;

public class OffroadChallenge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Reading inputs
        int[] fuel = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] consumption = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] altitude = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        // Fill queue fuel
        Deque<Integer> fuelQueue = new ArrayDeque<>();
        for (int i : fuel) {
            fuelQueue.offer(i);
        }

        // Fill consumption Stack
        Deque<Integer> consStack = new ArrayDeque<>();
        for (int i : consumption) {
            consStack.offer(i);
        }

        int altitudeCount = 0;
        int altitudeReached = 0;
        List<String> altitudes = new LinkedList<>();

        // Logic
        for (int fuelIndex = 0; fuelIndex < altitude.length; fuelIndex++) {
            altitudeCount++;

            if (!fuelQueue.isEmpty() && !consStack.isEmpty()) {
                int fuelSize = fuelQueue.peekLast();
                int consFuel = consStack.peek();
                int neededFuel = altitude[fuelIndex];

                if (fuelSize - consFuel >= neededFuel) {
                    fuelQueue.pollLast();
                    consStack.pop();

                    System.out.printf("John has reached: Altitude %d%n", altitudeCount);
                    altitudes.add("Altitude " + altitudeCount);
                    altitudeReached++;
                } else {
                    System.out.printf("John did not reach: Altitude %d%n", altitudeCount);
                    break;
                }
            }
        }

        if (altitudeReached == altitude.length) {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        } else {
            System.out.println("John failed to reach the top.");
            if (!altitudes.isEmpty()) {
                System.out.print("Reached altitudes: ");
                String result = String.join(", ", altitudes);
                System.out.println(result);
            } else {
                System.out.println("John didn't reach any altitude.");
            }
        }
    }
}
