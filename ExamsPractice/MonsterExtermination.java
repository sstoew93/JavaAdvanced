package ExamsPracticeP1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class MonsterExtermination {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Reading input
        int[] armor = Arrays.stream(scan.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] soldier = Arrays.stream(scan.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        //Initialize stack and queue
        Deque<Integer> armorQueue = new ArrayDeque<>();
        Deque<Integer> soldierStack = new ArrayDeque<>();

        //Fill structures with data
        for (int i : armor) {
            armorQueue.offer(i);
        }
        for (int i : soldier) {
            soldierStack.push(i);
        }

        //Implement logic
        int killedMonsters = 0;
        while (!armorQueue.isEmpty() && !soldierStack.isEmpty()) {
            int armorValue = armorQueue.peek();
            int soldierValue = soldierStack.peek();

            if (soldierValue > armorValue) {
                killedMonsters++;
                armorQueue.poll();
                soldierStack.pop();
                if (soldierValue - (soldierValue - armorValue) > 0 && !soldierStack.isEmpty()) {
                    soldierStack.push(soldierValue - (soldierValue - armorValue));
                }
            } else if (soldierValue == armorValue) {
                killedMonsters++;
                armorQueue.poll();
                soldierStack.pop();
            } else {
                armorQueue.poll();
                soldierStack.pop();
                if (armorValue - (armorValue - soldierValue) >0 && !armorQueue.isEmpty()) {
                    armorQueue.offer(armorValue - (armorValue - soldierValue));
                }

                if (armorQueue.isEmpty()) {
                    System.out.println("All monsters have been killed!");
                    return;
                }
                if (soldierStack.isEmpty()) {
                    System.out.println("The soldier has been defeated.");
                    System.out.printf("Total monsters killed: %d", killedMonsters);
                    return;
                }
            }
        }

        //Printing
        if (armorQueue.isEmpty()) {
            System.out.println("All monsters have been killed!");
        } else {
            System.out.println("The soldier has been defeated.");
        }
        // "Total monsters killed: {killedMonsters}"
        System.out.printf("Total monsters killed: %d", killedMonsters);
    }
}