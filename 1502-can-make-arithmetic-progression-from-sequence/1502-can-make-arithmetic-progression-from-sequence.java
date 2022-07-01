class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n=arr.length;
        
        if (n <= 2) return true;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        
        HashSet<Integer>set=new HashSet<>();
        
        for(int val:arr){
            min=Math.min(min,val);
            max=Math.max(max,val);
            set.add(val);
        }
        
        if ((max - min) % (n- 1) != 0) return false;
        
        int d=(max-min)/(n-1);
        
        for(int i=0;i<n;i++){
            int a=min + i*d;
            
            if(!set.contains(a))return false;
        }
        return true;
        
    }
}