class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        display(matrix);
        reverseRows(matrix);
    }

    void display(int matrix[][]) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    private void transpose(int[][] matrix) {
        int x = 0;
        for(int i = x; i < matrix.length; i++) {
            for(int j = x; j < matrix[0].length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
            x++;
        }
    }

    private void reverseRows(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            int last = matrix[0].length-1;
            for(int j = 0;j < matrix[0].length/2; j++) {
                int temp = matrix[i][last];
                matrix[i][last] = matrix[i][j];
                matrix[i][j] = temp;
                last--;
            }
        }
    }


}
