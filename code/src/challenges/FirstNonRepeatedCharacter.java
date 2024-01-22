package challenges;

import java.util.Map;
import java.util.HashMap;

public class FirstNonRepeatedCharacter {

    public static void main(String[] args) {
        char letter = getFirstNonRepeatedCharacter("a Green apple");
        System.out.println(letter);
    }

    public static char getFirstNonRepeatedCharacter(String sentence) {
        sentence = sentence.toLowerCase();

        Map<Character, Integer> map = new HashMap<>();
        char[] letters = sentence.toCharArray();

        for (char letter : letters) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }

        for (char letter : letters) {
            if (map.get(letter) == 1)
                return letter;
        }

        return Character.MIN_VALUE;
    }
}
