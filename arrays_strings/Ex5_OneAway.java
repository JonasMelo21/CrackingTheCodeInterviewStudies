import java.util.Scanner;

/*
 * ---- Question 1.5 from Cracking the Coding Interview (Chapter 01) ----
 *
 * There are three types of edits that can be performed on strings:
 *  - Insert a character
 *  - Remove a character
 *  - Replace a character
 *
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 *
 * EXAMPLES:
 *   pale, ple   -> true   (remove 'a')
 *   pales, pale -> true   (insert 's')
 *   pale, bale  -> true   (replace 'p' with 'b')
 *   pale, bake  -> false
 *
 * Hints:
 *  - Start with the easy case: length difference greater than 1 → automatically false.
 *  - Insert and remove are mirror operations (just swap which string is longer).
 *  - Try to do all checks in a single pass if possible.
 *
 * Approach in this code:
 *  1) If the length difference > 1, immediately return false.
 *  2) Use HashSets to store unique characters from each string (though this isn't the most optimal method).
 *  3) Compare characters position-by-position in the shorter length.
 *  4) Count how many positions differ.
 *  5) If more than 1 difference, return false; else, true.
 */

public class Ex5_OneAway {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input first string
        System.out.println("Type the 1st string: ");
        String s1 = sc.nextLine();

        // Input second string
        System.out.println("Type the 2nd string: ");
        String s2 = sc.nextLine();

        if(s1.length() == s2.length()){
            oneReplaceEdit(s1,s2);
        }else if(s1.length() == s2.length() - 1){
            oneInsertEdit(s1,s2);
        }else if(s1.length() - 1 == s2.length()){
            oneInsertEdit(s2,s1);
        }
    }

    public static void oneReplaceEdit(String s1,String s2){
        int countDiff = 0;
        int i = 0;
        int j = 0;
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) != s2.charAt(j)){
                countDiff += 1;
            }
            i++;
            j++;
        }
        if(countDiff <= 1){
            System.out.println("String "+s1+" and s2 "+"are one edit away");
        }else{
            System.out.println("String "+s1+" and "+s2+" are not one edit away");
        }
    }

    public static void oneInsertEdit(String s1, String s2){
        int index1 = 0;
        int index2 = 0;
        while(index1 < s1.length() && index2 < s2.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(index1 != index2){
                    System.out.println("String "+s1+" and "+s2+" are not one edit away");
                    return ;
                }
                index2++;
            }else{
                index1++;
                index2++;
            }
        }
        System.out.println("String "+s1+" and "+s2+" are one edit away");
    }
}
