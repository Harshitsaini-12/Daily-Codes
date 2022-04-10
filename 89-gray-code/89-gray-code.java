class Solution {
    public List<Integer> grayCode(int n) {
        
        if(n==1){
            List<Integer>bres=new ArrayList<>();
            bres.add(0);
            bres.add(1);
            return bres;
        }else if(n==0){
              List<Integer>bres=new ArrayList<>();
            bres.add(0);
            return bres;
        }

       List<Integer>list=grayCode(n-1);
       List<Integer>mres=new ArrayList<>();


      for(int i=0;i<list.size();i++){
          int res=list.get(i);
          mres.add(0+res);
      }

       for(int i=list.size()-1;i>=0;i--){
          int res=list.get(i);
          int mask=1<<(n-1);

          res=res|mask;

          mres.add(res);
      }
     return mres;
    }
}