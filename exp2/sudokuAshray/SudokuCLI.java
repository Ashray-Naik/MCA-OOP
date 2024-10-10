//Author : Ashray Naik
//Roll No: 09
//Title :Command Line Game
import java.util.Random;
import java.util.Scanner;

public class SudokuCLI {

    private static final int GRID_DIMENSION = 9;
    private static final int SUBGRID_DIMENSION = 3;
    private int[][] currentPuzzle;
    private int[][] fullSolution;

    public static void main(String[] args) {
        SudokuCLI sudokuCLI = new SudokuCLI();
        sudokuCLI.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Sudoku CLI!");
        System.out.println("Select Difficulty Level:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                initializeGame(20);
                break;
            case 2:
                initializeGame(40);
                break;
            case 3:
                initializeGame(60);
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
                return;
        }

        boolean gameRunning = true;
        while (gameRunning) {
            displayGrid();
            System.out.println("Enter row, column, and number (or -1 to reveal solution):");
            int row = scanner.nextInt();
            if (row == -1) {
                showCompleteSolution();
                gameRunning = false;
                continue;
            }
            int col = scanner.nextInt();
            int number = scanner.nextInt();

            if (isValidInput(row, col, number)) {
                if (fullSolution[row - 1][col - 1] == number) {
                    currentPuzzle[row - 1][col - 1] = number;
                    if (isPuzzleSolved()) {
                        displayGrid();
                        System.out.println("Congratulations! You've solved the puzzle.");
                        gameRunning = false;
                    }
                } else {
                    System.out.println("Incorrect number. Try again.");
                }
            } else {
                System.out.println("Invalid input. Row and column must be between 1-9, and number must be between 1-9.");
            }
        }

        scanner.close();
    }

    private void initializeGame(int cellsToHide) {
        int[][] puzzle = createSudokuBoard();
        fullSolution = duplicateBoard(puzzle);
        removeCells(puzzle, cellsToHide);
        currentPuzzle = puzzle;
    }

    private void showCompleteSolution() {
        System.out.println("Revealing the full solution:");
        displaySolution(fullSolution);
    }

    private void displayGrid() {
        System.out.println("Current Sudoku Puzzle:");
        for (int row = 0; row < GRID_DIMENSION; row++) {
            for (int col = 0; col < GRID_DIMENSION; col++) {
                if (currentPuzzle[row][col] == 0) {
                    System.out.print(". ");
                } else {
                    System.out.print(currentPuzzle[row][col] + " ");
                }
            }
            System.out.println();
        }
    }

    private void displaySolution(int[][] solution) {
        for (int row = 0; row < GRID_DIMENSION; row++) {
            for (int col = 0; col < GRID_DIMENSION; col++) {
                System.out.print(solution[row][col] + " ");
            }
            System.out.println();
        }
    }

    private boolean isValidInput(int row, int col, int number) {
        return row >= 1 && row <= GRID_DIMENSION && col >= 1 && col <= GRID_DIMENSION && number >= 1 && number <= 9;
    }

    private boolean isPuzzleSolved() {
        for (int row = 0; row < GRID_DIMENSION; row++) {
            for (int col = 0; col < GRID_DIMENSION; col++) {
                if (currentPuzzle[row][col] == 0) return false;
            }
        }
        return true;
    }

    private int[][] createSudokuBoard() {
        int[][] board = new int[GRID_DIMENSION][GRID_DIMENSION];
        Random random = new Random();
        fillBoard(board, 0, 0, random);
        return board;
    }

    private boolean fillBoard(int[][] board, int row, int col, Random random) {
        if (row == GRID_DIMENSION) return true;
        if (col == GRID_DIMENSION) return fillBoard(board, row + 1, 0, random);
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

    private void shuffleArray(Integer[] array, Random random) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }

    private boolean isValidPlacement(int[][] board, int row, int col, int number) {
        return !isInRow(board, row, number) &&
               !isInColumn(board, col, number) &&
               !isInSubgrid(board, row, col, number);
    }

    private boolean isInRow(int[][] board, int row, int number) {
        for (int col = 0; col < GRID_DIMENSION; col++) {
            if (board[row][col] == number) return true;
        }
        return false;
    }

    private boolean isInColumn(int[][] board, int col, int number) {
        for (int row = 0; row < GRID_DIMENSION; row++) {
            if (board[row][col] == number) return true;
        }
        return false;
    }

    private boolean isInSubgrid(int[][] board, int row, int col, int number) {
        int startRow = row - row % SUBGRID_DIMENSION;
        int startCol = col - col % SUBGRID_DIMENSION;
        for (int r = startRow; r < startRow + SUBGRID_DIMENSION; r++) {
            for (int c = startCol; c < startCol + SUBGRID_DIMENSION; c++) {
                if (board[r][c] == number) return true;
            }
        }
        return false;
    }

    private int[][] duplicateBoard(int[][] original) {
        int[][] copy = new int[GRID_DIMENSION][GRID_DIMENSION];
        for (int i = 0; i < GRID_DIMENSION; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, GRID_DIMENSION);
        }
        return copy;
    }

    private void removeCells(int[][] puzzle, int cellsToRemove) {
        Random random = new Random();
        int removed = 0;
        while (removed < cellsToRemove) {
            int row = random.nextInt(GRID_DIMENSION);
            int col = random.nextInt(GRID_DIMENSION);
            if (puzzle[row][col] != 0) {
                puzzle[row][col] = 0;
                removed++;
            }
        }
    }
}
