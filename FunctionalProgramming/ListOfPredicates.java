package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Reading input
        int number = Integer.parseInt(scanner.nextLine());
        List<Integer> numbersOfList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 1; i <= number; i++) {
            boolean isItDivisible = true;
            int currentNumber = i;

            for (int j = 0; j < numbersOfList.size(); j++) {
                //Initialize Predicate
                Predicate<Integer> check = n -> currentNumber % n != 0;

                if (check.test(numbersOfList.get(j))) {
                    isItDivisible = false;
                    break;
                }
            }

            //Printing
            if (isItDivisible) {
                System.out.printf("%d ", currentNumber);
            }
        }
    }
}

