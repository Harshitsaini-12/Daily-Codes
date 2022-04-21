class Solution {
public:
    int maxProfit(vector<int>& arr) {
      int maxprofit=0;
      int minPrice=INT_MAX;
        
      for(int i=0;i<arr.size();i++){
          minPrice=min(minPrice,arr[i]);
          maxprofit=max(maxprofit,arr[i]-minPrice);
      }
        
        return maxprofit;
        
    }
};