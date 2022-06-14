class Solution {
    public int sumOfUnique(int[] nums) {
     HashMap<Integer,Integer>hm=new HashMap<>();
        
        for(int val:nums){
            hm.put(val,hm.getOrDefault(val,0)+1);
        }
        
        int sum=0;
        for(int key:hm.keySet()){
            if(hm.get(key)==1)sum+=key;
        }
        
        return sum;
    }
}