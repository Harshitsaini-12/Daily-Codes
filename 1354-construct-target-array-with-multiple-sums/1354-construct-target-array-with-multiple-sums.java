class Solution {
    public boolean isPossible(int[] arr) {
        long sum=0;
        PriorityQueue<Long>pq=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int val:arr){
            pq.add((long)val);
            sum+=val;
        }
        
        while(pq.peek()!=1){
            
            long elem=pq.remove();//17
            sum=sum-elem;//16
            
            if(sum<=0 || sum>=elem){
                return false;
            }
            
            elem=elem%sum;//17-16=1 --> do %sum
            pq.add(elem>0?elem:sum);//add 1
            sum=sum+elem;//sum=16+1=17
        }
        
        return true;
    }
}