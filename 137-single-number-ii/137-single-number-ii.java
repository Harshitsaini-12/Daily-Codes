class Solution {
    
 public int singleNumber(int[] nums) {
   int tn=-1;
   int tn1=0;
   int tn2=0;

   for(int val:nums){
     int cbtn=tn&val;
     int cbtn1=tn1&val;
     int cbtn2=tn2&val;

     tn=tn&~cbtn;
     tn1=tn1|cbtn;

     tn1=tn1&~cbtn1;
     tn2=tn2|cbtn1;

     tn2=tn2&~cbtn2;
     tn=tn|cbtn2;
   }
        
    return tn1;
     
    }
}