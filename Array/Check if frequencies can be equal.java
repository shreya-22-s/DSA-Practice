/*
 🔹 Question: Same Frequency Check
 🔹 Link: https://practice.geeksforgeeks.org/problems/same-frequency-characters/0

 Given a string s consisting only lowercase alphabetic characters, check whether it is 
 possible to remove at most one character such that the  frequency of each distinct character in
 the string becomes same. Return true if it is possible; otherwise, return false.

 Examples:

  Input: s = "xyyz"
  Output: true 
  Explanation: Removing one 'y' will make frequency of each distinct character to be 1.
 🔹 Approach:
    1. Use a HashMap to count the frequency of each character.
    2. Use another HashMap to count how many characters have each frequency.
    3. Three conditions for returning true:
       ✅ All characters have the same frequency.
       ✅ There are exactly 2 different frequencies and one occurs only once and is either:
          - Frequency = 1 (can remove one character), or
          - The difference between the frequencies is 1 and the higher one appears once.

 🔹 Time Complexity: O(n)
 🔹 Space Complexity: O(n)
*/

class Solution {
    boolean sameFreq(String s) {
        // code here
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
             map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Map<Integer,Integer> count= new HashMap<>();
       
       for (int freq : map.values()) {
            count.put(freq, count.getOrDefault(freq, 0) + 1);
        }

        if(count.size()== 1) return true;
        else if(count.size()==2){
            List<Integer> key = new ArrayList<>(count.keySet());
            int f1 = key.get(0),f2= key.get(1);
            int c1= count.get(f1), c2= count.get(f2);
            if((f1==1 && c1==1)|| (f2==1 && c2==1)){
                return true;
            }
            if((Math.abs(f1-f2)==1) && ((f1>f2 && c1==1)|| (f2>f1 && c2==1))){
                return true;
            }
        } 
       
        return false;
        
    }
}
