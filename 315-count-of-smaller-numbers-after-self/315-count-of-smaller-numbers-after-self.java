class Solution {
    
    int[]res;
    
    public class Pair{
        int val;
        int idx;
        
        Pair(int val,int idx){
            this.val=val;
            this.idx=idx;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        int n=nums.length;
        Pair[]ans=new Pair[n];
        
        for(int i=0;i<n;i++){
            ans[i]=new Pair(nums[i],i);
        }
        
        res=new int[n];
        
        mergersort(ans,0,ans.length-1);
        
        List<Integer>myres=new ArrayList<>();
        
        for(int val:res){
            myres.add(val);
        }
        
        return myres;
    }
    
    Pair[]mergersort(Pair[]pair,int low,int high){
        
        if(low==high){
            Pair[]base=new Pair[1];
            base[0]=new Pair(pair[low].val,low);
            return base;
        }
        
        int mid=(low+high)/2;
        
        Pair[]left=mergersort(pair,low,mid);
        Pair[]right=mergersort(pair,mid+1,high);
        
        return merge2sorted(left,right);
    }
    
    public Pair[] merge2sorted(Pair[]left,Pair[]right){
        Pair[]ret=new Pair[left.length+right.length];
        
        int i=0;
        int j=0;
        int k=0;
        
        while(i<left.length && j<right.length){
            if(left[i].val>right[j].val){
                ret[k]=left[i];
                
                res[left[i].idx]+=(right.length-j);
                
                k++;
                i++;
            }else{
                ret[k]=right[j];
                k++;
                j++;
            }
        }
        
        while(i<left.length){
            ret[k]=left[i];
            k++;
            i++;
        }
        
        while(j<right.length){
            ret[k]=right[j];
            k++;
            j++;
        }
        
        return ret;
    }
    
}