class Solution {
    
    HashMap<Integer,Integer>hm;
    Random r;
    int top;
    
    public Solution(int n, int[] blacklist) {
        hm=new HashMap<>();
        r=new Random();
        top=n-blacklist.length;
        
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<blacklist.length;i++){
            set.add(blacklist[i]);
        }
        
        n--;
        
        for(int i=0;i<blacklist.length;i++){
            if(blacklist[i]<top){
                
                while(set.contains(n)){
                    n--;
                }
                
                hm.put(blacklist[i],n);
                n--;
            }
        }
    }
    
    public int pick() {
        int ridx=r.nextInt(top);
        
        if(hm.containsKey(ridx)){
            return hm.get(ridx);
        }
        return ridx;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */