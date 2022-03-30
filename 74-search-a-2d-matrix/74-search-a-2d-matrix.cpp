class Solution {
public:
//     bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
//         int i=0;
//         int j=matrix[0].size()-1;
        
//         while(i<matrix.size() && j>=0){
//             if(matrix[i][j]==target){
//                 return true;
//             }
            
//             if(matrix[i][j]<target){
//                 i++;
//             }else{
//                 j--;
//             }
//         }
        
//         return false;
//     }
    
     bool searchMatrix(vector<vector<int>>& matrix, int target){
         
         if(!matrix.size())return false;
         
         int n=matrix.size();
         int m=matrix[0].size();
         
         int lo=0;
         int hi=(m*n)-1;
         
         while(lo<=hi){
             int mid=(lo+(hi-lo)/2);
             
             if(matrix[mid/m][mid%m]==target){
                 return true;
             }
             if(matrix[mid/m][mid%m]<target){
                 lo=mid+1;
             }else{
                 hi=mid-1;
             }
         }
         
         return false;
     }
    
};