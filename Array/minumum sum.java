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
