class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        int val=100000;int ifreq=0;
        
        for(int num:nums){
            
            if((num&1)==0){
                
               int freq=hm.getOrDefault(num,0)+1; 
               hm.put(num,freq);
            
               if(freq>ifreq || freq==ifreq && num<val){
                   val=num;
                   ifreq=freq;
               }
                
            }
        }
        
        return ifreq==0 ? -1 : val;
        
    }
}