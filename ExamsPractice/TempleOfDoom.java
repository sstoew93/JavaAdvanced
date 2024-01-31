package ExamsPracticeP1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class TempleOfDoom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] tools = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] substances = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] challenges = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        // Initialize stack and queue to save data
        Deque<Integer> toolsQueue = new ArrayDeque<>();
        Deque<Integer> substancesStack = new ArrayDeque<>();

        // Fill stack
        for (int tool : tools) {
            toolsQueue.offer(tool);
        }

        // Fill queue
        for (int substance : substances) {
            substancesStack.push(substance);
        }

        // Logic
        while (!substancesStack.isEmpty() && !toolsQueue.isEmpty()) {
            int tool = toolsQueue.poll();
            int substance = substancesStack.poll();
            int result = tool * substance;

            boolean challengeResolved = false;

            for (int i = 0; i < challenges.length; i++) {
                if (challenges[i] == result) {
                    challenges[i] = 0;
                    challengeResolved = true;
                    break;
                }
            }

            if (!challengeResolved) {
                tool++;
                if (substance > 1) {
                    substance--;
                    substancesStack.push(substance);
                }

                if (substance != 0) {
                    toolsQueue.offer(tool);
                }
            }

            // Printing
            boolean allChallengesResolved = Arrays.stream(challenges).allMatch(challenge -> challenge == 0);

            if (allChallengesResolved) {
                System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
                break;
            } else if (substancesStack.isEmpty()){
                System.out.println("Harry is lost in the temple. Oblivion awaits him.");
                break;
            }
        }

        // Print remaining
        if (!toolsQueue.isEmpty()) {
            System.out.println("Tools: " + toolsQueue.toString()
                    .replace("[", "")
                    .replace("]",""));
        }

        if (!substancesStack.isEmpty()) {
            System.out.println("Substances: " + substancesStack.toString()
                    .replace("[", "")
                    .replace("]",""));
        }

        if (Arrays.stream(challenges).sum() != 0) {
            System.out.println("Challenges: " + Arrays.toString(challenges)
                    .replace("[", "")
                    .replace("]",""));
        }
    }
}
