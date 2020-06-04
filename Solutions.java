//905. Sort Array By Parity: https://leetcode.com/problems/sort-array-by-parity/description/

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] temp = new int[A.length];
        int counter=0;
        int sizeCounter=A.length-1;
        for(int i=0; i< A.length;i++){
            if(A[i]% 2 == 0){
               temp[counter]=A[i]; 
                counter++;
            }
            else{
                temp[sizeCounter]=A[i]; 
                sizeCounter--;
            }
            
        }
        return temp;
    }
}

//867. Transpose Matrix: https://leetcode.com/problems/transpose-matrix/

class Solution {
    public int[][] transpose(int[][] A) {
        int[][] B = new int[A[0].length][A.length];
        for(int i=0; i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
            B[j][i]=A[i][j];
        }
       
        }
        
        return B;
    }
}

//384. Shuffle an Array

public class Solution {
	
	int[] original;
    int[] array ;
    Random rand = new Random();
    
    public Solution(int[] nums) {
       array = nums;
        original = nums.clone();
    }
    
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
        
    }
    
     private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }
    
     private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        
        for(int i=0;i<array.length;i++){
            swapAt(i, randRange(i, array.length));
        }
        return array;
        
        
    }
}


//977. Squares of a Sorted Array

class Solution {
		public int[] sortedSquares(int[] A) {
			int[] answer = new int[A.length];
			int start = 0;
			int end = A.length - 1;
			int index=A.length - 1;
            int min=0;
            int max=0;
            
			while (start<end) {
				min = A[start] * A[start];
				max = A[end] * A[end];
				if (max > min) {
                    answer[index] = max;
                    end--;
				} // min>max
				else{
					answer[index] = min;
                    start++;
				} // max>min
                index--;
			} //while
            answer[index] = A[start]*A[start];//since either start and end will end up in the same spot
            return answer;
		}//main
	}// solution class

//141. Linked List Cycle
//Approach 1-HashSet
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
			Set<ListNode> list = new HashSet<ListNode>();

			while (head != null) {
				if (list.contains(head)) {
					return true;
				} // if
				else {
					list.add(head);
				} // else
                head = head.next;
			} // while
        return false;
		}
}
//Approach 2-Two pointers
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
		ListNode start = head;
		ListNode end = head; 
		while (end != null && end.next != null) {
            		start = start.next;
			end = end.next.next; //the nodes move first and then check
			if (end == start) {
				return true;
			}
			
		}
		return false;
	}

}

//205. Isomorphic Strings
class Solution {
    public boolean isIsomorphic(String s, String t) {
       
        HashMap<Character,Character> map= new HashMap<>();
      
        for(int i=0; i< s.length();i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }    
            }
            else{
                if(!map.containsValue(t.charAt(i))){
                    map.put(s.charAt(i), t.charAt(i));
                }
                else{
                    return false;
                }
            }
        }
        
        return true;
    }
}

//111. Minimum Depth of Binary Tree
//Reversed DFS implemented
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        else{
            return traverse(root,0);
        }
    }
    
    public int traverse(TreeNode root,int path){
        if(root.left==null&&root.right==null){
            return path +1;
        }
       if(root.right==null){
           return traverse(root.left,path+1);
       }
        if(root.left==null){
            return traverse(root.right,path+1);
        }
        return Math.min(traverse(root.left,path+1),traverse(root.right,path+1));
    }
    
}
       
    
}
