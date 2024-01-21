package challenges;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalanceExpression {

    private final static List<Character> openingBrackets = Arrays.asList('{', '[', '(', '<');
    private final static List<Character> closingBrackets = Arrays.asList('}', ']', ')', '>');

    public static boolean isBalanceExpression(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char bracket : expression.toCharArray()) {

            if (isOpeningBracket(bracket)) {
                stack.push(bracket);

                if (isClosingBracket(bracket)) {
                    if (stack.isEmpty())
                        return false;

                    char openingBracket = stack.pop();
                    if (bracketsMatch(openingBracket, bracket))
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean bracketsMatch(char left, char right) {
        return (openingBrackets.indexOf(left) == closingBrackets.indexOf(right));
    }

    private static boolean isOpeningBracket(char ch) {
        return openingBrackets.contains(ch);
    }

    private static boolean isClosingBracket(char ch) {
        return closingBrackets.contains(ch);
    }

}
