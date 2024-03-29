class Solution {
    public String largestNumber(int[] nums) {
        
        String[]arr=new String[nums.length];
        
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i]+"";
        }
        
        Arrays.sort(arr,(a,b)->{
//             long n1=Long.parseLong(a+b);
//             long n2=Long.parseLong(b+a);
            
//             if(n1>n2){
//                 return 1;
//             }else if(n2>n1){
//                 return -1;
//             }else{
//                 return 0;
//             }
            String s1=a+""+b;
            String s2=b+""+a;
            return s2.compareTo(s1);
        });
        
        StringBuilder sb=new StringBuilder("");
        
        for(String s:arr){
            sb.append(s);
        }
        
          if(sb.charAt(0)=='0'){
            return "0";
          }
        
        return sb.toString();
    }
}