class Solution {
    public String simplifyPath(String path) {
         StringBuilder ss=new StringBuilder();
        Stack<String>st=new Stack<>();
        for(int i=0;i<path.length();i++){
            if(path.charAt(i)=='/')continue;
           
            while(i<path.length()&& path.charAt(i)!='/'){
                ss.append(path.charAt(i));
                i++;
            }
            String dir = ss.toString();
            ss.setLength(0);
            if (dir.equals("..")) {
                if (!st.isEmpty()) st.pop(); // Go up one level
            } else if (!dir.equals(".") && !dir.isEmpty()) {
                st.push(dir); // Add valid directory to the stack
            }
            
        }
       StringBuilder result = new StringBuilder();
        for (String s : st) {
            result.append("/").append(s);
        }
        return result.length() > 0 ? result.toString() : "/";
    }
}
