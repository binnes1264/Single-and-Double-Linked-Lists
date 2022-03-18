# Single-and-Double-Linked-Lists
Instructions:

Create a class called Numerology.
The fields in this class are four integers: month, day, year, and result; and one string named prediction.
the integers can be initialized to 0 and the string to NULL.
Create a class called Driver, which will create an object of Numerology whenever needed. 
Your main() method will be part of this class.
Create a method in Driver that will generate 100 random valid dates.
the month between 1 and 12.
The day will be generated according to the month but cannot exceed 1 and 31.
For example, if the month is generated to be 1 (January), the maximum day value can be 31, whereas, for April (month=4), the maximum day value will be 30.
the year will be between 1500 and 2020.
No need to worry about Leap years -- all the days for February will be between 1 and 28 regardless of the year.
Write these generated dates to a text file called "dates.txt" -- you will have to create the file first
the format will be like: month day year
one date per line
Now, create a new method in Driver that will read these dates from the "dates.txt" file.
Next, you will crunch these numbers in the same function as follows
Add Month, Day, and year and bring them to a single digit.
For example, today's date is 9 8 2021. So, you do --> 9+8+2021 = 2038 -- break it down as this is not a single-digit --> 2+0+3+8 = 13 --> 1+3 =4. You stop at 4 as it is single digit.
Create a Numerology object, where
month, day, and year will be set by the values read from the file
the result will hold the crunched single-digit number.
the prediction string will hold a "future prediction" for the crunched number.
You can pre-define the 9 possible strings for 9 possible crunched digits.
For example, if it's 1, the prediction might be "You will meet someone nice today!"
Please use your imagination for these (string) predictions.
As expected, you will have 100 numerology objects for the 100 dates that you have read from the "dates.txt" file.
Now, create a Singly-linked List (SLL) and a Doubly Linked List (DLL) to store these objects.
The object corresponding to the first date read from the "dates.txt" file will be the first node in both SLL and DLL, and so on.
Print the Numerology reports to the console (i.e., the date in MM/DD/YYYY format and the corresponding prediction) for all the dates in the lists by
traversing forward in SLL
traversing backward in DLL
Print the prediction ONLY in a text file named "predict.txt" -- you will have to create the file first -- where each line j in "predict.txt" will hold the corresponding prediction of the date in line j of "dates.txt"
You have to do it by traversing forward in SLL.
