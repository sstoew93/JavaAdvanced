package ExamsPracticeP1;

import java.util.*;

public class ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Read input
        int[] foods = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] staminas = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        //Fill Structures
        Deque<Integer> foodStack = new ArrayDeque<>();
        for (int i : foods) {
            foodStack.push(i);
        }
        Deque<Integer> staminaQueue = new ArrayDeque<>();
        for (int i : staminas) {
            staminaQueue.offer(i);
        }

        Deque<String> peaks = new ArrayDeque<>();
        peaks.offer("80");
        peaks.offer("90");
        peaks.offer("100");
        peaks.offer("60");
        peaks.offer("70");

        //Logic
        int days = 7;
        while (!peaks.isEmpty() && days-- > 0) {
            int food = foodStack.pop();
            int stamina = staminaQueue.poll();
            int result = food + stamina;
            String peak = peaks.poll();

            //Check result if he conquered peak
            if (result < Integer.parseInt(peak)) {
                peaks.offer(peak);
            }




        }

        //Printing
        if (peaks.isEmpty()) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        }



    }
}

