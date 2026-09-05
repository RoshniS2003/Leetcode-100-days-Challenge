class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = 0;
        
        for (int q : quantities) {
            right = Math.max(right, q);
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canDistribute(mid, n, quantities)) {
                right = mid; // Try finding a smaller maximum
            } else {
                left = mid + 1; // Increase x since mid is too small
            }
        }
        
        return left;
    }
    
    private boolean canDistribute(int x, int n, int[] quantities) {
        int storesNeeded = 0;
        for (int q : quantities) {
            storesNeeded += (q + x - 1) / x; // Ceiling division
            if (storesNeeded > n) {
                return false;
            }
        }
        return true;
    }
}