class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);
            
            // If left is not alphanumeric, move forward
            if (!Character.isLetterOrDigit(cLeft)) {
                left++;
            } 
            // If right is not alphanumeric, move backward
            else if (!Character.isLetterOrDigit(cRight)) {
                right--;
            } 
            // Both are alphanumeric, compare case-insensitively
            else {
                if (Character.toLowerCase(cLeft) != Character.toLowerCase(cRight)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        
        return true;
    }
}