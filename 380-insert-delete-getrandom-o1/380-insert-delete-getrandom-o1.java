class RandomizedSet {

    Random r;
    ArrayList<Integer>ans;
    HashMap<Integer,Integer>hm;
    
    public RandomizedSet() {
        r=new Random();
        ans=new ArrayList<>();
        hm=new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(hm.containsKey(val))return false;
        
        ans.add(val);
        hm.put(val,ans.size()-1);
       
        return true;
    }
    
    public boolean remove(int val) {
        if(!hm.containsKey(val))return false;
        
        int vidx=hm.get(val);
        int lidx=ans.size()-1;
        int lval=ans.get(lidx);
        
        ans.set(vidx,lval);
        ans.set(lidx,val);
        
        hm.put(lval,vidx);
        hm.put(val,lidx);
        
        
        ans.remove(ans.size()-1);
        hm.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        int idx=r.nextInt(ans.size());
        return ans.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */