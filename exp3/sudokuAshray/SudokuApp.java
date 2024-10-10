//Author : Ashray Naik
//Roll No: 09
//Title :GUI GAME
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SudokuApp {

    private static final int GRID_DIMENSION = 9;
    private static final int SUBGRID_DIMENSION = 3;
    private int[][] currentPuzzle;
    private int[][] fullSolution;
    private JButton[][] buttonGrid;
    private JFrame mainFrame;

    public SudokuApp() {
        mainFrame = new JFrame("Sudoku Puzzle");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 600);
        mainFrame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        JButton easyBtn = new JButton("Easy");
        JButton mediumBtn = new JButton("Medium");
        JButton hardBtn = new JButton("Hard");
        JButton revealBtn = new JButton("Reveal Solution");

        topPanel.add(easyBtn);
        topPanel.add(mediumBtn);
        topPanel.add(hardBtn);
        topPanel.add(revealBtn);

        mainFrame.add(topPanel, BorderLayout.NORTH);

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(GRID_DIMENSION, GRID_DIMENSION));
        buttonGrid = new JButton[GRID_DIMENSION][GRID_DIMENSION];

        for (int row = 0; row < GRID_DIMENSION; row++) {
            for (int col = 0; col < GRID_DIMENSION; col++) {
                buttonGrid[row][col] = new JButton();
                buttonGrid[row][col].setPreferredSize(new Dimension(50, 50));
                buttonGrid[row][col].setFont(new Font("SansSerif", Font.PLAIN, 20));
                buttonGrid[row][col].setFocusPainted(false);
                buttonGrid[row][col].addActionListener(new GridButtonListener(row, col));
                gridPanel.add(buttonGrid[row][col]);
            }
        }

        mainFrame.add(gridPanel, BorderLayout.CENTER);

        easyBtn.addActionListener(e -> initializeGame(20));
        mediumBtn.addActionListener(e -> initializeGame(40));
        hardBtn.addActionListener(e -> initializeGame(60));
        revealBtn.addActionListener(e -> showCompleteSolution());

        mainFrame.setVisible(true);
    }

    private void initializeGame(int cellsToHide) {
        int[][] puzzle = createSudokuBoard();
        fullSolution = duplicateBoard(puzzle);
        removeCells(puzzle, cellsToHide);
        currentPuzzle = puzzle;
        refreshGrid();
    }

    private void showCompleteSolution() {
        displaySolution(fullSolution);
    }

    private void refreshGrid() {
        for (int row = 0; row < GRID_DIMENSION; row++) {
            for (int col = 0; col < GRID_DIMENSION; col++) {
                if (currentPuzzle[row][col] == 0) {
                    buttonGrid[row][col].setText("");
                } else {
                    buttonGrid[row][col].setText(String.valueOf(currentPuzzle[row][col]));
                }
            }
        }
    }

    private void displaySolution(int[][] solution) {
        for (int row = 0; row < GRID_DIMENSION; row++) {
            for (int col = 0; col < GRID_DIMENSION; col++) {
                buttonGrid[row][col].setText(String.valueOf(solution[row][col]));
            }
        }
    }

    private class GridButtonListener implements ActionListener {
        private final int rowIdx;
        private final int colIdx;

        public GridButtonListener(int rowIdx, int colIdx) {
            this.rowIdx = rowIdx;
            this.colIdx = colIdx;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String input = JOptionPane.showInputDialog(mainFrame, "Enter a number (1-9):");
            try {
                int number = Integer.parseInt(input);
                if (number >= 1 && number <= 9) {
                    if (fullSolution[rowIdx][colIdx] == number) {
                        currentPuzzle[rowIdx][colIdx] = number;
                        buttonGrid[rowIdx][colIdx].setText(String.valueOf(number));
                        if (isPuzzleSolved(currentPuzzle)) {
                            JOptionPane.showMessageDialog(mainFrame, "Well done! Puzzle is solved.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(mainFrame, "Incorrect number! Please try again.");
                    }
                } else {
                    JOptionPane.showMessageDialog(mainFrame, "Invalid number! Must be between 1 and 9.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainFrame, "Invalid input! Enter a valid number.");
            }
        }
    }

    private boolean isPuzzleSolved(int[][] puzzle) {
        for (int row = 0; row < GRID_DIMENSION; row++) {
            for (int col = 0; col < GRID_DIMENSION; col++) {
                if (puzzle[row][col] == 0) return false;
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SudokuApp::new);
    }
}
