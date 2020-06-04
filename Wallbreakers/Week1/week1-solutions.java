//Weeek 1 wallbreakers

//Problem 1. Two Sum
//https://leetcode.com/problems/two-sum/

//Solution 1-Sorted Array
//If the array is sorted this would work
//It uses to pointers, one at the start and one af the end, and it keeps
//moving right or left until the values match the target.
//This solution is log(n) since we only have to go through the array once in the worst case.
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int[] answers= new int[2];
       
        for(int i=0; i<nums.length;i++){
            
          if((nums[left]+nums[right])==target){//checks if pointers are equal to target
              answers[0]=left;
              answers[1]=right;
              return answers;
          }
           if(((nums[left]+nums[right])<target)){//moves left pointer if the sum is less than target
              left++;
          }
             if(((nums[left]+nums[right])>target)){//moves right pointer if the sum is more than target
              right--;
          }
        
        }
    }
}

//Solution 2-Optimal solution, unsorted array
//If the array is Not sorted this is an optimal solution
//I will create a hash map that stores values as it goes through the array
//It will then try to find the values in the hash map
import java.util.HashMap; 
class Solution {
    public int[] twoSum(int[] nums, int target) {
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();//HashMap to store values
    	int look=0;
    	for(int i=0; i< nums.length;i++){
    		look=target-nums[i]; //target value
    		if(map.containsKey(look)){ //check if the key is already there
    			return new int [] {map.get(look),i}; //return new array with position values
    		}else{
                map.put(nums[i],i); //if the hasmap does not contain the key add the values
            }
    	}
    	 throw new IllegalArgumentException("No solution for input"); //I could also return null

     }
}


