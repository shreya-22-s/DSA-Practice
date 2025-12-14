    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> s = new Stack<>();
            for (String str : tokens) {
                if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                    int v2 = s.pop();
                    int v1 = s.pop();
                    switch (str) {
                        case "+":
                            s.push(v1 + v2);
                            break;
                        case "-":
                            s.push(v1 - v2);
                            break;
                        case "*":
                            s.push(v1 * v2);
                            break;
                        case "/":
                            s.push(v1 / v2);
                            break;
                    }
                } else {
                    s.push(Integer.parseInt(str)); 
                }
            } 
            return s.pop(); 
        }
    }
