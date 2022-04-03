class RandomizedCollection {
    ArrayList<Integer>list;
    HashMap<Integer,HashSet<Integer>>hm;
    Random r;

    public RandomizedCollection() {
        list=new ArrayList<>();
        hm=new HashMap<>();
        r=new Random();
    }
    
    public boolean insert(int val) {
        list.add(val);
        int lidx=list.size()-1;
        
        if(hm.containsKey(val)){
            HashSet<Integer>set=hm.get(val);
            set.add(lidx);
            
            return false;
        }else{
            HashSet<Integer>set=new HashSet<>();
            set.add(lidx);
            hm.put(val,set);
            
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(!hm.containsKey(val))return false;
        
        //removing part will be done here..
        
        int lidx=list.size()-1;
        int lval=list.get(lidx);
        
        //.iterator().next() return u value of hashset first element value
        int vidx=hm.get(val).iterator().next();
        
        list.set(lidx,val);
        list.set(vidx,lval);
        
        list.remove(lidx);
        
        hm.get(val).remove(vidx);
        if(hm.get(val).size()==0){
            hm.remove(val);
        }
        
        if(hm.containsKey(lval)){
            hm.get(lval).remove(lidx);
            hm.get(lval).add(vidx);
        }
        
        return true;
    }
    
    public int getRandom() {
        //random return idx random values from the list -->(ArrayList).
        int idx=r.nextInt(list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */