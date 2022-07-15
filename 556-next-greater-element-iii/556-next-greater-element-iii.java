class Solution {
    public int nextGreaterElement(int n) {
        char[]arr=(n+"").toCharArray();
        
        int i=arr.length-1;
        
        while(i>0){
            if(arr[i-1]>=arr[i]){
                i--;
            }else{
                break;
            }
        }
        
        if(i==0)return -1;
        
        int idx=arr.length-1;
        
        while(idx>0){
            if(arr[idx]>arr[i-1]){
                break;
            }else{
                idx--;
            }
        }
        
        swap(arr,i-1,idx);
        int j=i+1;
        int end=arr.length-1;
        
        while(i<end){
            swap(arr,end,i);
            i++;
            end--;
        }
        
        String res=new String(arr);
        
        long sum=Long.parseLong(res);
        
        if(sum>Integer.MAX_VALUE)return -1;
        else{
            return (int)sum;
        }
        
    }
    
    void swap(char[]arr,int i,int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}