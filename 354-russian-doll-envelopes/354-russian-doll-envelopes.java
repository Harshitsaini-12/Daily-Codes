class Solution {
    public class envelopesComparator implements Comparator<int[]>{
          @Override
            public int compare(int[]a,int[]b){
                if(a[0]==b[0])return b[1]-a[1];
                else{
                    return a[0]-b[0];
                }
            }
        }
    
    public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort(envelopes,new envelopesComparator());
        return Lis(envelopes);
    }
    
    public int binary_search(int val,ArrayList<Integer>ans){
        
        int i=0;
        int j=ans.size();
        
        while(i<j){
            int mid=(i+j)/2;
            
            if(val<=ans.get(mid)){
                j=mid;
            }else{
                i=mid+1;
            }
        }
        
        return i;
    }
    
    public int Lis(int[][] envelopes){
        ArrayList<Integer>ans=new ArrayList<>();
        
        for(int i=0;i<envelopes.length;i++){
            int val=envelopes[i][1];
            
            int idx=binary_search(val,ans);
            
            if(idx==ans.size())ans.add(val);
            else{
                ans.set(idx,val);
            }
        }
        
        return ans.size();
    }
}