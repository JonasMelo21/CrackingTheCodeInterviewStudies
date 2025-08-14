import java.util.Arrays;
import java.util.Scanner;

/*
 * ----Question 1.2: CHeck Permutation -----
 * 
 * Given two strings, write a method to check if one is permutation of the other
-  
Hints:
    -   Describe what it means for two strings to be permutations of each other. Now, look at

    hat definition you provided. Can you check the strings against that definition ?
    -   There is one solution that is 0( N log N) time. Another solution uses some space, but

    is O(N) time. 
    -   Could a hash table be useful? 

    -   Two strings that are permutations should have the same characters, but in different orders. Can you make the orders the same?

Approaches:
    1 - Sort the strings and check if they're equal

    
    2 - Count characters using a bit vector

    */

public class Ex2_CheckPermutation {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read first string
        System.out.println("Type the first string");
        String s1 = sc.nextLine();
        
        // Read second string
        System.out.println("Type the second string");
        String s2 = sc.nextLine();

        sc.close();

        // Quick fail: permutations must have the same length
        if(s1.length() != s2.length()) {
            System.out.println("The strings are not permutations of each other (length mismatch)");
            return;
        }

        // Approach 1: sort both strings and compare
        Boolean isPermutationSorting = checkPermutationSorting(s1, s2);
        if(isPermutationSorting){
            System.out.println("The strings are permutations of each other (using sorting)");
        } else {
            System.out.println("The strings are not permutations of each other (using sorting)");
        }

        // Approach 2: count characters and compare frequencies
        Boolean isPermutationCount = checkPermutationCount(s1, s2);
        if(isPermutationCount){
            System.out.println("The strings are permutations of each other (using character count)");
        } else {
            System.out.println("The strings are not permutations of each other (using character count)");
        }
    }

    public static Boolean checkPermutationSorting(String s1, String s2){
        // Convert to char arrays to allow in-place sorting
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        // Sort both arrays (O(n log n))
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // If sorted arrays are equal, strings are permutations
        return Arrays.equals(arr1, arr2);
    }

    public static Boolean checkPermutationCount(String s1,String s2){
        // Frequency table for ASCII (0..255)
        int[] charCount = new int[256];

        // Count each character from s1
        for(char c1: s1.toCharArray()){
            charCount[c1]++;
        }

        // Decrement using characters from s2; any negative/zero when needed -> not a permutation
        for(char c2: s2.toCharArray()){
            if(charCount[c2] == 0) {
                // Character missing or overused compared to s1
                return false;
            }
            charCount[c2]--;
        }

        // If all counts matched to zero, strings are permutations
        return true;
    }

}
