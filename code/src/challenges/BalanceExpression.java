package challenges;

import java.util.Arrays;
import java.util.Stack;
import java.util.ArrayList;

public class BalanceExpression {

    public static boolean isBalanceExpression(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char bracket : expression.toCharArray()) {

            if (isOpeningBracket(bracket)) {
                stack.push(bracket);

                if (isClosingBracket(bracket)) {
                    if (stack.isEmpty())
                        return false;

                    char openingBracket = stack.pop();

                    if (((openingBracket) != indexOfBracket(bracket)))
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static int indexOfBracket(char bracket) {
        return switch (bracket) {
            case '{', '}' -> 0;
            case '[', ']' -> 1;
            case '(', ')' -> 2;
            case '<', '>' -> 3;
            default -> -1;
        };
    }

    private static boolean isOpeningBracket(char ch) {
        var openingBrackets = Arrays.asList('{', '[', '(', '<');
        return openingBrackets.contains(ch);
    }

    private static boolean isClosingBracket(char ch) {
        var closingBrackets = Arrays.asList('}', ']', ')', '>');
        return closingBrackets.contains(ch);
    }

}
