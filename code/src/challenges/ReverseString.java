package challenges;

import java.util.Stack;

public class ReverseString {

    public static String reverseString(String word) {
        if (word == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();
        StringBuffer reversedWord = new StringBuffer();

        for (char character : word.toCharArray()) {
            stack.push(character);
        }

        while (!stack.empty()) {
            reversedWord.append(stack.pop());
        }

        return reversedWord.toString();
    }

}
