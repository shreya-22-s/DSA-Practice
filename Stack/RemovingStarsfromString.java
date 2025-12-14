class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();      
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                st.pop();   // remove previous character
            } else {
                st.push(s.charAt(i));
            }
        }      
        StringBuilder s1 = new StringBuilder();
        while (!st.isEmpty()) {
            s1.append(st.pop());
        }       
        return s1.reverse().toString();
    }
}
