class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        int ans=0;
        
        for(int elem:answers){
            
           if(!hm.containsKey(elem)){
               ans+=elem+1;
               hm.put(elem,1);
           }else{
               hm.put(elem,hm.get(elem)+1);
           }
            
            if(hm.get(elem)==elem+1)hm.remove(elem);
        }
        return ans;
    }
}