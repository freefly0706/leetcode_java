package algorithms.F1to50;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        boolean[][] grid = new boolean[3][n];
        for (int i = 0, round = 1; i < n; i++, round++) {
            boolean[] row = new boolean[n];
            boolean[] column = new boolean[n];
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    int rowIndex = board[i][j] - '1';
                    if (row[rowIndex]) {
                        return false;
                    } else {
                        row[rowIndex] = true;
                    }
                    int gridIndex = j / 3;
                    if (grid[gridIndex][rowIndex]) {
                        return false;
                    } else {
                        grid[gridIndex][rowIndex] = true;
                    }
                }
                if (board[j][i] != '.') {
                    int colIndex = board[j][i] - '1';
                    if (column[colIndex]) {
                        return false;
                    } else {
                        column[colIndex] = true;
                    }
                }
            }
            if (round == 3) {
                round = 0;
                grid = new boolean[3][n];
            }
        }
        return true;
    }
}
