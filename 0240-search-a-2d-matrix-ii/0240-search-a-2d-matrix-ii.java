class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Start at the top-right corner
        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            int current = matrix[row][col];

            if (current == target) {
                return true;
            } else if (current > target) {
                // Target is smaller, move left to eliminate this column
                col--;
            } else {
                // Target is larger, move down to eliminate this row
                row++;
            }
        }

        return false;
    }
}