class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int x:answers){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int total=0;
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            int x=entry.getKey();
            int count=entry.getValue();
            int groupSize=x+1;
            int group=(int)Math.ceil((double) count/groupSize);
            total+=group*groupSize;
        }
        return total;
    }
}
