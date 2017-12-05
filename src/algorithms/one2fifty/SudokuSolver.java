package algorithms.one2fifty;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        backTracking(board, 0, 0, board.length);
    }

    private boolean backTracking(char[][] board, int row, int column, int n) {
        if (column == n) {  //如果所有列检查完，则转到下一行
            return backTracking(board, row + 1, 0, n);
        }
        if (row == n) {  //如果所有行、列检查完，则表明数独有解
            return true;
        }
        if (board[row][column] == '.') {
            for (char num = '1'; num <= '9'; num++) {
                if (isValid(board, row, column, num, n)) {
                    board[row][column] = num;
                    if (backTracking(board, row, column + 1, n)) {
                        return true;
                    }
                    board[row][column] = '.';  //如果更改board[row][column]后无解，则回退
                }
            }
            return false;
        }
        return backTracking(board, row, column + 1, n);
    }

    private boolean isValid(char[][] board, int row, int column, char num, int n) {
        for (int i = 0; i < n; i++) {
            if (board[i][column] == num) {  //检查行
                return false;
            }
            if (board[row][i] == num) {  //检查列
                return false;
            }
        }
        //以下代码检查格
        int startRow = 3 * (row / 3);
        int startColumn = 3 * (column / 3);
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 2; j++) {
                if (board[startRow + (row + i) % 3][startColumn + (column + j) % 3] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
