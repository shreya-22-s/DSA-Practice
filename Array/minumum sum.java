/*
 🔹 Question: Same Frequency Check
 🔹 Link: https://practice.geeksforgeeks.org/problems/same-frequency-characters/0

 🔹 Description:
    Given a string `s` consisting of lowercase characters, check whether it is possible to make
    all characters have the same frequency **after removing at most one character**.

 🔹 Examples:
    Input: "aabbcc"     ➞ Output: true
    Input: "aabbc"      ➞ Output: true
    Input: "aabbcccc"   ➞ Output: false
    Input: "abc"        ➞ Output: true

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
