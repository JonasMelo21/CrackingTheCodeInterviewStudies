# Arrays & Strings

## Exercises

### Ex 01: Is Unique
- Implement an algorithm to determine if a string has all unique characters. What if you cannot use any additional data structure ?
- Hints:
    - Try using a hash table
    - Could a bit vector be useful ?
    - Can you solve it in O(n log(n)) time ?
      
[Check solution in Java code clicking here](Ex1_IsUnique.java)

### Ex 02: Check Permutation
- Given two strings, write a method to check if one is permutation of the other
- Hints:
    -   Describe what it means for two strings to be permutations of each other. Now, look at
        hat definition you provided. Can you check the strings against that definition ?
    -   There is one solution that is 0( N log N) time. Another solution uses some space, but
        is O(N) time. 
    -   Could a hash table be useful? 
    -   Two strings that are permutations should have the same characters, but in different orders. Can you make the orders the same?

[Check Solution in Java code here](Ex2_CheckPermutation.java)


### Ex 04: Palindrome Permutation
-   Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation
is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.

EXAMPLE 
    -   Tact Coa
    - True (taco cat)

-   Hints:
    -   Do not generate all permutations
    -   What characteristics would a string that is a permutation of a palindrome have ?
    -   Have you tried a hash table? You should be able to get this down to 0( N) time. 
    -   Can you reduce the space usage by using a bit vector?  