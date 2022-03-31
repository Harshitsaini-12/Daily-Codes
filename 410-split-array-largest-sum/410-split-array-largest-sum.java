class Solution {
    public int splitArray(int[] arr, int m) {
        int sum=0;
        int max=Integer.MIN_VALUE;

        for(int val:arr){
          max=Math.max(max,val);
          sum+=val;
        }
        
        if(arr.length==m)return max;

        int lo=max;
        int hi=sum;
        int ans=0;

        while(lo<=hi){
          int day=lo+(hi-lo)/2;

          if(isPossible(arr,day,m)){
            ans=day;
            hi=day-1;
          }else{
            lo=day+1;
          }
        }
        return ans;
    }

  public static boolean isPossible(int[]arr,int day,int m){
    int sum=0;
    int mdays=1;

    for(int i=0;i<arr.length;i++){
      sum+=arr[i];

      if(sum>day){
        sum=arr[i];
        mdays++;
      }
    }

    return mdays<=m;
  }
}