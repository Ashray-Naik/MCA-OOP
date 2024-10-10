import java.util.Random;
import java.util.Scanner;

public class SudokuGenerator {

    private static final int SIZE = 9;
    private static final int SUBGRID_SIZE = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose difficulty: 1. Easy  2. Moderate  3. Hard");
        int difficulty = scanner.nextInt();

        int[][] board = createSudokuBoard();
        int[][] solution = duplicateBoard(board);

        int numberOfCellsToRemove;
        switch (difficulty) {
            case 1:
                numberOfCellsToRemove = 20;
                break;
            case 2:
                numberOfCellsToRemove = 40;
                break;
            case 3:
                numberOfCellsToRemove = 60;
                break;
            default:
                System.out.println("Invalid selection. Exiting.");
                return; // Exiting the main method if the selection is invalid
        }

        removeCells(board, numberOfCellsToRemove);

        playGame(scanner, board, solution);
    }

    private static int[][] createSudokuBoard() {
        int[][] board = new int[SIZE][SIZE];
        Random random = new Random();
        fillBoard(board, 0, 0, random);
        return board;
    }

    private static boolean fillBoard(int[][] board, int row, int col, Random random) {
        if (row == SIZE) return true;
        if (col == SIZE) return fillBoard(board, row + 1, 0, random);
        if (board[row][col] != 0) return fillBoard(board, row, col + 1, random);

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        shuffleArray(numbers, random);

        for (int number : numbers) {
            if (isValidPlacement(board, row, col, number)) {
                board[row][col] = number;
                if (fillBoard(board, row, col + 1, random)) return true;
                board[row][col] = 0;
            }
        }
        return false;
    }

    private static void shuffleArray(Integer[] array, Random random) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }

    private static boolean isValidPlacement(int[][] board, int row, int col, int number) {
        return !isInRow(board, row, number) &&
               !isInColumn(board, col, number) &&
               !isInSubgrid(board, row, col, number);
    }

    private static boolean isInRow(int[][] board, int row, int number) {
        for (int col = 0; col < SIZE; col++) {
            if (board[row][col] == number) return true;
        }
        return false;
    }

    private static boolean isInColumn(int[][] board, int col, int number) {
        for (int row = 0; row < SIZE; row++) {
            if (board[row][col] == number) return true;
        }
        return false;
    }

    private static boolean isInSubgrid(int[][] board, int row, int col, int number) {
        int startRow = row - row % SUBGRID_SIZE;
        int startCol = col - col % SUBGRID_SIZE;
        for (int r = startRow; r < startRow + SUBGRID_SIZE; r++) {
            for (int c = startCol; c < startCol + SUBGRID_SIZE; c++) {
                if (board[r][c] == number) return true;
            }
        }
        return false;
    }

    private static int[][] duplicateBoard(int[][] original) {
        int[][] copy = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, SIZE);
        }
        return copy;
    }

    private static void playGame(Scanner scanner, int[][] puzzle, int[][] solution) {
        while (true) {
            displayBoard(puzzle);
            System.out.println("Enter ROW, COLUMN, and NUMBER (or -1 to quit and reveal solution):");
            int row = scanner.nextInt();
            if (row == -1) {
                System.out.println("Solution:");
                displayBoard(solution);
                break;
            }
            int col = scanner.nextInt();
            int num = scanner.nextInt();

            if (solution[row][col] == num) {
                puzzle[row][col] = num;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. Try again.");
            }

            if (isBoardComplete(puzzle)) {
                System.out.println("Congratulations! You've solved the puzzle.");
                break;
            }
        }
    }

    private static boolean isBoardComplete(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                if (cell == 0) return false;
            }
        }
        return true;
    }

    private static void displayBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell == 0 ? "." : cell);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void removeCells(int[][] board, int cellsToRemove) {
        Random random = new Random();
        int removed = 0;
        while (removed < cellsToRemove) {
            int row = random.nextInt(SIZE);
            int col = random.nextInt(SIZE);
            if (board[row][col] != 0) {
                board[row][col] = 0;
                removed++;
            }
        }
    }
}
