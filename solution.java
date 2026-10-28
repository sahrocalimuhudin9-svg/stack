import java.util.Stack;

public class solution {

    public String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();

        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }

    public String removeThreeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (stack.size() >= 2 &&
                    stack.peek() == ch) {

                char last = stack.pop();

                if (!stack.isEmpty() && stack.peek() == ch) {
                    stack.pop();
                } else {
                    stack.push(last);
                    stack.push(ch);
                }

            } else {
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();

        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        solution obj = new solution();

        System.out.println("Example 1: " +
                obj.removeDuplicates("abbaca"));

        System.out.println("Example 2: " +
                obj.removeDuplicates("azxxzy"));

        System.out.println("Example 3: " +
                obj.removeDuplicates("abcd"));

        System.out.println("Example 4: " +
                obj.removeDuplicates("aabbcc"));

        System.out.println("=== Bonus ===");

        System.out.println(
                obj.removeThreeDuplicates("deeedbbcccbdaa"));
    }
}