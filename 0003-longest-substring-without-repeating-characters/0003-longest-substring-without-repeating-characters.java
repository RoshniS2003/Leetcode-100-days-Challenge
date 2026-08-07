class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        int[] lastSeen = new int[128]; // Store last seen 1-based index
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            // Move left boundary if duplicate is within the current window
            left = Math.max(left, lastSeen[currentChar]);
            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
            // Record 1-based position
            lastSeen[currentChar] = right + 1;
        }
        
        return maxLength;
    }
}