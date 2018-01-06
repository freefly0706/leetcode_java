package algorithms.one2fifty;

public class RotateImage {
    /*把图片分为行数/2层，然后一层层进行旋转，
    每一层有上下左右四个列，目标就是把上列放到右列，
    右列放到下列，下列放到左列，左列放回上列*/
    public void rotate(int[][] matrix) {
        int dim = matrix.length;
        for (int i = 0; i < dim / 2; i++) {
            for (int j = i; j < dim - 1 - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[dim - 1 - j][i];
                matrix[dim - 1 - j][i] = matrix[dim - 1 - i][dim - 1 - j];
                matrix[dim - 1 - i][dim - 1 - j] = matrix[j][dim - 1 - i];
                matrix[j][dim - 1 - i] = tmp;
            }
        }
    }

    /*
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
    */
}
