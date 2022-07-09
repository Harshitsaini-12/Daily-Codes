class Solution {
    
    public class EnvelopeComparator implements Comparator<int[]>{
        @Override
        public int compare(int[]one,int[]two){
            if(one[0]==two[0])return two[1]-one[1];
                else{
                    return one[0]-two[0];
                }
        }
    }
    
    public int maxEnvelopes(int[][] envelopes) {
       
         Arrays.sort(envelopes,new EnvelopeComparator());
         return LIS(envelopes);
      
    }
    
    public int binary_search(int val,List<Integer>list){
        int li=0,ri=list.size();
        
        while(li<ri){
            int mid=(li+ri)/2;
            
            if(val<=list.get(mid)){
                ri=mid;
            }else{
                li=mid+1;
            }
        }
        
        return li;
    }
    
    public int LIS(int[][]arr){
          ArrayList<Integer>ans=new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            int val=arr[i][1];
            int idx=binary_search(val,ans);
            
            if(ans.size()==idx)ans.add(val);
            else{
                ans.set(idx,val);
            }
        }
        return ans.size();
    }
}