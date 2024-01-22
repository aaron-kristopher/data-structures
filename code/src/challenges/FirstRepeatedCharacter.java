package challenges;

import java.util.Set;
import java.util.HashSet;

public class FirstRepeatedCharacter {

    public static void main(String[] args) {
        char letter = getFirstRepeatedCharacter("green apple");
        System.out.println(letter);
    }

    public static char getFirstRepeatedCharacter(String sentence) {
        Set<Character> uniqueLetters = new HashSet<>();
        char[] letters = sentence.toCharArray();

        for (char letter : letters) {
            if (uniqueLetters.contains(letter))
                return letter;

            uniqueLetters.add(letter);
        }

        return Character.MIN_VALUE;
    }

}
