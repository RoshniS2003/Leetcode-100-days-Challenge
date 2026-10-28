class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        if (len1 > len2) {
            return false;
        }
        
        int[] s1Count = new int[26];
        int[] windowCount = new int[26];
        
        // Initialize frequency arrays for s1 and the first window in s2
        for (int i = 0; i < len1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }
        
        // Check the first window
        if (matches(s1Count, windowCount)) {
            return true;
        }
        
        // Slide the window across s2
        for (int i = len1; i < len2; i++) {
            // Add new character to the right of the window
            windowCount[s2.charAt(i) - 'a']++;
            // Remove old character from the left of the window
            windowCount[s2.charAt(i - len1) - 'a']--;
            
            if (matches(s1Count, windowCount)) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean matches(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}