class Solution {
    int mod=(int)(1e9+7);
    public int countPalindromicSubsequences(String s) {
        int n=s.length();
        long[][]dp=new long[n][n];
        
        int[]next=new int[n];
        int[]prev=new int[n];
        
        HashMap<Character,Integer>hm=new HashMap<>();
        
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            
            if(!hm.containsKey(ch)){
                prev[i]=-1;
            }else{
                prev[i]=hm.get(ch);
            }
            hm.put(ch,i);
        }

		hm.clear();

		for(int i=n-1;i>=0;i--){
			char ch=s.charAt(i);

			if(hm.containsKey(ch)){
				next[i]=hm.get(ch);
			}else{
				next[i]=-1;
			}
			hm.put(ch,i);
		}
        
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<dp.length;j++,i++){
                
                if(gap==0){
                    dp[i][j]=1;
                }else if(gap==1){
                    dp[i][j]=2;
                }else{
                    char sc=s.charAt(i);
                    char ec=s.charAt(j);
                    
                    if(sc!=ec){
                        dp[i][j]=(dp[i+1][j]%mod+dp[i][j-1]%mod-dp[i+1][j-1]%mod)%mod;
                    }else{
                        int ni=next[i];
						int pi=prev[j];

						if(ni==pi){
							dp[i][j]=(2*(dp[i+1][j-1])%mod+1)%mod;
						}else if(ni>pi){
							dp[i][j]=((2*dp[i+1][j-1])%mod+2)%mod;
						}else{
							dp[i][j]=(2*(dp[i+1][j-1])%mod)%mod-(dp[ni+1][pi-1])%mod;
						}
                    }
                }
                if(dp[i][j] < 0)
                    dp[i][j] += mod;
            }
        }
        
        return (int)(dp[0][n-1])%mod;
    }
}