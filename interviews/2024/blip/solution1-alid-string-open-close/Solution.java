package blip;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 *     Open brackets must be closed by the same type of brackets.
 *     Open brackets must be closed in the correct order.
 *     Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Example 4:
 * Input: s = "([])"
 * Output: true
 *
 */

class Solution {
    boolean isSameGroup(char a, char b) {
        if (a == '(' && b == ')') {
            return true;
        }
        if (a == '[' && b == ']') {
            return true;
        }
        if (a == '{' && b == '}') {
            return true;
        }

        return false;
    }

    public boolean isValid(String s) {
        // validate input
        if (s == null || s.isEmpty()) { // null or empty, already valid
            return true;
        } else if (s.length() % 2 != 0) { // odd number of tokens
            return false;
        }

        char [] values = new char[s.length()];
        int i = 0;
        // process string characters
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            // if open, we push
            if ("([{".indexOf(c) != -1) {
                values[i] = s.charAt(j);
                i++;
            } else if (")}]".indexOf(c) != -1) { // if close, we pop
                if (i == 0) {
                    return false;
                }
                char previous = values[i - 1];
                // pop only if there is correspondence in token
                if (isSameGroup(previous, c)) {
                    i--;
                }
            }
        }

        // if stach is empty, string is valid
        if (i == 0) {
            return true;
        }
        // otherwise not valid

        return false;
    }

    public static void main(String[] args) {
        //String s = "()";
        String s = ")(";
        Solution solution = new Solution();
        boolean result = solution.isValid(s);
        System.out.println(result);
    }
}
