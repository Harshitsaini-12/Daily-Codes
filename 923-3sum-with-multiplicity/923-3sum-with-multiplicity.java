class Solution {
    public int threeSumMulti(int[] arr, int target) {
        HashMap<Integer,Long>hm=new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0l)+1);
        }
        
        long ans=0;
        
        for(Integer elem1:hm.keySet()){
            for(Integer elem2:hm.keySet()){
                int elem3=target-elem1-elem2;
                
                if(hm.containsKey(elem3)){
                    long f1=hm.get(elem1);
                    long f2=hm.get(elem2);
                    long f3=hm.get(elem3);
                    
                    if(elem1==elem2 && elem2==elem3){
                        ans+=(f1*(f1-1)*(f2-2))/6;
                    }else if(elem1==elem2 && elem2!=elem3){
                        ans+=(f1*(f1-1))/2*f3;
                    }else if(elem1<elem2 && elem2<elem3){
                        ans+=(f1*f2*f3);
                    }
                }
                 ans=ans%(1000000007);
            }
            
           
        }
        return (int)ans;
    }
}