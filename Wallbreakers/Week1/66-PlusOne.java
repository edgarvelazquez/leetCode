
//Problem 66. Plus One
//https://leetcode.com/problems/plus-one/

//The solution will check if the array contains a 9, if it does it will replace it with a zero
//If the array contains only 9's it will then add a 1 to the front
class Solution {
    public int[] plusOne(int[] digits) {
    	int last =  digits.length;
    	for(int i=last-1; i>=0;i--){
    		if(digits[i]<9){ //it will check if the values are not 9 and return original array with modifications if there is any other number less than 9
    			digits[i]++;
    			return digits;
    		}
    		else{
    			digits[i]=0;//in case the value is 9 it will replace it for a zero
    		}
    	}
    	//
    	//it will only run this case if all numbers are 9
    	//example input [9] should be [1,0] since 9 becomes 0 and there cannot be leading zeros
    	//same for input [9,9,9] the anwer should be [1,0,0,0]
    	int[] answer = new int[digits.length+1];
    	answer[0]=1;
    	return answer;
        
    }
}

