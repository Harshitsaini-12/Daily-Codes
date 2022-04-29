class Solution {
    public class Pair{
    int js=-1;
    int jl=-1;

    Pair(){

    }

    Pair(int js,int jl){
      this.js=js;
      this.jl=jl;
    }
  }
    
    public Pair binarySearch(int key,int []heaters){
    Pair p=new Pair();

    int i=0;
    int j=heaters.length-1;

    while(i<=j){
      int mid=(i+j)/2;

      if(heaters[mid]==key){
        p.js=heaters[mid];
        p.jl=heaters[mid];
        break;
      }else if(heaters[mid]<key){
        p.js=heaters[mid];
        i=mid+1;
      }else{
        p.jl=heaters[mid];
        j=mid-1;
      }
    }

    return p;
  }
    
    public int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(heaters);

    int ans=0;
    for(int i=0;i<houses.length;i++){
      int hl=houses[i];

      Pair p=binarySearch(hl,heaters);

      int d1=(p.js==-1)?Integer.MAX_VALUE:hl-p.js;
      int d2=(p.jl==-1)?Integer.MAX_VALUE:p.jl-hl;

      int mindis=Math.min(d1,d2);

      if(mindis>ans)ans=mindis;
    }

    return ans; 
    }
    
}