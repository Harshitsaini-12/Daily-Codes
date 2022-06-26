class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
         int ksum=0;
        
        for(int i=0;i<k;i++)ksum+=cardPoints[i];
        
        int sum=ksum;
        
        for(int i=k-1;i>=0;i--){
            
            sum-=cardPoints[i];
            sum+=cardPoints[cardPoints.size()-k+i];
            
            ksum=max(ksum,sum);
        }
        return ksum;
    }
};

