class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long n = grid.length;
        long N = n * n;
        
        long sumActual = 0;
        long sqSumActual = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long val = grid[i][j];
                sumActual += val;
                sqSumActual += val * val;
            }
        }
        
        long sumExpected = N * (N + 1) / 2;
        long sqSumExpected = N * (N + 1) * (2 * N + 1) / 6;
        
        // diff1 = a - b
        long diff1 = sumActual - sumExpected;
        // diff2 = a^2 - b^2 = (a - b)(a + b)
        long diff2 = sqSumActual - sqSumExpected;
        
        // sumAB = a + b
        long sumAB = diff2 / diff1;
        
        int a = (int) ((diff1 + sumAB) / 2);
        int b = (int) (a - diff1);
        
        return new int[]{a, b};
    }
}