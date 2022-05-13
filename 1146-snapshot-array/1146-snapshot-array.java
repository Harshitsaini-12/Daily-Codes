class SnapshotArray {
    HashMap<Integer,Integer>[]map;
    int currentsnapId=0;

    public SnapshotArray(int length) {
        map=new HashMap[length];
        for(int i=0;i<length;i++){
            map[i]=new HashMap<>();
        }
    }
    
    public void set(int index, int val) {
        HashMap<Integer,Integer> hm=map[index];
        hm.put(currentsnapId,val);
    }
    
    public int snap() {
        currentsnapId++;
        return currentsnapId-1;
    }
    
    public int get(int index, int snap_id) {
         HashMap<Integer,Integer> hm=map[index];

          while(snap_id>=0){
             if(hm.containsKey(snap_id))
                 return hm.get(snap_id);
              else
                  snap_id--;
          }
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */