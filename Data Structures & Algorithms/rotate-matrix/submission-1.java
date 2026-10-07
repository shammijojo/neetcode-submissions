class Solution {
    public void rotate(int[][] matrix) {
        transform(matrix);
        reverseRows(matrix);
    }

    private void transform(int[][] matrix) {
        int x = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = x; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            x++;
        }
    }

    private void reverseRows(int[][] matrix) {
        int mid = matrix[0].length/2;

        for(int i = 0; i < matrix.length; i++) {
            int start = 0;
            int end = matrix[0].length-1;
            while(start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }
}
