package algorithms.F51to100;

public class NQueensII {
    public int totalNQueens(int n) {
        return backTracking(new int[n], 0, n, 0);
    }

    public int backTracking(int[] solution, int row, int n, int totalNQueens) {
        for (int col = 0; col < n; col++) {
            if (isValid(solution, row, col)) {
                solution[row] = col;
                if (row == n - 1) {
                    totalNQueens += 1;
                } else {
                    totalNQueens = backTracking(solution, row + 1, n, totalNQueens);
                }
            }
        }
        return totalNQueens;
    }

    public boolean isValid(int[] solution, int row, int col) {
        if (row > 0) {
            for (int i = 0; i < row; i++) {
                if (solution[i] == col || Math.abs(i - row) == Math.abs(solution[i] - col)) {
                    return false;
                }
            }
        }
        return true;
    }
}
