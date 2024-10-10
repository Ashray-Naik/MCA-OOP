import java.util.Random;
import java.util.Scanner;

public class Sudoku {
    
    static int[][] puzz = {
        {1, 6, 2, 8, 5, 7, 4, 9, 3},
        {3, 9, 8, 4, 2, 1, 7, 5, 6},
        {4, 7, 5, 9, 6, 3, 2, 1, 8},
        {9, 3, 1, 5, 7, 8, 6, 4, 2},
        {5, 8, 6, 2, 3, 4, 1, 7, 9},
        {7, 2, 4, 1, 9, 6, 8, 3, 5},
        {8, 1, 9, 6, 4, 2, 3, 5, 7},
        {6, 5, 3, 7, 8, 9, 9, 2, 1},
        {2, 4, 7, 3, 1, 5, 9, 8, 6}
    };



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select The difficulty level : 1. Easy  2. Moderate  3. Hard");
        int opt = scanner.nextInt();
        int[][] puzzle;
        int[][] soln;
        puzzle = clone(puzz);
        soln = puzz;
        switch (opt) {
            case 1:
                removeele(puzzle, 20); 
                break;
            case 2:
                removeele(puzzle, 40); 
                break;
            case 3:
                removeele(puzzle, 60); //remove 60 elements
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        play(scanner, puzzle, soln);
    }




    private static int[][] clone(int[][] original) {
        int[][] clone = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            clone[i] = original[i].clone();
        }
        return clone;
    }

    private static void play(Scanner scanner, int[][] puzzle, int[][] solution) {
        while (true) {
            printpuzz(puzzle);
            System.out.println("Enter ROW, COLUMN and NUMBER ");
            System.out.println("(or -1 to QUIT and Show Solution): ");
            int row = scanner.nextInt();
            if (row == -1) {
                System.out.println("Here is the solution:");
                printpuzz(solution);
                break;
            }
            int col = scanner.nextInt();
            int num = scanner.nextInt();

            if (solution[row][col] == num) {
                puzzle[row][col] = num;
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong! Try again.");
            }

            if (complete(puzzle)) {
                System.out.println("Congratulations! You completed the puzzle.");
                break;
            }
        }
    }


    private static boolean complete(int[][] puzzle) {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                if (puzzle[i][j] == 0) return false;
            }
        }
        return true;
    }


    private static void printpuzz(int[][] puzzle) {
        for (int[] row : puzzle) {
            for (int num : row) {
                System.out.print(num == 0 ? "." : num);
                System.out.print(" ");
            }
            System.out.println();
        }
    }



    private static void removeele(int[][] puzzle, int numRemove) {
        Random rand = new Random();
        for (int i = 0; i < numRemove; i++) {
            int row, col;
            do {
                row = rand.nextInt(9);
                col = rand.nextInt(9);
            } while (puzzle[row][col] == 0);
            puzzle[row][col] = 0;
        }
    }


}
