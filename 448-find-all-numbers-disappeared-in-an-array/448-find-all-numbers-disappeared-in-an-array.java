class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
          HashMap<Integer,Integer>hm=new HashMap<>();
        List<Integer> ans = new ArrayList();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],i);
        }
        
        for(int i=1;i<=nums.length;i++){
            if(hm.get(i)==null)ans.add(i);
        }
        return ans;
       
    }
}