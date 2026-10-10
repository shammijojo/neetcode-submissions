class NumMatrix {

    int[][] prefixSumMatrix;
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        prefixSumMatrix = createPrefixSumMatrix(matrix);
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        return prefixSumMatrix[row2][col2] - prefixSumMatrix[row2][col1-1]
        - prefixSumMatrix[row1-1][col2] + prefixSumMatrix[row1-1][col1-1];
    }

    private int[][] createPrefixSumMatrix(int[][] matrix) {
        int[][] prefixSumMatrix = new int[matrix.length+1][matrix[0].length+1];

        for(int i = 1 ; i <= matrix.length; i++) {
            for(int j = 1 ; j <= matrix[0].length; j++) {
                prefixSumMatrix[i][j] = prefixSumMatrix[i-1][j] +
                                        prefixSumMatrix[i][j-1] -
                                        prefixSumMatrix[i-1][j-1]
                                        +matrix[i-1][j-1];
            }
        }

        return prefixSumMatrix;

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */