1.1 
The TreeMap inside Concord keeps the entries in order.
Why can't we just use its iterator or a for-each loop to visit the values in order? 
(Hint: there's iterator code like this in the print method of Concord.)

Ans: The TreeMap is sorted according to natural ascending order of its keys
-------------------------------------------------------------------------------------------------------------------------
2.1 
Report to the TA five of the most frequently occurring words in the English language based on what you find in the results. 
(It doesn't have to be the absolute top five words.)

Ans: the , i , of , a , and .
-------------------------------------------------------------------------------------------------------------------------
2.2 
For each file report to the TA the most frequently occurring word in that file that is not one of the most frequently occurring words in the English language. 
For each of your answers, tell why it occurs so frequently in this file.

Ans: poe.out: amontillado , is a spanish word .
     melville.out: bartleby , have no idea what it is .
-------------------------------------------------------------------------------------------------------------------------
2.3 
In what order do words that have the same frequency appear in your output? 
(Look at the last part of your output file to see many examples of this.) 
Why? (Hint: look at the documentation of the sort method you called.) 
Would they be in a different order if we had used a HashMap?

Ans: The order is alphabetically.
Because the map we used is the TreeMap it in the order of key, thus the small alphabet will be ordered before the large alphabet
No , because HashMap is implemented as a hash table, and there is no ordering on keys or values.

-------------------------------------------------------------------------------------------------------------------------
3.1 
Why don't we need to save the LargeWordPred object in a variable (second call above)?

Ans: To simplify the process , since we only it once.
-------------------------------------------------------------------------------------------------------------------------
3.2 Using your results from your code and experiments above, answer the following questions: 
What are the longest non-hyphenated words occurring in each of melville.txt and poe.txt, how long are they, 
and how many times did each of them occur in the original file? (Note: there may be multiple words that are the longest.)

Ans: 
melville 15out : unreasonableness 16 1 ; obstreperousness 16 1 .
poe 15out: connoisseurship 15 1 .
-------------------------------------------------------------------------------------------------------------------------

