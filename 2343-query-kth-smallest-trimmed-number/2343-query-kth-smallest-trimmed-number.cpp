class Solution {
public:
    vector<int> smallestTrimmedNumbers(vector<string>& nums, vector<vector<int>>& q) {
        vector<int> ans;
        int n = nums[0].size();
        
        for(int i=0;i<q.size();i++){
            int x = q[i][0];
            int trim = q[i][1];
            vector<pair<string,int>> temp;
            
            for(int i=0;i<nums.size();i++){
                temp.push_back({nums[i].substr(n-trim),i});
            }
            
            sort(temp.begin(),temp.end());
            
            ans.push_back(temp[x-1].second);
            
        }
        return ans;
    }
};