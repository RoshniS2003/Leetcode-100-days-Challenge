import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // If it's an opening bracket, push to stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If it's a closing bracket, check if stack is empty
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                
                // Check if the popped opening bracket matches the current closing bracket
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        
        // If stack is empty, all brackets matched successfully
        return stack.isEmpty();
    }
}