package ExamsPracticeP1;

import java.util.*;

public class ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Read input
        int[] textiles = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] medicaments = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        //Fill structures
        List<Integer> textilesList = new ArrayList<>();
        for (int textile : textiles) {
            textilesList.add(textile);
        }
        Deque<Integer> medicamentStack = new ArrayDeque<>();
        for (int medicament : medicaments) {
            medicamentStack.push(medicament);
        }

        //Logic
        int patch = 0;
        int bandage = 0;
        int medKit = 0;
        while (!medicamentStack.isEmpty() && !textilesList.isEmpty()) {
            int medicament = medicamentStack.pop();
            int textile = textilesList.get(0);
            textilesList.remove(0);
            int result = medicament + textile;

            //Checks
            if (result == 30) {
                patch++;
            } else if (result == 40) {
                bandage++;
            } else if (result == 100) {
                medKit++;
            } else if (result > 100) {
                medKit++;
                int remaining = result - 100;
                int newEl = medicamentStack.pop() + remaining;
                medicamentStack.push(newEl);
            } else {
                medicamentStack.push(medicament + 10);
            }
        }

        //Printing
        if (medicamentStack.isEmpty() && textilesList.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
            printResult(medKit,bandage,patch);
        } else if (medicamentStack.isEmpty()) {
            System.out.println("Medicaments are empty.");
            printResult(medKit,bandage,patch);
        } else if (textilesList.isEmpty()) {
            System.out.println("Textiles are empty.");
            printResult(medKit,bandage,patch);
        }

        if (textilesList.size() > 0) {
            System.out.println("Textiles left: " + textilesList.toString()
                    .replace("[", "")
                    .replace("]", ""));
        }

        if (medicamentStack.size() > 0) {
            System.out.println("Medicaments left: " + medicamentStack.toString()
                    .replace("[", "")
                    .replace("]", ""));
        }
    }
    private static void printResult(int medKit, int bandage, int patch) {
        Map<String, Integer> items = new HashMap<>();
        if (medKit > 0) {
            items.put("MedKit", medKit);
        }

        if (bandage > 0) {
            items.put("Bandage", bandage);
        }

        if (patch > 0) {
            items.put("Patch", patch);
        }

        if (!items.isEmpty()) {
            items.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                            .thenComparing(Map.Entry.comparingByKey()))
                    .forEach(entry -> System.out.printf("%s - %d%n", entry.getKey(), entry.getValue()));
        }
    }

}
