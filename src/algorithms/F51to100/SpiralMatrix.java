package algorithms.F51to100;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        /**
         * 由外圈到内圈循环打印
         */
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        int topLeftIndex = 0;
        int bottomRightRow = matrix.length - 1;
        int bottomRightCol = matrix[0].length - 1;
        while (topLeftIndex <= bottomRightRow && topLeftIndex <= bottomRightCol) {
            for (int col = topLeftIndex; col <= bottomRightCol; col++) {
                res.add(matrix[topLeftIndex][col]);
            }
            for (int row = topLeftIndex + 1; row <= bottomRightRow; row++) {
                res.add(matrix[row][bottomRightCol]);
            }
            if (topLeftIndex < bottomRightRow && topLeftIndex < bottomRightCol) {  //防止同一列或同一行重复打印
                for (int col = bottomRightCol - 1; col >= topLeftIndex; col--) {
                    res.add(matrix[bottomRightRow][col]);
                }
                for (int row = bottomRightRow - 1; row > topLeftIndex; row--) {
                    res.add(matrix[row][topLeftIndex]);
                }
            }
            topLeftIndex++;
            bottomRightRow--;
            bottomRightCol--;
        }
        return res;
    }
}
