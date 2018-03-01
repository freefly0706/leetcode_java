package algorithms.F51to100;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] spiralMatrix = new int[n][n];
        int topLeft = 0;
        int topRight = n - 1;
        int num = 1;
        while (topLeft <= topRight) {
            for (int i = topLeft; i <= topRight; i++) {  // 填充当前最上一行
                spiralMatrix[topLeft][i] = num++;
            }
            for (int i = topLeft + 1; i <= topRight; i++) {  // 填充当前最右一行
                spiralMatrix[i][topRight] = num++;
            }
            for (int i = topRight - 1; i >= topLeft; i--) {  // 填充当前最下一行
                spiralMatrix[topRight][i] = num++;
            }
            for (int i = topRight - 1; i > topLeft; i--) {  // 填充当前最左一行
                spiralMatrix[i][topLeft] = num++;
            }
            topLeft++;
            topRight--;
        }
        return spiralMatrix;
    }
}
