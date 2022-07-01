// bool compare(vector<int>a,vector<int>b){
//     return a[1]>b[1];
// }
class Solution {
public:
    
    int maximumUnits(vector<vector<int>>& boxTypes, int trucksize) {
        
        // sort(boxTypes.begin(),boxTypes.end(),compare);
        
        sort(boxTypes.begin(),boxTypes.end(),[](auto&a,auto&b){
            return a[1]>b[1];
        });
        
        int totalunits=0;
        int size=boxTypes.size();
        int i=0;
        
        while(trucksize>0 && i<size){
            
            if(boxTypes[i][0]<=trucksize){
                totalunits+=(boxTypes[i][0]*boxTypes[i][1]);
                trucksize-=boxTypes[i][0];
            }else{
                
                int cantakeSize=trucksize;
                trucksize-=cantakeSize;
                
                totalunits+=(cantakeSize * boxTypes[i][1]);
            }
            
            i++;
        }
        
        return totalunits;
    }
};