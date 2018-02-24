package algorithms.F51to100;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<int[]> solutions = new ArrayList<>();
        backTracking(solutions, new int[n], 0, n);
        for (int[] solution : solutions) {
            List<String> tmp = new ArrayList<>();
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = '.';
                }
            }
            for (int i = 0; i < n; i++) {
                board[i][solution[i]] = 'Q';
                tmp.add(String.valueOf(board[i]));
            }
            res.add(tmp);
        }
        return res;
    }

    public void backTracking(List<int[]> solutions, int[] solution, int row, int n) {
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, solution)) {
                solution[row] = col;
                if (row == n - 1) {  // 已遍历到最后一行，则将当前结果入solutions
                    solutions.add(solution.clone());
                } else {
                    backTracking(solutions, solution, row + 1, n);
                }
            }
        }
    }

    public boolean isValid(int row, int col, int[] solution) {  // 判断当前位置是否合法
        if (row > 0) {  // k = 0时，第一行任一位置都合法
            for (int i = 0; i < row; i++) {
                // 所有皇后不能再同一列，同一对角线
                if (solution[i] == col || Math.abs(i - row) == Math.abs(solution[i] - col)) {
                    return false;
                }
            }
        }
        return true;
    }
}
