class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer>set=new HashSet<>();
        List<Integer>list=new ArrayList<>();
        
        if(bound<=1){
            return list;
        }else if(x==1 && y==1){
            list.add(2);
            return list;
        }else if(x==1){
            for(int vy=1;vy<bound;vy*=y){
                if(set.contains(1+vy)==false){
                    set.add(1+vy);
                    list.add(1+vy);
                }
            }
        }else if(y==1){
             for(int vx=1;vx<bound;vx*=x){
                if(set.contains(1+vx)==false){
                    set.add(1+vx);
                    list.add(1+vx);
                }
            }
        }else{
            for(int vx=1;vx<bound;vx*=x){
            for(int vy=1;vy+vx<=bound;vy*=y){
                
                if(!set.contains(vx+vy)){
                    set.add(vx+vy);
                    list.add(vx+vy);
                }
            }
            
        }
        }
        
        
        return list;
    }
}