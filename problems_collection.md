###problem1 : given 2 strings, find whether 1 is anagram of the other
solution : 
1. matain a hashmap with count of occurenace of each character. The count per character should match.
    - complexity : O(n)
2. Sort both the strings and compare.
    - complexity : O(n)
 
#####problem2 : reverse a string using stack
solution :
1. push all the elements to a stack and then pop them and store the resut in another list

#####problem3: given a expression, return true/false based on whether all '(' have matching ')' braces or not
solution:
1. In case of '(', push to the stack
2. In case of ')', pop from the stack
    - in case pop is not possible for ')', implies that no corresponding '(' was present

#####problem4: given a decimal no, return the binary implementation for the same
solution:
- divide the no repeatedly by 2 and store the remainder at each step in a stack
- continue the above till the no becomes zero
- pop out the elements from the stack and construct the string

#####problem5: extend the previous one to work for different bases also
solution:
  - problem with previous approach is that in case base is > 10, the remainder will be of 2 digits. So, need to replace instead with A/B/C/D/E/F
  - therefore, need to use a map which converts say 10 to 'A' and use the map before pushing onto the stack

#####problem6: how may 'friday the 13th' will appear between today and the next 4 years?

#####problem7: convert an infix expression to postfix expression
solution:
1. create an empty stack called opstack for keeping operands. Output goes to 'output = []'
2. token_list = input_expr.split()
3. scan the token_list from left to right:
      - if the token is an operand, append to output
      - if token is '(', push it on to the opstack
      - if token is ')', pop all the operators off the stack and append to output till '(' is hit
      - if token is operator, push to opstack. In case operator of higher or equal precendance was there, remove such operators and append to output
4. when input_expr is done, append all the operators left in opstack to output

#####problem8: evaluate postfix expression
solution:
1.create operandStack = []
2.split the expression and scan from Left to right:
    - if token is operand, push to stack
    - if token is operator, pop 2 elements and apply the operator and push back
3. At the end, only 1 element left in stack which is the result

#####problem9: check whether given html file has matching tags or not. For instance, <abc> should have </abc>

#####problem10: You have an array of english words {cat, then, the, hen, end, dog}.
Can you make out if the given sentence is a concatenation of only words from the array?
"Cathen" -> valid {cat + hen}
"thend" -> not valid
"cathenend"  -> valid {cat + then + end}

#####problem11: how do you decide whether greedy approach is applicable to a particular problem or not?

#####problem12: given a list of objects where each object holds info about a student(name and age)
                      sort them by age.
solution     : since age will always be in some range(say 1 to 100), we can use modification of counting sort and 
               bucket them based on age. Based on the bucket size, we can get the answer in 
               O(m) where m is the max bucket size
               
               In general, if some part of the problen has some paramanter bounded(for instance, age in the previous problem), 
               then no need to go for traditional sorting algos. Can instead go for some modification of the counting sort approach.



#####problems13 : all to be solved via unix clis:
     - Find the five folders in a given directory consuming the most space.
     - Report duplicate MP3s (by file contents, not file name) on a computer.
     - Take a list of names whose first and last names have been lower-cased, and properly recapitalize them.
     - Find all words in English that have x as their second letter, and n as their second-to-last.
     - Directly route your microphone input over the network to another computer's speaker.
     - Replace all spaces in a filename with underscore for a given directory.
     - Report the last ten errant accesses to the web server coming from a specific IP address.

