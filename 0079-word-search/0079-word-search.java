class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        // Optimization 1: Character count validation
        int[] boardCounts = new int[128];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boardCounts[board[i][j]]++;
            }
        }
        
        int[] wordCounts = new int[128];
        for (char c : word.toCharArray()) {
            wordCounts[c]++;
            if (wordCounts[c] > boardCounts[c]) {
                return false; // Target word needs more letters than available
            }
        }
        
        // Optimization 2: Reverse word if tail character is rarer than head character
        if (boardCounts[word.charAt(word.length() - 1)] < boardCounts[word.charAt(0)]) {
            word = new StringBuilder(word).reverse().toString();
        }

        // Search starting positions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        if (index == word.length()) {
            return true;
        }

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#'; // Mark as visited

        boolean found = dfs(board, word, r + 1, c, index + 1) ||
                        dfs(board, word, r - 1, c, index + 1) ||
                        dfs(board, word, r, c + 1, index + 1) ||
                        dfs(board, word, r, c - 1, index + 1);

        board[r][c] = temp; // Unmark (backtrack)

        return found;
    }
}