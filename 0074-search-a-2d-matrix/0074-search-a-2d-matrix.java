class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;        // number of rows
        int n = matrix[0].length;     // number of columns
        
        int low = 0;
        int high = m * n - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Map 1D index 'mid' back into 2D coordinates
            int val = matrix[mid / n][mid % n];
            
            if (val == target) {
                return true;
            } else if (val < target) {
                low = mid + 1;  // Look in the right half
            } else {
                high = mid - 1; // Look in the left half
            }
        }
        
        return false; // Target not found
    }
}