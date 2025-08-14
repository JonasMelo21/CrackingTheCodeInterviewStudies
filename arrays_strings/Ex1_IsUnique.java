import java.util.HashMap;
import java.util.Scanner;

/*
 * ---- Question 1.1 from Cracking the Coding Interview (Chapter 01) ----
 *
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 *
 * Approaches:
 *  1) Sorting approach:
 *     - Sort the characters (QuickSort in-place)
 *     - Check if any two adjacent characters are the same
 *
 *  2) Hash Table approach:
 *     - Use a hash table to track seen characters
 *     - If we find a character already in the table, it's not unique
 *
 *  3) Bit Vector approach:
 *     - Works for a fixed, small domain (here: extended ASCII 0..255)
 *     - Use a bit vector to track seen characters
 *     - If a bit is already set, it's not unique
 *
 */


public class Ex1_IsUnique {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = scanner.nextLine(); 
        scanner.close();

        char[] charArray = str.toCharArray(); 
        int n = charArray.length;

        // Testing each approach

        // my approach(sorting the string and checking for adjacent duplicates)
        Boolean sortingApproach = isUniqueBySorting(charArray, 0, n-1);
        if(sortingApproach){
            System.out.println("The string "+str+" has all unique characters according to sorting approach.");
        }else if(!sortingApproach){
            System.out.println("The string "+str+" does not have all unique characters according to sorting approach.");
        }

        // bit vector approach
        Boolean bitVectorApproach = isUniqueBitVector(charArray);
        if(bitVectorApproach){
            System.out.println("The string "+str+" has all unique characters according to bit vector approach.");
        }else if(!bitVectorApproach){
            System.out.println("The string "+str+" does not have all unique characters according to bit vector approach.");
        }


        // Hash Table Approach
        Boolean isUniqueHash = isUniqueHashTable(charArray);
        if(isUniqueHash){
            System.out.println("The string "+str+" has all unique characters according to hash table approach.");
        }else if(!isUniqueHash){
            System.out.println("The string "+str+" does not have all unique characters according to hash table approach.");
        }
    }



public static Boolean isUniqueBySorting(char[] charArray,Integer startIndex,Integer endIndex){
    
    // Sorting the char array so not unique characters stand side by side
    quickSort(charArray, startIndex, endIndex);

    // searching for adjacent duplicates
    for (int i = 0; i < charArray.length - 1; i++) {
        if (charArray[i] == charArray[i + 1]) {
            return false;
        }
    }
    return true;
}


public static void quickSort(char[] charArray,Integer startIndex, Integer endIndex){
    if(startIndex < endIndex){
        Integer q = partition(charArray,startIndex,endIndex);
        quickSort(charArray,startIndex,q - 1); 
        quickSort(charArray, q + 1, endIndex);

    }    
}

public static Integer partition(char[] charArray,Integer startIndex, Integer endIndex){
    char x = charArray[endIndex];
    Integer i = startIndex - 1; 
    for(int j = startIndex;j < endIndex;j++){
        if(charArray[j] <= x){
            i++;
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
    }
    char temp = charArray[i+1];
    charArray[i+1] = charArray[endIndex];
    charArray[endIndex] = temp;
    return i + 1;
}

public static Boolean isUniqueBitVector(char[] charArray){
    // considering extended ASCII table 
    int[] bitvector = new int[256];

    for(int i =0;i < charArray.length - 1;i++){
        if(bitvector[charArray[i]] >= 1){
            return false;
        }
        bitvector[charArray[i]]++;
    }
    return true;
}

public static Boolean isUniqueHashTable(char[] charArray){
    HashMap<Character,Integer> charMap = new HashMap<>();

    for(char c: charArray){
        if(charMap.containsKey(c)){
            return false;
        }
        charMap.put(c, 1);
    }
    return true;
}

}
