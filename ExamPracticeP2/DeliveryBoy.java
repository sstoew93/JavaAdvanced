package ExamPracticeP2;

import java.util.Arrays;
import java.util.Scanner;

public class DeliveryBoy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Read dimensions
        int[] dimensions = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        //Fill matrix with method
        char [][] matrix = fillMatrix(scan,rows,cols);

        //Find start position
        int currentRow = 0;
        int currentCol = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char currentSymbol = matrix[row][col];
                if ('B' == currentSymbol) {
                    currentRow = row;
                    currentCol = col;
                    break;
                }
            }
        }

        int startRow = currentRow;
        int startCol = currentCol;
        while (true) {
            int lastRow = currentRow;
            int lastCol = currentCol;
            switch (scan.nextLine()) {
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
                case "right":
                    currentCol++;
                    break;
                case "left":
                    currentCol--;
                    break;
            }

            if (currentRow >= 0 && currentRow < matrix.length && currentCol >= 0 && currentCol < matrix[0].length) {
                char currentField = matrix[currentRow][currentCol];

                if ('A' == currentField) {
                    matrix[currentRow][currentCol] = 'P';
                    System.out.println("Pizza is delivered on time! Next order...");
                    break;
                }

                if ('P' == currentField) {
                    matrix[currentRow][currentCol] = 'R';
                    System.out.println("Pizza is collected. 10 minutes for delivery.");
                }

                if ('-' == currentField || '.' == currentField) {
                    matrix[currentRow][currentCol] = '.';
                }

                if ('*' == currentField) {
                    currentRow = lastRow;
                    currentCol = lastCol;
                }

            } else {
                System.out.println("The delivery is late. Order is canceled.");
                matrix[startRow][startCol] = ' ';
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                return;
            }
        }

        //Print final state
        matrix[startRow][startCol] = 'B';
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
    private static char[][] fillMatrix(Scanner scan, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            char[] symbols = scan.nextLine().toCharArray();
            matrix[row] = symbols;
        }
        return matrix;
    }
}