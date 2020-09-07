# twoSum
CS245 - Lab Assignment 02 - two Sum

Author:
	Suchitoto Rose Tabares-Tarquinio

Goal:
	Given a UNSORTED array of integers, return the indices of the two numbers whose sum is equal to a given target. Return -1 if nothing a solution cannot be found.

Comments:
	Outline:
		-create object twoSum of class TwoSum
		-create array with user input and store in int array called 'arr'
		-sort user array by calling 'sort' funtion and storing in new int array called 'sortedArr'
			-sort function calls 'findSmallest' and 'swap' helper functions 
		-create int array of size 2 called 'indices' where we store values returned from 'findTwoSum' function that for loops sorted array until finds two values that sum up to the target value given by user
			-output the indices so that the user knows where to find the values that sum up to its requiered target value
			-outputs '-1' if both values are the same as this is not allowed



