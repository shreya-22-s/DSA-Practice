class MyQueue {
 Stack<Integer>st=new Stack<>();
 Stack<Integer>st1=new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        while(st.size()>0){
            st1.push(st.pop());
        }
        int r=st1.pop();
        while(st1.size()>0){
            st.push(st1.pop());
        }
        return r;
    }
    
    public int peek() {
         while(st.size()>0){
            st1.push(st.pop());
        }
        int r1=st1.peek();
         while(st1.size()>0){
            st.push(st1.pop());
        }
        return r1; 
    }
    
    public boolean empty() {
       if(st.size()==0) return true;
       else return false; 
    }
}
