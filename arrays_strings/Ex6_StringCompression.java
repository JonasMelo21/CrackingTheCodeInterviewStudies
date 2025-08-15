import java.util.HashMap;
import java.util.Scanner;

/*
 * ---- Question 1.6 from Cracking the Coding Interview (Chapter 01) ----
 *
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string "aabcccccaaa" would become "a2b1c5a3".
 * If the "compressed" string would not become smaller than the original string,
 * your method should return the original string.
 *
 * You can assume the string has only uppercase and lowercase letters (a-z).
 *
 * Hints:
 *  - Avoid repeatedly concatenating strings (inefficient). Use StringBuilder instead.
 *  - Do the easy thing first: compress the string, then compare lengths.
 *
 * Approaches in this code:
 *  1) **My Approach (HashMap)**:
 *     - Count occurrences of each character (ignoring spaces) using a HashMap.
 *     - Append each character and its count to build the compressed string.
 *     - This loses the order of characters because HashMap doesn’t guarantee insertion order.
 *
 *  2) **Book's Approach (Pointer-based)**:
 *     - Iterate through the string once.
 *     - Keep a counter for consecutive characters.
 *     - When the next character is different (or at the end), append char + count.
 *     - Return the shorter between original and compressed.
 */

public class Ex6_StringCompression {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string from user
        System.out.println("Type a string: ");
        String string1 = sc.nextLine();

        sc.close();

        // --- My Approach ---
        String compressedString = compress(string1);

        // If compressed version is not smaller, print the original
        if (compressedString.length() >= string1.length()) {
            System.out.println(string1);
        } else {
            System.out.println(compressedString);
        }

        // --- Book's Approach ---
        String compString = pointerCompress(string1);
        System.out.println(compString);
    }

    /**
     * My Approach:
     * Count total occurrences of each character (ignoring spaces) using a HashMap.
     * This approach does NOT consider the order of characters in the string.
     */
    public static String compress(String s) {
        HashMap<Character, Integer> countChar = countChar(s);
        StringBuilder compressedString = new StringBuilder();

        // Append each character and its count
        for (char c : countChar.keySet()) {
            compressedString.append(c);
            compressedString.append(countChar.get(c));
        }

        return compressedString.toString();
    }

    /**
     * Counts the occurrences of each character (ignoring spaces) in the string.
     */
    public static HashMap<Character, Integer> countChar(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') { // skip spaces
                if (!countMap.containsKey(c)) {
                    countMap.put(c, 1);
                } else {
                    countMap.put(c, countMap.get(c) + 1);
                }
            }
        }
        return countMap;
    }

    /**
     * Book's Approach:
     * Count consecutive repeating characters and append to the result.
     * This preserves character order and compresses sequences individually.
     */
    public static String pointerCompress(String s) {
        int countConsec = 0; // count of consecutive same characters
        StringBuilder compressedString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            countConsec++;

            // If next char is different or at the end, append current + count
            if ((i + 1) >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                compressedString.append(s.charAt(i));
                compressedString.append(countConsec);
                countConsec = 0; // reset counter for next sequence
            }
        }

        // Return original string if compressed is not shorter
        if (compressedString.length() >= s.length()) {
            return s;
        } else {
            return compressedString.toString();
        }
    }
}

