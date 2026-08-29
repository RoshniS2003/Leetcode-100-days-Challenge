class Solution {
    public int compress(char[] chars) {
        int write = 0;
        int read = 0;

        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;

            // Count occurrences of current character
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            // Write character
            chars[write++] = currentChar;

            // Write length if greater than 1
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}