import java.util.HashMap;
import java.util.Scanner;

/*
 * ---- Question 1.4 from Cracking the Coding Interview (Chapter 01) ----
 *
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome reads the same forwards and backwards. A permutation is a rearrangement
 * of letters. The palindrome does not need to be a real dictionary word.
 *
 * EXAMPLE:
 *   Input:  "Tact Coa"
 *   Output: true  ("taco cat", "atco cta", etc.)
 *
 * Hints:
 *  - Do NOT generate all permutations.
 *  - Key property: in a palindrome, at most one character can have an odd count.
 *  - A hash table can be used to count occurrences in O(N) time.
 *  - For reduced space, a bit vector could be used for small alphabets.
 *
 * Approach:
 *  1) Count the frequency of each character.
 *  2) Allow at most one character to have an odd count.
 *  3) If more than one character has an odd count, it cannot be a permutation of a palindrome.
 */

public class Ex4_CheckPalindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Type the string: ");
        String s1 = sc.nextLine(); // read the input string
        sc.close();

        // Check if the string is a permutation of a palindrome
        Boolean checkPalindrome = isPalindrome(s1);

        if (checkPalindrome) {
            System.out.println("The string is permutation of a palindrome");
        } else {
            System.out.println("The string is not permutation of a palindrome");
        }
    }

    /**
     * Counts the frequency of each character in the string using a HashMap.
     * Keys: characters; Values: counts.
     */
    public static HashMap<Character, Integer> countCharHashMap(String s1) {
        char[] arr1 = s1.toCharArray(); // convert string to char array

        HashMap<Character, Integer> countCharMap = new HashMap<>();

        for (char c : arr1) {
            // If character is not yet in map, start count at 1
            if (!countCharMap.containsKey(c)) {
                countCharMap.put(c, 1);
            } else {
                // Otherwise, increment existing count
                countCharMap.put(c, countCharMap.get(c) + 1);
            }
        }
        return countCharMap;
    }

    /**
     * Checks if the given string can be rearranged to form a palindrome.
     * Rule: At most one character can have an odd frequency.
     */
    public static Boolean isPalindrome(String s1) {
        HashMap<Character, Integer> countChars = countCharHashMap(s1);

        Boolean flagOdd = false; // tracks if we've seen a char with odd count

        // Iterate through each character's count
        for (char c : countChars.keySet()) {
            // If count is odd
            if (countChars.get(c) % 2 != 0) {
                // If we've already seen an odd count, it's invalid
                if (flagOdd) {
                    return false;
                }
                // Mark that we've found one odd count
                flagOdd = true;
            }
        }
        // Passed the check: at most one odd count found
        return true;
    }
}
