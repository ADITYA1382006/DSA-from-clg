import java.util.*;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // If opening bracket, push to stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // If closing bracket, check top of stack
            else {
                if (stack.isEmpty()) return false; // No opening for this closing

                char top = stack.pop();

                // Check if matching pair
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        // If stack empty → all matched properly
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "(]";
        String s3 = "({[]})";
        String s4 = "([)]";

        System.out.println(s1 + " → " + isValid(s1)); // true
        System.out.println(s2 + " → " + isValid(s2)); // false
        System.out.println(s3 + " → " + isValid(s3)); // true
        System.out.println(s4 + " → " + isValid(s4)); // false
    }
}
