package algorithms.one2fifty;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int dim = matrix.length;
        for (int i = 1; i < dim; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int j = 0; j < dim / 2; j++) {
            for (int i = 0; i < dim; i++) {
                int back = dim - 1 - j;
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][back];
                matrix[i][back] = tmp;
            }
        }
    }
}
