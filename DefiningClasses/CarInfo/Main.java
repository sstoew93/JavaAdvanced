package DefiningClasses.CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Reading input
        int countCars = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= countCars ; i++) {
            //Read inputData
            String inputData = scan.nextLine();
            String[] input = inputData.split("\\s+");
            Car car = new Car();
            if (input.length == 3) {
                car = new Car(input[0],input[1],Integer.parseInt(input[2]));
            } else {
                car = new Car(input[0]);

            }

            //Printing with toString() method
            String printInfo = car.toString();
            System.out.print(printInfo);
        }
    }
}
