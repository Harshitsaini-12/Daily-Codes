class Solution {
public:
    int countDistinctIntegers(vector<int>& nums) {
        
        unordered_set<int>set;
        for(auto num:nums){
            set.insert(num);
        }
        
        for(auto i:nums){
            
            int num=0;
            
            while(i){
                int r=i%10;
                num=num*10+r;
                i/=10;
            }
            
            if(set.find(num)==set.end()){
                set.insert(num);
            }
        }
        
        return set.size();
    }
};