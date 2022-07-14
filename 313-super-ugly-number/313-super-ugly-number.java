class Solution {
    public class Pair implements Comparable<Pair>{
        int prime;
        int value;
        int pointer;
        
        Pair(int prime,int value,int pointer){
            this.prime=prime;
            this.value=value;
            this.pointer=pointer;
        }
        
        public int compareTo(Pair o){
            return this.value - o.value;
        }
    }
    
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        
        for(int i=0;i<primes.length;i++){
            pq.add(new Pair(primes[i],primes[i],1));
        }
        
        int dp[]=new int[n+1];
        dp[1]=1;
        
        for(int i=2;i<=n;){
            
            Pair p=pq.remove();
            if(dp[i-1]!=p.value){
                dp[i]=p.value;
                i++;
            }
            
            pq.add(new Pair(p.prime,p.prime*dp[p.pointer+1],p.pointer+1));
            
        }
        return dp[n];
    }
}