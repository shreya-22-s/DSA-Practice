/* Question: Next Permutation
  Platform: GFG
  Link:https://www.geeksforgeeks.org/problems/next-permutation5226/1
  Description: Given an array of integers arr[] representing a permutation,
  implement the next permutation that rearranges the numbers into the lexicographically next greater permutation.
  If no such permutation exists, rearrange the numbers into the lowest possible order (i.e., sorted in ascending order). 

Note:  A permutation of an array of integers refers to a specific arrangement of its elements in a sequence or linear order.
  Input: arr[] = [2, 4, 1, 7, 5, 0]
  Output: [2, 4, 5, 0, 1, 7]
  Explanation: The next permutation of the given array is [2, 4, 5, 0, 1, 7].
  🔹 Approach:
    1. Traverse from right to find the first decreasing element (pivot)
    2. If no such element, reverse the entire array (it's the last permutation)
    3. Otherwise, find the smallest element on the right of pivot that is greater than pivot and swap
    4. Reverse the suffix starting from pivot + 1

 🔹 Time Complexity: O(n)
 🔹 Space Complexity: O(1)*/
  // User function Template for Java

class Solution {
    void nextPermutation(int[] arr) {
       int pivot = -1;
       int n= arr.length;
       for(int i=n-2; i>=0; i--){
           if(arr[i]<arr[i+1]){
               pivot=i;
               break;
           }
        }
            if(pivot == -1){
               reverse(arr,0,n-1);
               return;
            }
           for (int i =n-1; i>pivot; i--){
               if(arr[i]>arr[pivot]){
                   swap(arr,i,pivot);
                   break;
               }
           }
         //  int p = pivot +1, m=n-1;
           reverse(arr,pivot+1,n-1);
           }
    void swap(int[] arr,int t,int r) {
                  int temp =arr[t];
                   arr[t]=arr[r];
                   arr[r]=temp;
                    }
     void reverse(int[] arr,int left,int right) {
                  while(left<right){
                      swap(arr,left++,right--);
                  }
                    }
                }
