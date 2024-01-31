package ExamsPracticeP1;

import java.util.*;

public class WormsHoles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Reading input
        int[] wormsInput = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] holesInput = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        //Initialize queue
        Deque<Integer> wormsStack = new ArrayDeque<>();
        Deque<Integer> holesQueue = new ArrayDeque<>();

        //Fill queues
        for (int worm : wormsInput) {
            wormsStack.push(worm);
        }
        for (int hole : holesInput) {
            holesQueue.offer(hole);
        }

        //Check identity
        int matchesCount = 0;
        while (!holesQueue.isEmpty() && !wormsStack.isEmpty()) {
            int worm = wormsStack.peek();
            int hole = holesQueue.peek();

            if (worm == hole) {
                wormsStack.pop();
                holesQueue.poll();

               matchesCount++;
            } else {
                holesQueue.poll();
                wormsStack.pop();
                wormsStack.push(worm - 3);
                if (wormsStack.peek() <= 0) {
                    wormsStack.pop();
                }
            }
        }

        //Count worms count
        int countWorms = 0;
        for (Integer worm : wormsStack) {
            countWorms += worm;
        }

        //Checks for printing
        if (matchesCount > 0 ) {
            System.out.printf("Matches: %d%n", matchesCount);
        } else {
            System.out.println("There are no matches.");
        }

        if (wormsStack.isEmpty()) {
            if (matchesCount == wormsInput.length) {
                System.out.println("Every worm found a suitable hole!");
            } else {
                System.out.println("Worms left: none");
            }
        } else if (countWorms > 0) {

            //Convert stack into List to reverse it
            List<Integer> wormsList = new ArrayList<>(wormsStack);
            Collections.reverse(wormsList);

            System.out.println("Worms left: " + String.join(", ", wormsList.toString().replaceAll("[\\[\\]]", "")));
        }

        if (holesQueue.isEmpty()) {
            System.out.println("Holes left: none");
        } else {
            System.out.println("Holes left: " + String.join(", ", holesQueue.toString().replaceAll("[\\[\\]]", "")));
        }
    }
}
