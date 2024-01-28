package ExamsPractice;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Reading inputs
        int[] fuel = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] consumption = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] altitude = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        //Fill queue fuel
        Deque<Integer> fuelQueue = new ArrayDeque<>();
        for (int i : fuel) {
            fuelQueue.offer(i);
        }

        //Fill consumption Stack
        Deque<Integer> consStack = new ArrayDeque<>();
        for (int i : consumption) {
            consStack.offer(i);
        }

        int altitudeCount = 0;
        int altitudeReached = 0;
        int fuelSize = 0;
        int consFuel = 0;
        int neededFuel = 0;

        // Logic
        List<String> altitudes = new LinkedList<>();
        for (int fuelIndex = 0; fuelIndex < altitude.length; fuelIndex++) {
            altitudeCount++;
            if (fuelQueue.size() > 0 && consStack.size() > 0) {
                fuelSize = fuelQueue.peekLast();
                consFuel = consStack.peek();
                neededFuel = altitude[fuelIndex];
            }
            if (fuelSize - consFuel>= neededFuel) {
                fuelQueue.pollLast();
                consStack.pop();

                if (altitude.length == altitudeCount) {
                    System.out.printf("John has reached: Altitude %d%n", altitudeCount);
                    System.out.println("John has reached all the altitudes and managed to reach the top!");
                } else if (altitude.length > altitudeCount) {
                    System.out.printf("John has reached: Altitude %d%n", altitudeCount);
                    altitudes.add("Altitude " + altitudeCount);
                    altitudeReached++;
                }

                if (altitudeReached == 0) {
                    System.out.println("John failed to reach the top.");
                    System.out.println("John didn't reach any altitude.");
                    break;
                }

            } else {
                System.out.printf("John did not reach: Altitude %d%n", altitudeCount);
                System.out.println("John failed to reach the top.");
                break;
            }
        }

        String result = "";
        if (altitude.length != altitudeCount) {
            System.out.print("Reached altitudes: ");
            result = String.join(", ", altitudes);

        }
        System.out.println(result);

    }
}